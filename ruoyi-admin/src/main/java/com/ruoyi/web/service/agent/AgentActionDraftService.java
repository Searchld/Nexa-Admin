package com.ruoyi.web.service.agent;

import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.framework.web.service.PermissionService;
import com.ruoyi.system.domain.agent.SysAgentActionDraft;
import com.ruoyi.system.service.ISysDictTypeService;
import com.ruoyi.system.service.ISysNoticeReadService;
import com.ruoyi.system.service.agent.ISysAgentService;

@Service
public class AgentActionDraftService
{
    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ISysDictTypeService dictTypeService;

    @Autowired
    private ISysNoticeReadService noticeReadService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public SysAgentActionDraft confirm(Long draftId, Long userId)
    {
        SysAgentActionDraft draft = requiredDraft(draftId, userId);
        if (!"pending".equals(draft.getStatus()))
        {
            throw new ServiceException("动作草稿已处理");
        }
        if (!"1".equals(draft.getExecutable()))
        {
            draft.setStatus("failed");
            draft.setErrorMsg("该动作暂未开放自动执行，请在对应业务页面人工处理");
            return agentService.updateActionDraft(draft);
        }
        if (!hasRequiredPerms(draft.getRequiredPerms()))
        {
            draft.setStatus("failed");
            draft.setErrorMsg("无权执行该动作：" + draft.getRequiredPerms());
            return agentService.updateActionDraft(draft);
        }
        try
        {
            execute(draft, userId);
            draft.setStatus("executed");
            draft.setResultMsg("动作已执行：" + draft.getActionTitle());
            draft.setConfirmTime(new Date());
            return agentService.updateActionDraft(draft);
        }
        catch (Exception e)
        {
            draft.setStatus("failed");
            draft.setErrorMsg(e.getMessage());
            draft.setConfirmTime(new Date());
            return agentService.updateActionDraft(draft);
        }
    }

    public SysAgentActionDraft cancel(Long draftId, Long userId)
    {
        SysAgentActionDraft draft = requiredDraft(draftId, userId);
        if (!"pending".equals(draft.getStatus()))
        {
            throw new ServiceException("动作草稿已处理");
        }
        draft.setStatus("cancelled");
        draft.setResultMsg("用户已取消");
        return agentService.updateActionDraft(draft);
    }

    private SysAgentActionDraft requiredDraft(Long draftId, Long userId)
    {
        SysAgentActionDraft draft = agentService.selectActionDraftById(draftId, userId);
        if (draft == null)
        {
            throw new ServiceException("动作草稿不存在");
        }
        return draft;
    }

    private void execute(SysAgentActionDraft draft, Long userId)
    {
        switch (draft.getActionType())
        {
            case "refresh_dict_cache" -> dictTypeService.resetDictCache();
            case "clear_all_cache" -> {
                Collection<String> keys = redisTemplate.keys("*");
                if (keys != null && !keys.isEmpty())
                {
                    redisTemplate.delete(keys);
                }
            }
            case "notice_mark_read_all" -> noticeReadService.markReadAll(userId);
            default -> throw new ServiceException("不支持的动作类型：" + draft.getActionType());
        }
    }

    private boolean hasRequiredPerms(String permissions)
    {
        return permissions == null || permissions.isEmpty() || permissionService.hasAnyPermi(permissions);
    }
}
