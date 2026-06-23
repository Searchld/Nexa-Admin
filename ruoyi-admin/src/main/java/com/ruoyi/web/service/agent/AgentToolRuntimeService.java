package com.ruoyi.web.service.agent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.PermissionService;
import com.ruoyi.system.domain.agent.SysAgentActionDraft;
import com.ruoyi.system.domain.agent.SysAgentApp;
import com.ruoyi.system.domain.agent.SysAgentToolCall;
import com.ruoyi.system.service.agent.ISysAgentService;

/**
 * Agent read-only tools. Tool execution happens before the async SSE task so it can
 * reuse the current Spring Security context for RuoYi permission checks.
 */
@Service
public class AgentToolRuntimeService
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String buildToolContext(SysAgentApp app, Long userId, Long sessionId, String userContent)
    {
        return buildToolContext(app, userId, sessionId, userContent, List.of());
    }

    public String buildToolContext(SysAgentApp app, Long userId, Long sessionId, String userContent, List<String> selectedToolNames)
    {
        if (app == null || !"agent".equals(app.getAppType()))
        {
            return "";
        }
        List<ToolDefinition> tools = registry();
        Set<String> selected = normalizeToolNames(selectedToolNames);
        if (selected.isEmpty())
        {
            selected.addAll(selectByKeywords(userContent));
        }
        if (selected.isEmpty())
        {
            selected.add("system_api_catalog");
        }
        List<String> results = new ArrayList<>();
        for (ToolDefinition tool : tools)
        {
            if (!selected.contains(tool.name)) continue;
            if (!hasToolAccess(tool))
            {
                results.add(logTool(tool.name, userId, sessionId, userContent, "[" + tool.displayName + "]\n无权访问。", "无权访问"));
                continue;
            }
            if ("write_action_guard".equals(tool.name))
            {
                String result = createActionDraft(userId, sessionId, userContent);
                results.add(logTool(tool.name, userId, sessionId, userContent, result, null));
                continue;
            }
            results.add(runTool(tool.name, userId, sessionId, userContent, tool.supplier));
        }
        return render(results, selected);
    }

    public String toolCatalogForPrompt()
    {
        List<Map<String, Object>> items = new ArrayList<>();
        for (ToolDefinition tool : registry())
        {
            if (!hasToolAccess(tool)) continue;
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("name", tool.name);
            item.put("displayName", tool.displayName);
            item.put("description", tool.description);
            item.put("parametersSchema", tool.parametersSchema);
            item.put("permission", tool.permission);
            item.put("readOnly", tool.readOnly);
            items.add(item);
        }
        return JSON.toJSONString(items);
    }

    public String executeWorkflowTool(Long userId, Long workflowRunId, String userContent, String toolName)
    {
        for (ToolDefinition tool : registry())
        {
            if (!tool.name.equals(toolName)) continue;
            if (!hasToolAccess(tool))
            {
                return logTool(tool.name, userId, null, workflowRunId, userContent, "[" + tool.displayName + "]\n无权访问。", "无权访问");
            }
            return runTool(tool.name, userId, null, workflowRunId, userContent, tool.supplier);
        }
        return logTool(StringUtils.defaultString(toolName, "unknown_tool"), userId, null, workflowRunId, userContent, "[工作流工具]\n工具不存在：" + toolName, "工具不存在");
    }

    private List<ToolDefinition> registry()
    {
        List<ToolDefinition> tools = new ArrayList<>();
        tools.add(tool("write_action_guard", "写操作保护", "当用户要求新增、修改、删除、导入、导出、授权、重置、清理等写操作时生成动作草稿，不直接执行。", "{}", "", false, this::writeActionGuard,
            "新增", "创建", "添加", "修改", "编辑", "删除", "移除", "导入", "导出", "清理", "清空", "重置", "分配", "授权", "禁用", "启用", "踢出", "下线", "保存", "提交", "post", "put", "delete"));
        tools.add(tool("system_api_catalog", "系统接口目录", "列出当前系统已接入 Agent 的接口、权限标识和接入状态。", "{}", "", true, this::apiCatalog,
            "接口", "api", "endpoint", "能力", "能做什么", "接入", "所有"));
        tools.add(tool("system_user_summary", "用户管理摘要", "统计用户数量并返回最近用户基础信息。", "{\"query\":\"可选，用户关键字\"}", "system:user:list", true, this::userSummary,
            "用户", "user", "账号", "账户"));
        tools.add(tool("system_role_summary", "角色管理摘要", "统计角色数量并返回最近角色基础信息。", "{}", "system:role:list", true, this::roleSummary,
            "角色", "role", "权限"));
        tools.add(tool("system_dept_summary", "部门管理摘要", "统计部门数量并返回最近部门基础信息。", "{}", "system:dept:list", true, this::deptSummary,
            "部门", "dept", "组织"));
        tools.add(tool("system_menu_summary", "菜单管理摘要", "统计菜单、目录、按钮数量并返回最近菜单。", "{}", "system:menu:list", true, this::menuSummary,
            "菜单", "menu", "路由", "按钮"));
        tools.add(tool("system_dict_summary", "字典管理摘要", "统计字典类型和字典数据数量。", "{}", "system:dict:list", true, this::dictSummary,
            "字典", "dict"));
        tools.add(tool("system_config_summary", "参数配置摘要", "统计参数配置和站点配置相关数量。", "{}", "system:config:list", true, this::configSummary,
            "参数", "配置", "站点", "config", "site"));
        tools.add(tool("system_post_summary", "岗位管理摘要", "统计岗位数量并返回最近岗位基础信息。", "{}", "system:post:list", true, this::postSummary,
            "岗位", "post"));
        tools.add(tool("model_summary", "模型与 Agent 应用摘要", "统计 AI 模型管理和 Agent 应用配置。", "{}", "system:agent:app:list,system:artbot:list", true, this::modelSummary,
            "模型", "model", "agent", "应用", "数据库", "数量", "几个"));
        tools.add(tool("device_summary", "设备管理摘要", "统计摄像头、报警器、阅读器和溜井数量。", "{}", "device:camera:list,device:alarm:list,device:reader:list", true, this::deviceSummary,
            "设备", "摄像头", "报警器", "阅读器", "溜井", "camera", "alarm", "reader"));
        tools.add(tool("cache_summary", "缓存监控摘要", "读取 Redis key 数量、版本、内存和连接客户端。", "{}", "monitor:cache:list", true, this::cacheSummary,
            "redis", "缓存", "cache", "监控"));
        tools.add(tool("notice_summary", "通知公告摘要", "统计通知公告数量并返回最近公告。", "{}", "system:notice:list", true, this::noticeSummary,
            "通知", "公告", "notice"));
        tools.add(tool("online_summary", "在线用户摘要", "统计当前 Redis 登录 token 数量。", "{}", "monitor:online:list", true, this::onlineSummary,
            "在线", "online", "登录用户"));
        tools.add(tool("login_log_summary", "登录日志摘要", "统计登录日志并返回最近记录。", "{}", "monitor:logininfor:list", true, this::loginLogSummary,
            "登录日志", "logininfor", "登录记录"));
        tools.add(tool("oper_log_summary", "操作日志摘要", "统计操作日志并返回最近审计记录。", "{}", "monitor:operlog:list", true, this::operLogSummary,
            "操作日志", "operlog", "审计"));
        tools.add(tool("server_summary", "服务监控摘要", "读取 JVM、内存和操作系统摘要。", "{}", "monitor:server:list", true, this::serverSummary,
            "服务", "服务器", "server", "jvm", "内存"));
        tools.add(tool("job_summary", "定时任务摘要", "统计定时任务、状态和任务日志数量。", "{}", "monitor:job:list", true, this::jobSummary,
            "定时", "任务", "job", "调度", "quartz"));
        tools.add(tool("generator_summary", "代码生成摘要", "统计代码生成表并返回最近生成配置。", "{}", "tool:gen:list", true, this::generatorSummary,
            "代码生成", "生成器", "gen", "表"));
        tools.add(tool("agent_platform_summary", "AI Agent 平台摘要", "统计 Agent 应用、知识库、文档、切片、工作流和工具调用日志。", "{}", "system:agent:app:list,system:agent:kb:list,system:agent:workflow:list,system:agent:log:list", true, this::agentPlatformSummary,
            "知识库", "rag", "文档", "切片", "workflow", "工作流", "调用日志"));
        tools.add(tool("system_overview", "系统总览", "汇总系统管理、监控、设备和 Agent 平台核心数量。", "{}", "", true, this::systemOverview,
            "系统", "平台", "全部", "所有", "汇总", "概览", "总览"));
        return tools;
    }

    private Set<String> selectByKeywords(String userContent)
    {
        Set<String> selected = new HashSet<>();
        String text = StringUtils.defaultString(userContent).toLowerCase();
        for (ToolDefinition tool : registry())
        {
            if (match(text, tool.keywords.toArray(new String[0])))
            {
                selected.add(tool.name);
            }
        }
        return selected;
    }

    private Set<String> normalizeToolNames(List<String> selectedToolNames)
    {
        Set<String> names = new HashSet<>();
        if (selectedToolNames == null) return names;
        Set<String> registered = new HashSet<>();
        for (ToolDefinition tool : registry())
        {
            registered.add(tool.name);
        }
        for (String name : selectedToolNames)
        {
            if (registered.contains(name))
            {
                names.add(name);
            }
        }
        return names;
    }

    private String render(List<String> results, Set<String> selectedToolNames)
    {
        StringBuilder context = new StringBuilder();
        context.append("你是系统内置 AI Agent。本次已按工具注册中心选择并执行工具：")
            .append(JSON.toJSONString(selectedToolNames)).append("。")
            .append("优先使用工具结果回答，不要再声称无法连接数据库或无法访问系统。")
            .append("没有工具结果支撑的信息不要编造；写入、删除、批量修改和权限变更只能给建议，不能声称已经执行。\n");
        for (String result : results)
        {
            if (StringUtils.isNotEmpty(result))
            {
                context.append("\n").append(result).append("\n");
            }
        }
        return context.toString();
    }

    private ToolDefinition tool(String name, String displayName, String description, String parametersSchema, String permission, boolean readOnly, ToolSupplier supplier, String... keywords)
    {
        return new ToolDefinition(name, displayName, description, parametersSchema, permission, readOnly, supplier, List.of(keywords));
    }

    private boolean hasToolAccess(ToolDefinition tool)
    {
        return StringUtils.isEmpty(tool.permission) || hasAny(tool.permission);
    }

    private String logTool(String toolName, Long userId, Long sessionId, String userContent, String result, String error)
    {
        return logTool(toolName, userId, sessionId, null, userContent, result, error);
    }

    private String logTool(String toolName, Long userId, Long sessionId, Long workflowRunId, String userContent, String result, String error)
    {
        SysAgentToolCall call = new SysAgentToolCall();
        call.setUserId(userId);
        call.setSessionId(sessionId);
        call.setWorkflowRunId(workflowRunId);
        call.setToolName(toolName);
        call.setArgumentsJson(JSONObject.of("query", userContent).toJSONString());
        call.setResultSummary(abbreviateForColumn(result, 900));
        call.setElapsedMs(0L);
        call.setErrorMsg(abbreviateForColumn(error, 900));
        agentService.insertToolCall(call);
        return result;
    }

    private String writeActionGuard()
    {
        return "[写操作保护]\n当前 Agent 已接入系统接口目录和只读查询能力。新增、修改、删除、导入、导出、清理缓存、踢出在线用户、重置密码、分配权限等写操作第一版不由 Agent 直接执行；Agent 只能生成操作草稿、影响范围和需要人工确认的步骤。";
    }

    private String createActionDraft(Long userId, Long sessionId, String userContent)
    {
        SysAgentActionDraft draft = new SysAgentActionDraft();
        draft.setUserId(userId);
        draft.setSessionId(sessionId);
        draft.setStatus("pending");
        draft.setArgumentsJson(JSONObject.of("query", userContent).toJSONString());
        draft.setActionDesc("用户原始请求：" + abbreviate(userContent, 400));
        String text = StringUtils.defaultString(userContent).toLowerCase();
        if (match(text, "刷新", "重置") && match(text, "字典", "dict"))
        {
            draft.setActionType("refresh_dict_cache");
            draft.setActionTitle("刷新字典缓存");
            draft.setRequiredPerms("system:dict:remove");
            draft.setExecutable("1");
        }
        else if (match(text, "清理", "清空") && match(text, "缓存", "cache", "redis") && match(text, "全部", "所有", "all"))
        {
            draft.setActionType("clear_all_cache");
            draft.setActionTitle("清空全部缓存");
            draft.setRequiredPerms("monitor:cache:remove");
            draft.setExecutable("1");
            draft.setActionDesc(draft.getActionDesc() + "。该操作会删除 Redis 全部 key，可能导致当前登录失效。");
        }
        else if (match(text, "已读", "markread") && match(text, "公告", "通知", "notice", "全部", "所有"))
        {
            draft.setActionType("notice_mark_read_all");
            draft.setActionTitle("全部通知公告标记已读");
            draft.setRequiredPerms("");
            draft.setExecutable("1");
        }
        else
        {
            draft.setActionType("manual_write_action");
            draft.setActionTitle("写操作人工确认草稿");
            draft.setRequiredPerms("");
            draft.setExecutable("0");
            draft.setActionDesc(draft.getActionDesc() + "。该动作暂未开放自动执行，请由管理员在对应业务页面人工处理。");
        }
        agentService.insertActionDraft(draft);
        return "[动作确认草稿]\n" + JSON.toJSONString(draft);
    }

    private String apiCatalog()
    {
        Map<String, Object> catalog = new LinkedHashMap<>();
        catalog.put("系统管理", List.of(
            api("用户管理", "/system/user/list", "system:user:list", "只读摘要已接入"),
            api("角色管理", "/system/role/list", "system:role:list", "只读摘要已接入"),
            api("菜单管理", "/system/menu/list", "system:menu:list", "只读摘要已接入"),
            api("部门管理", "/system/dept/list", "system:dept:list", "只读摘要已接入"),
            api("岗位管理", "/system/post/list", "system:post:list", "只读摘要已接入"),
            api("字典管理", "/system/dict/type/list", "system:dict:list", "只读摘要已接入"),
            api("参数/站点配置", "/system/config/list", "system:config:list", "只读摘要已接入"),
            api("通知公告", "/system/notice/list", "system:notice:list", "只读摘要已接入"),
            api("AI模型管理", "/system/artbot/model/list", "system:artbot:list", "兼容只读摘要已接入")
        ));
        catalog.put("系统监控", List.of(
            api("在线用户", "/monitor/online/list", "monitor:online:list", "只读摘要已接入"),
            api("操作日志", "/monitor/operlog/list", "monitor:operlog:list", "只读摘要已接入"),
            api("登录日志", "/monitor/logininfor/list", "monitor:logininfor:list", "只读摘要已接入"),
            api("服务监控", "/monitor/server", "monitor:server:list", "只读摘要已接入"),
            api("缓存监控", "/monitor/cache", "monitor:cache:list", "只读摘要已接入"),
            api("定时任务", "/monitor/job/list", "monitor:job:list", "只读摘要已接入")
        ));
        catalog.put("设备管理", List.of(
            api("摄像头管理", "/device/camera/list", "device:camera:list", "只读摘要已接入"),
            api("报警器管理", "/device/alarm/list", "device:alarm:list", "只读摘要已接入"),
            api("阅读器管理", "/device/reader/list", "device:reader:list", "只读摘要已接入"),
            api("溜井选项", "/device/chute/options", "device:camera:list 或 device:alarm:list 或 device:reader:list", "只读摘要已接入")
        ));
        catalog.put("系统工具", List.of(
            api("代码生成", "/tool/gen/list", "tool:gen:list", "只读摘要已接入"),
            api("接口文档", "/v3/api-docs", "登录态访问", "Agent 可说明接口目录，不直接绕过权限")
        ));
        catalog.put("AI Agent", List.of(
            api("Agent应用", "/system/agent/app/list", "system:agent:app:list", "只读摘要已接入"),
            api("知识库", "/system/agent/kb/list", "system:agent:kb:list", "只读摘要已接入"),
            api("RAG检索", "/system/agent/rag/search", "system:agent:rag:search", "聊天链路可用"),
            api("工作流", "/system/agent/workflow/list", "system:agent:workflow:list", "只读摘要已接入"),
            api("工具调用日志", "/system/agent/tool-call/list", "system:agent:log:list", "只读摘要已接入")
        ));
        return "[系统接口目录]\n" + JSON.toJSONString(catalog);
    }

    private String runTool(String toolName, Long userId, Long sessionId, String userContent, ToolSupplier supplier)
    {
        return runTool(toolName, userId, sessionId, null, userContent, supplier);
    }

    private String runTool(String toolName, Long userId, Long sessionId, Long workflowRunId, String userContent, ToolSupplier supplier)
    {
        long start = System.currentTimeMillis();
        String result = null;
        String error = null;
        try
        {
            result = supplier.get();
            return result;
        }
        catch (Exception e)
        {
            error = e.getMessage();
            result = "[" + toolName + "] 工具调用失败：" + StringUtils.defaultString(error, "未知错误");
            return result;
        }
        finally
        {
            SysAgentToolCall call = new SysAgentToolCall();
            call.setUserId(userId);
            call.setSessionId(sessionId);
            call.setWorkflowRunId(workflowRunId);
            call.setToolName(toolName);
            call.setArgumentsJson(JSONObject.of("query", userContent).toJSONString());
            call.setResultSummary(abbreviateForColumn(result, 900));
            call.setElapsedMs(System.currentTimeMillis() - start);
            call.setErrorMsg(abbreviateForColumn(error, 900));
            agentService.insertToolCall(call);
        }
    }

    private String modelSummary()
    {
        if (!hasAny("system:agent:app:list,system:artbot:list"))
        {
            return "[模型配置摘要]\n无权访问模型配置摘要。";
        }
        StringBuilder summary = new StringBuilder("[模型配置摘要]\n");
        if (tableExists("sys_artbot_model"))
        {
            Long count = count("select count(*) from sys_artbot_model");
            summary.append("AI 模型管理数量：").append(count).append(" 个。\n");
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "select model_name, model_code, status from sys_artbot_model order by model_id desc limit 10");
            summary.append("最近模型：").append(JSON.toJSONString(rows)).append("\n");
        }
        if (tableExists("sys_agent_app"))
        {
            Long count = count("select count(*) from sys_agent_app where del_flag = '0'");
            summary.append("Agent 应用数量：").append(count).append(" 个。\n");
            List<Map<String, Object>> typeRows = jdbcTemplate.queryForList(
                "select app_type, count(*) as total from sys_agent_app where del_flag = '0' group by app_type");
            summary.append("Agent 类型统计：").append(JSON.toJSONString(typeRows)).append("\n");
            List<Map<String, Object>> appRows = jdbcTemplate.queryForList(
                "select app_name, app_type, model_code, status, is_default from sys_agent_app where del_flag = '0' order by app_id desc limit 10");
            summary.append("最近 Agent 应用：").append(JSON.toJSONString(appRows));
        }
        return summary.toString();
    }

    private String userSummary()
    {
        return tableSummary("[用户管理摘要]", "system:user:list", "sys_user", "del_flag = '0'",
            "select user_name, nick_name, phonenumber, status, create_time from sys_user where del_flag = '0' order by user_id desc limit 10");
    }

    private String roleSummary()
    {
        return tableSummary("[角色管理摘要]", "system:role:list", "sys_role", "del_flag = '0'",
            "select role_name, role_key, role_sort, status, create_time from sys_role where del_flag = '0' order by role_id desc limit 10");
    }

    private String deptSummary()
    {
        return tableSummary("[部门管理摘要]", "system:dept:list", "sys_dept", "del_flag = '0'",
            "select dept_name, parent_id, order_num, status, create_time from sys_dept where del_flag = '0' order by dept_id desc limit 10");
    }

    private String menuSummary()
    {
        if (!hasAny("system:menu:list")) return "[菜单管理摘要]\n无权访问菜单管理摘要。";
        if (!tableExists("sys_menu")) return "[菜单管理摘要]\n菜单表不存在。";
        StringBuilder summary = new StringBuilder("[菜单管理摘要]\n");
        summary.append("菜单总数：").append(count("select count(*) from sys_menu")).append(" 个。\n");
        summary.append("目录/菜单/按钮统计：").append(JSON.toJSONString(jdbcTemplate.queryForList(
            "select menu_type, count(*) total from sys_menu group by menu_type"))).append("\n");
        summary.append("最近菜单：").append(JSON.toJSONString(jdbcTemplate.queryForList(
            "select menu_name, menu_type, path, perms, status from sys_menu order by menu_id desc limit 10")));
        return summary.toString();
    }

    private String dictSummary()
    {
        if (!hasAny("system:dict:list")) return "[字典管理摘要]\n无权访问字典管理摘要。";
        StringBuilder summary = new StringBuilder("[字典管理摘要]\n");
        if (tableExists("sys_dict_type"))
        {
            summary.append("字典类型数量：").append(count("select count(*) from sys_dict_type")).append(" 个。\n");
            summary.append("最近字典类型：").append(JSON.toJSONString(jdbcTemplate.queryForList(
                "select dict_name, dict_type, status, create_time from sys_dict_type order by dict_id desc limit 10"))).append("\n");
        }
        if (tableExists("sys_dict_data"))
        {
            summary.append("字典数据数量：").append(count("select count(*) from sys_dict_data")).append(" 条。");
        }
        return summary.toString();
    }

    private String configSummary()
    {
        if (!hasAny("system:config:list")) return "[参数配置摘要]\n无权访问参数配置摘要。";
        if (!tableExists("sys_config")) return "[参数配置摘要]\n参数配置表不存在。";
        StringBuilder summary = new StringBuilder("[参数配置摘要]\n");
        summary.append("参数数量：").append(count("select count(*) from sys_config")).append(" 个。\n");
        summary.append("站点配置相关数量：").append(count("select count(*) from sys_config where config_key like 'site.%' or config_key like 'sys.%'")).append(" 个。\n");
        summary.append("最近参数：").append(JSON.toJSONString(jdbcTemplate.queryForList(
            "select config_name, config_key, config_type, create_time from sys_config order by config_id desc limit 12")));
        return summary.toString();
    }

    private String postSummary()
    {
        return tableSummary("[岗位管理摘要]", "system:post:list", "sys_post", "1 = 1",
            "select post_name, post_code, post_sort, status, create_time from sys_post order by post_id desc limit 10");
    }

    private String deviceSummary()
    {
        if (!hasAny("device:camera:list,device:alarm:list,device:reader:list"))
        {
            return "[设备摘要]\n无权访问设备摘要。";
        }
        StringBuilder summary = new StringBuilder("[设备摘要]\n");
        appendTableCount(summary, "摄像头", "device_camera", "device:camera:list");
        appendTableCount(summary, "报警器", "device_alarm", "device:alarm:list");
        appendTableCount(summary, "阅读器", "device_reader", "device:reader:list");
        if (tableExists("device_chute"))
        {
            summary.append("溜井：").append(count("select count(*) from device_chute where del_flag = '0'")).append(" 个。\n");
        }
        return summary.toString();
    }

    private String cacheSummary()
    {
        if (!hasAny("monitor:cache:list"))
        {
            return "[缓存摘要]\n无权访问缓存摘要。";
        }
        Properties info = (Properties) redisTemplate.execute((RedisCallback<Object>) connection -> connection.info());
        Object dbSize = redisTemplate.execute((RedisCallback<Object>) connection -> connection.dbSize());
        StringBuilder summary = new StringBuilder("[缓存摘要]\n");
        summary.append("Redis key 数量：").append(dbSize).append("。\n");
        if (info != null)
        {
            summary.append("Redis 版本：").append(info.getProperty("redis_version", "-")).append("；");
            summary.append("运行模式：").append(info.getProperty("redis_mode", "-")).append("；");
            summary.append("已用内存：").append(info.getProperty("used_memory_human", "-")).append("；");
            summary.append("连接客户端：").append(info.getProperty("connected_clients", "-")).append("。");
        }
        return summary.toString();
    }

    private String noticeSummary()
    {
        if (!hasAny("system:notice:list"))
        {
            return "[通知公告摘要]\n无权访问通知公告摘要。";
        }
        if (!tableExists("sys_notice"))
        {
            return "[通知公告摘要]\n通知公告表不存在。";
        }
        StringBuilder summary = new StringBuilder("[通知公告摘要]\n");
        summary.append("通知公告数量：").append(count("select count(*) from sys_notice")).append(" 条。\n");
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
            "select notice_title, notice_type, status, create_time from sys_notice order by notice_id desc limit 5");
        summary.append("最近公告：").append(JSON.toJSONString(rows));
        return summary.toString();
    }

    private String onlineSummary()
    {
        if (!hasAny("monitor:online:list")) return "[在线用户摘要]\n无权访问在线用户摘要。";
        Long count = redisKeyCount("login_tokens:*");
        return "[在线用户摘要]\n当前 Redis 登录 token 数量约为：" + count + " 个。";
    }

    private String loginLogSummary()
    {
        return tableSummary("[登录日志摘要]", "monitor:logininfor:list", "sys_logininfor", "1 = 1",
            "select user_name, ipaddr, status, msg, login_time from sys_logininfor order by info_id desc limit 10");
    }

    private String operLogSummary()
    {
        return tableSummary("[操作日志摘要]", "monitor:operlog:list", "sys_oper_log", "1 = 1",
            "select title, business_type, oper_name, status, oper_time from sys_oper_log order by oper_id desc limit 10");
    }

    private String serverSummary()
    {
        if (!hasAny("monitor:server:list")) return "[服务监控摘要]\n无权访问服务监控摘要。";
        Runtime runtime = Runtime.getRuntime();
        long max = runtime.maxMemory() / 1024 / 1024;
        long total = runtime.totalMemory() / 1024 / 1024;
        long free = runtime.freeMemory() / 1024 / 1024;
        return "[服务监控摘要]\n"
            + "可用处理器：" + runtime.availableProcessors() + "；"
            + "JVM 最大内存：" + max + "MB；"
            + "JVM 已分配内存：" + total + "MB；"
            + "JVM 空闲内存：" + free + "MB；"
            + "操作系统：" + System.getProperty("os.name") + " " + System.getProperty("os.version") + "。";
    }

    private String jobSummary()
    {
        if (!hasAny("monitor:job:list")) return "[定时任务摘要]\n无权访问定时任务摘要。";
        StringBuilder summary = new StringBuilder("[定时任务摘要]\n");
        if (tableExists("sys_job"))
        {
            summary.append("任务数量：").append(count("select count(*) from sys_job")).append(" 个。\n");
            summary.append("任务状态统计：").append(JSON.toJSONString(jdbcTemplate.queryForList(
                "select status, count(*) total from sys_job group by status"))).append("\n");
            summary.append("最近任务：").append(JSON.toJSONString(jdbcTemplate.queryForList(
                "select job_name, job_group, invoke_target, status from sys_job order by job_id desc limit 10"))).append("\n");
        }
        if (tableExists("sys_job_log"))
        {
            summary.append("任务日志数量：").append(count("select count(*) from sys_job_log")).append(" 条。");
        }
        return summary.toString();
    }

    private String generatorSummary()
    {
        return tableSummary("[代码生成摘要]", "tool:gen:list", "gen_table", "1 = 1",
            "select table_name, table_comment, class_name, create_time, update_time from gen_table order by table_id desc limit 10");
    }

    private String agentPlatformSummary()
    {
        StringBuilder summary = new StringBuilder("[AI Agent 平台摘要]\n");
        if (hasAny("system:agent:app:list") && tableExists("sys_agent_app"))
        {
            summary.append("Agent 应用：").append(count("select count(*) from sys_agent_app where del_flag = '0'")).append(" 个。\n");
        }
        if (hasAny("system:agent:kb:list") && tableExists("sys_agent_knowledge_base"))
        {
            summary.append("知识库：").append(count("select count(*) from sys_agent_knowledge_base where del_flag = '0'")).append(" 个；");
            summary.append("文档：").append(tableExists("sys_agent_knowledge_doc") ? count("select count(*) from sys_agent_knowledge_doc") : 0).append(" 个；");
            summary.append("切片：").append(tableExists("sys_agent_knowledge_chunk") ? count("select count(*) from sys_agent_knowledge_chunk") : 0).append(" 个。\n");
        }
        if (hasAny("system:agent:workflow:list") && tableExists("sys_agent_workflow"))
        {
            summary.append("工作流：").append(count("select count(*) from sys_agent_workflow where del_flag = '0'")).append(" 个；");
            summary.append("运行记录：").append(tableExists("sys_agent_workflow_run") ? count("select count(*) from sys_agent_workflow_run") : 0).append(" 条。\n");
        }
        if (hasAny("system:agent:log:list") && tableExists("sys_agent_tool_call"))
        {
            summary.append("工具调用日志：").append(count("select count(*) from sys_agent_tool_call")).append(" 条。");
        }
        return summary.toString();
    }

    private String systemOverview()
    {
        List<String> overview = new ArrayList<>();
        overview.add(userSummary());
        overview.add(roleSummary());
        overview.add(deptSummary());
        overview.add(menuSummary());
        overview.add(configSummary());
        overview.add(noticeSummary());
        overview.add(modelSummary());
        overview.add(deviceSummary());
        overview.add(cacheSummary());
        overview.add(jobSummary());
        overview.add(agentPlatformSummary());
        return "[系统总览]\n" + String.join("\n", overview);
    }

    private void appendTableCount(StringBuilder summary, String label, String tableName, String permission)
    {
        if (!hasAny(permission) || !tableExists(tableName))
        {
            return;
        }
        summary.append(label).append("：")
            .append(count("select count(*) from " + tableName + " where del_flag = '0'"))
            .append(" 个。\n");
    }

    private String tableSummary(String title, String permission, String tableName, String whereClause, String latestSql)
    {
        if (!hasAny(permission))
        {
            return title + "\n无权访问。";
        }
        if (!tableExists(tableName))
        {
            return title + "\n数据表不存在：" + tableName;
        }
        String where = StringUtils.isEmpty(whereClause) ? "1 = 1" : whereClause;
        StringBuilder summary = new StringBuilder(title).append("\n");
        summary.append("数量：").append(count("select count(*) from " + tableName + " where " + where)).append("。\n");
        summary.append("最近数据：").append(JSON.toJSONString(jdbcTemplate.queryForList(latestSql)));
        return summary.toString();
    }

    private Map<String, String> api(String name, String path, String permission, String status)
    {
        Map<String, String> item = new LinkedHashMap<>();
        item.put("name", name);
        item.put("path", path);
        item.put("permission", permission);
        item.put("status", status);
        return item;
    }

    private boolean tableExists(String tableName)
    {
        try
        {
            Long count = jdbcTemplate.queryForObject(
                "select count(*) from information_schema.tables where table_schema = database() and table_name = ?",
                Long.class, tableName);
            return count != null && count > 0;
        }
        catch (DataAccessException e)
        {
            return false;
        }
    }

    private Long count(String sql)
    {
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return count == null ? 0L : count;
    }

    private Long redisKeyCount(String pattern)
    {
        try
        {
            Long count = redisTemplate.execute((RedisCallback<Long>) connection -> {
                byte[] rawPattern = redisTemplate.getStringSerializer().serialize(pattern);
                return connection.keys(rawPattern).size() * 1L;
            });
            return count == null ? 0L : count;
        }
        catch (Exception e)
        {
            return 0L;
        }
    }

    private boolean hasAny(String permissions)
    {
        return permissionService.hasAnyPermi(permissions);
    }

    private boolean match(String text, String... keywords)
    {
        for (String keyword : keywords)
        {
            if (text.contains(keyword.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isWriteIntent(String text)
    {
        return match(text, "新增", "创建", "添加", "修改", "编辑", "删除", "移除", "导入", "导出", "清理", "清空", "重置", "分配", "授权", "禁用", "启用", "踢出", "下线", "保存", "提交", "post", "put", "delete");
    }

    private String abbreviate(String text, int maxLength)
    {
        if (StringUtils.isEmpty(text) || text.length() <= maxLength)
        {
            return text;
        }
        return text.substring(0, maxLength);
    }

    private String abbreviateForColumn(String text, int maxLength)
    {
        String value = abbreviate(text, maxLength);
        if (StringUtils.isEmpty(value))
        {
            return value;
        }
        while (value.getBytes(java.nio.charset.StandardCharsets.UTF_8).length > maxLength * 4 && value.length() > 0)
        {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    private interface ToolSupplier
    {
        String get();
    }

    private static class ToolDefinition
    {
        private final String name;
        private final String displayName;
        private final String description;
        private final String parametersSchema;
        private final String permission;
        private final boolean readOnly;
        private final ToolSupplier supplier;
        private final List<String> keywords;

        private ToolDefinition(String name, String displayName, String description, String parametersSchema, String permission, boolean readOnly, ToolSupplier supplier, List<String> keywords)
        {
            this.name = name;
            this.displayName = displayName;
            this.description = description;
            this.parametersSchema = parametersSchema;
            this.permission = permission;
            this.readOnly = readOnly;
            this.supplier = supplier;
            this.keywords = keywords;
        }
    }
}
