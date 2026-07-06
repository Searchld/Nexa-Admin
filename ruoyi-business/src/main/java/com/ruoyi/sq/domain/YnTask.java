package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class YnTask implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private String lname;
    private String channel;
    private String status;
    private Timestamp createTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Timestamp getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Timestamp startTime)
    {
        this.startTime = startTime;
    }

    public Timestamp getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Timestamp endTime)
    {
        this.endTime = endTime;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public Object getPkValue()
    {
        return id;
    }

    @Override
    public void setPkValue(Object value)
    {
        this.id = value == null ? null : Integer.valueOf(value.toString());
    }
}
