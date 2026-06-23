package com.ruoyi.web.controller.system.agent;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeBase;
import com.ruoyi.system.domain.agent.SysAgentKnowledgeDoc;
import com.ruoyi.system.service.agent.ISysAgentService;
import com.ruoyi.web.service.agent.SpringAiVectorStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AI Agent 知识库")
@RestController
@RequestMapping("/system/agent/kb")
public class SysAgentKnowledgeController extends BaseController
{
    private static final String[] KNOWLEDGE_EXTENSIONS = { "txt", "md", "pdf", "docx", "xlsx" };

    @Autowired
    private ISysAgentService agentService;

    @Autowired
    private SpringAiVectorStoreService vectorStoreService;

    @PreAuthorize("@ss.hasPermi('system:agent:kb:list')")
    @Operation(summary = "查询知识库列表")
    @GetMapping("/list")
    public TableDataInfo list(SysAgentKnowledgeBase kb)
    {
        startPage();
        return getDataTable(agentService.selectKbList(kb));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:list')")
    @Operation(summary = "查询可用知识库选项")
    @GetMapping("/options")
    public AjaxResult options()
    {
        return success(agentService.selectEnabledKbList());
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:query')")
    @Operation(summary = "获取知识库详情")
    @GetMapping("/{kbId}")
    public AjaxResult getInfo(@PathVariable Long kbId)
    {
        return success(agentService.selectKbById(kbId));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:add')")
    @Log(title = "Agent知识库", businessType = BusinessType.INSERT)
    @Operation(summary = "新增知识库")
    @PostMapping
    public AjaxResult add(@RequestBody SysAgentKnowledgeBase kb)
    {
        kb.setCreateBy(getUsername());
        return toAjax(agentService.insertKb(kb));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:edit')")
    @Log(title = "Agent知识库", businessType = BusinessType.UPDATE)
    @Operation(summary = "修改知识库")
    @PutMapping
    public AjaxResult edit(@RequestBody SysAgentKnowledgeBase kb)
    {
        kb.setUpdateBy(getUsername());
        return toAjax(agentService.updateKb(kb));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:remove')")
    @Log(title = "Agent知识库", businessType = BusinessType.DELETE)
    @Operation(summary = "删除知识库")
    @DeleteMapping("/{kbIds}")
    public AjaxResult remove(@PathVariable Long[] kbIds)
    {
        return toAjax(agentService.deleteKbsByIds(kbIds));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:list')")
    @Operation(summary = "查询知识库文档")
    @GetMapping("/{kbId}/documents")
    public AjaxResult documents(@PathVariable Long kbId)
    {
        return success(agentService.selectDocList(kbId));
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:upload')")
    @Log(title = "Agent知识文档", businessType = BusinessType.IMPORT)
    @Operation(summary = "上传并解析知识文档")
    @PostMapping("/{kbId}/documents/upload")
    public AjaxResult upload(@PathVariable Long kbId, @RequestParam("file") MultipartFile file) throws Exception
    {
        String path = FileUploadUtils.upload(RuoYiConfig.getUploadPath() + "/agent-kb", file, KNOWLEDGE_EXTENSIONS);
        File saved = new File(RuoYiConfig.getProfile(), path.substring(Constants.RESOURCE_PREFIX.length()));
        SysAgentKnowledgeDoc doc = agentService.saveDocument(kbId, saved, file.getOriginalFilename(), file.getSize(), getUsername());
        vectorStoreService.syncChunks(agentService.selectChunksByDocId(doc.getDocId()));
        return success(doc);
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:reindex')")
    @Log(title = "Agent知识文档重建索引", businessType = BusinessType.UPDATE)
    @Operation(summary = "重建知识文档索引")
    @PostMapping("/documents/{docId}/reindex")
    public AjaxResult reindex(@PathVariable Long docId)
    {
        SysAgentKnowledgeDoc doc = agentService.reindexDocument(docId, getUsername());
        vectorStoreService.syncChunks(agentService.selectChunksByDocId(doc.getDocId()));
        return success(doc);
    }

    @PreAuthorize("@ss.hasPermi('system:agent:kb:remove')")
    @Log(title = "Agent知识文档", businessType = BusinessType.DELETE)
    @Operation(summary = "删除知识文档")
    @DeleteMapping("/documents/{docIds}")
    public AjaxResult removeDocuments(@PathVariable Long[] docIds)
    {
        return toAjax(agentService.deleteDocsByIds(docIds));
    }
}
