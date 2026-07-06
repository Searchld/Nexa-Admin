package com.ruoyi.sq.domain;

import java.io.Serializable;

public class YnSiren implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String location;
    private String ip;
    private String flag;
    private String mark;
    private String cameras;
    private String volume;
    private String isWarning;
    private String name;
    private String status;

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

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getMark()
    {
        return mark;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getCameras()
    {
        return cameras;
    }

    public void setCameras(String cameras)
    {
        this.cameras = cameras;
    }

    public String getVolume()
    {
        return volume;
    }

    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public String getIsWarning()
    {
        return isWarning;
    }

    public void setIsWarning(String isWarning)
    {
        this.isWarning = isWarning;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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
