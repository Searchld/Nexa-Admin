package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class YnRfidYdq implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String location;
    private String status;
    private String mark;
    private Timestamp createTime;
    private String name;
    private String ip;
    private String username;
    private String psw;
    private String port;
    private Integer lUserID;
    private String tname;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMark()
    {
        return mark;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPsw()
    {
        return psw;
    }

    public void setPsw(String psw)
    {
        this.psw = psw;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public Integer getLUserID()
    {
        return lUserID;
    }

    public void setLUserID(Integer lUserID)
    {
        this.lUserID = lUserID;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
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
