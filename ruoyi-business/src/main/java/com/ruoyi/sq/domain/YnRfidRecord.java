package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class YnRfidRecord implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String ip;
    private String cid;
    private String tname;
    private Timestamp createTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
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
