package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class YnLogsLevel implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer times;
    private String dates;
    private String lname;
    private Integer cars;
    private BigDecimal heights;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getTimes()
    {
        return times;
    }

    public void setTimes(Integer times)
    {
        this.times = times;
    }

    public String getDates()
    {
        return dates;
    }

    public void setDates(String dates)
    {
        this.dates = dates;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public Integer getCars()
    {
        return cars;
    }

    public void setCars(Integer cars)
    {
        this.cars = cars;
    }

    public BigDecimal getHeights()
    {
        return heights;
    }

    public void setHeights(BigDecimal heights)
    {
        this.heights = heights;
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
