package com.ruoyi.sq.domain;

import java.io.Serializable;

public class VisualCategory implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String categoryKey;
    private String categoryValue;
    private Integer isDeleted;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCategoryKey()
    {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey)
    {
        this.categoryKey = categoryKey;
    }

    public String getCategoryValue()
    {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue)
    {
        this.categoryValue = categoryValue;
    }

    public Integer getIsDeleted()
    {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted)
    {
        this.isDeleted = isDeleted;
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
