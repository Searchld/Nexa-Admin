package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class YnUser implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String picture;
    private String video;
    private String remark;
    private Timestamp warningTime;
    private Timestamp createTime;
    private Timestamp handleTime;
    private String instruction;
    private String type;
    private String name;
    private String ip;
    private String scene;
    private String status;
    private String handle;
    private String section;
    private Integer channel;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPicture()
    {
        return picture;
    }

    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getVideo()
    {
        return video;
    }

    public void setVideo(String video)
    {
        this.video = video;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Timestamp getWarningTime()
    {
        return warningTime;
    }

    public void setWarningTime(Timestamp warningTime)
    {
        this.warningTime = warningTime;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public Timestamp getHandleTime()
    {
        return handleTime;
    }

    public void setHandleTime(Timestamp handleTime)
    {
        this.handleTime = handleTime;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getScene()
    {
        return scene;
    }

    public void setScene(String scene)
    {
        this.scene = scene;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getHandle()
    {
        return handle;
    }

    public void setHandle(String handle)
    {
        this.handle = handle;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public Integer getChannel()
    {
        return channel;
    }

    public void setChannel(Integer channel)
    {
        this.channel = channel;
    }

    @Override
    public Object getPkValue()
    {
        return id;
    }

    @Override
    public void setPkValue(Object value)
    {
        this.id = value == null ? null : Long.valueOf(value.toString());
    }
}
