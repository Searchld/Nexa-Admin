package com.ruoyi.sq.domain;

import java.io.Serializable;

public class Visual implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String backgroundUrl;
    private Integer category;
    private String password;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBackgroundUrl()
    {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl)
    {
        this.backgroundUrl = backgroundUrl;
    }

    public Integer getCategory()
    {
        return category;
    }

    public void setCategory(Integer category)
    {
        this.category = category;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
