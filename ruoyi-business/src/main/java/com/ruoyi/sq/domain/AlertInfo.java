package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class AlertInfo implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String voice;
    private String name;
    private String level;
    private String text;
    private String types;
    private String status;
    private String isSend;
    private String sendUser;
    private String isReceive;
    private String createUser;
    private String createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String isDeleted;
    private String isopen;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getVoice()
    {
        return voice;
    }

    public void setVoice(String voice)
    {
        this.voice = voice;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getTypes()
    {
        return types;
    }

    public void setTypes(String types)
    {
        this.types = types;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIsSend()
    {
        return isSend;
    }

    public void setIsSend(String isSend)
    {
        this.isSend = isSend;
    }

    public String getSendUser()
    {
        return sendUser;
    }

    public void setSendUser(String sendUser)
    {
        this.sendUser = sendUser;
    }

    public String getIsReceive()
    {
        return isReceive;
    }

    public void setIsReceive(String isReceive)
    {
        this.isReceive = isReceive;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getCreateDept()
    {
        return createDept;
    }

    public void setCreateDept(String createDept)
    {
        this.createDept = createDept;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public String getUpdateUser()
    {
        return updateUser;
    }

    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }

    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getIsDeleted()
    {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public String getIsopen()
    {
        return isopen;
    }

    public void setIsopen(String isopen)
    {
        this.isopen = isopen;
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
