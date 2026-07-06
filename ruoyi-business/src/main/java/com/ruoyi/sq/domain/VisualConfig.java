package com.ruoyi.sq.domain;

import java.io.Serializable;

public class VisualConfig implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long visualId;
    private String detail;
    private String component;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getVisualId()
    {
        return visualId;
    }

    public void setVisualId(Long visualId)
    {
        this.visualId = visualId;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getComponent()
    {
        return component;
    }

    public void setComponent(String component)
    {
        this.component = component;
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
