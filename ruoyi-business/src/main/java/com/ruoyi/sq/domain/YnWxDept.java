package com.ruoyi.sq.domain;

import java.io.Serializable;

public class YnWxDept implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long pid;
    private Integer subCount;
    private String name;
    private Integer deptSort;
    private Boolean enabled;
    private String type;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getPid()
    {
        return pid;
    }

    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Integer getSubCount()
    {
        return subCount;
    }

    public void setSubCount(Integer subCount)
    {
        this.subCount = subCount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getDeptSort()
    {
        return deptSort;
    }

    public void setDeptSort(Integer deptSort)
    {
        this.deptSort = deptSort;
    }

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
