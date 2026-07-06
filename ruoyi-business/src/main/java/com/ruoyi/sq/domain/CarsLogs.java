package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarsLogs implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cars;
    private String fulls;
    private String bigs;
    private String yiwu;
    private String water;
    private String mud;
    private String shitype;
    private String videopath;
    private String imgpath;
    private String timecha;
    private Timestamp createdate;
    private String isDeleted;
    private String createUser;
    private String forkcar;
    private String createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String status;
    private String yiwus;
    private String ctype;
    private String company;
    private String rate;
    private String shift;
    private String groups;
    private String persons;
    private String lname;
    private String car;
    private String ip;
    private String ipType;
    private Integer channel;
    private Timestamp startTime;
    private Timestamp endTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public String getCars()
    {
        return cars;
    }

    public void setCars(String cars)
    {
        this.cars = cars;
    }

    public String getFulls()
    {
        return fulls;
    }

    public void setFulls(String fulls)
    {
        this.fulls = fulls;
    }

    public String getBigs()
    {
        return bigs;
    }

    public void setBigs(String bigs)
    {
        this.bigs = bigs;
    }

    public String getYiwu()
    {
        return yiwu;
    }

    public void setYiwu(String yiwu)
    {
        this.yiwu = yiwu;
    }

    public String getWater()
    {
        return water;
    }

    public void setWater(String water)
    {
        this.water = water;
    }

    public String getMud()
    {
        return mud;
    }

    public void setMud(String mud)
    {
        this.mud = mud;
    }

    public String getShitype()
    {
        return shitype;
    }

    public void setShitype(String shitype)
    {
        this.shitype = shitype;
    }

    public String getVideopath()
    {
        return videopath;
    }

    public void setVideopath(String videopath)
    {
        this.videopath = videopath;
    }

    public String getImgpath()
    {
        return imgpath;
    }

    public void setImgpath(String imgpath)
    {
        this.imgpath = imgpath;
    }

    public String getTimecha()
    {
        return timecha;
    }

    public void setTimecha(String timecha)
    {
        this.timecha = timecha;
    }

    public Timestamp getCreatedate()
    {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate)
    {
        this.createdate = createdate;
    }

    public String getIsDeleted()
    {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getForkcar()
    {
        return forkcar;
    }

    public void setForkcar(String forkcar)
    {
        this.forkcar = forkcar;
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getYiwus()
    {
        return yiwus;
    }

    public void setYiwus(String yiwus)
    {
        this.yiwus = yiwus;
    }

    public String getCtype()
    {
        return ctype;
    }

    public void setCtype(String ctype)
    {
        this.ctype = ctype;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getRate()
    {
        return rate;
    }

    public void setRate(String rate)
    {
        this.rate = rate;
    }

    public String getShift()
    {
        return shift;
    }

    public void setShift(String shift)
    {
        this.shift = shift;
    }

    public String getGroups()
    {
        return groups;
    }

    public void setGroups(String groups)
    {
        this.groups = groups;
    }

    public String getPersons()
    {
        return persons;
    }

    public void setPersons(String persons)
    {
        this.persons = persons;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getCar()
    {
        return car;
    }

    public void setCar(String car)
    {
        this.car = car;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getIpType()
    {
        return ipType;
    }

    public void setIpType(String ipType)
    {
        this.ipType = ipType;
    }

    public Integer getChannel()
    {
        return channel;
    }

    public void setChannel(Integer channel)
    {
        this.channel = channel;
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
