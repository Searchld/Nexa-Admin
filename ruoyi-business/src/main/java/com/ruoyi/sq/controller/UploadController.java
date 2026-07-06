package com.ruoyi.sq.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.sq.config.SqExternalProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "旧系统上传接口")
@RestController
@RequestMapping("/api/upload")
public class UploadController
{
    private final SqExternalProperties properties;

    public UploadController(SqExternalProperties properties)
    {
        this.properties = properties;
    }

    @Anonymous
    @Operation(summary = "上传文件")
    @PostMapping("/updFile")
    public AjaxResult updFile(@RequestParam MultipartFile file) throws IOException
    {
        String path = StringUtils.isNotEmpty(properties.getUpload().getFilePath()) ? properties.getUpload().getFilePath() : RuoYiConfig.getUploadPath();
        String fileName = FileUploadUtils.upload(path, file);
        return AjaxResult.success(new File(path, fileName).getPath());
    }

    @Anonymous
    @Operation(summary = "上传图片文件")
    @PostMapping("/img/updFile")
    public AjaxResult updImgFile(@RequestParam MultipartFile file) throws IOException
    {
        String path = StringUtils.isNotEmpty(properties.getUpload().getImagePath()) ? properties.getUpload().getImagePath() : RuoYiConfig.getUploadPath();
        String fileName = FileUploadUtils.upload(path, file);
        return AjaxResult.success(fileName);
    }
}
