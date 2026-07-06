package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cars implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cars;
    private String carsNum;
    private String carsXh;
    private String carsComp;
    private String mine;
    private String carsW;
    private String volume;
    private String createUser;
    private String createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String status;
    private String isDeleted;
    private Long teamid;
    private Team team;
    private String rfid;
    private String teamname;
    private String ctype;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCars()
    {
        return cars;
    }

    public void setCars(String cars)
    {
        this.cars = cars;
    }

    public String getCarsNum()
    {
        return carsNum;
    }

    public void setCarsNum(String carsNum)
    {
        this.carsNum = carsNum;
    }

    public String getCarsXh()
    {
        return carsXh;
    }

    public void setCarsXh(String carsXh)
    {
        this.carsXh = carsXh;
    }

    public String getCarsComp()
    {
        return carsComp;
    }

    public void setCarsComp(String carsComp)
    {
        this.carsComp = carsComp;
    }

    public String getMine()
    {
        return mine;
    }

    public void setMine(String mine)
    {
        this.mine = mine;
    }

    public String getCarsW()
    {
        return carsW;
    }

    public void setCarsW(String carsW)
    {
        this.carsW = carsW;
    }

    public String getVolume()
    {
        return volume;
    }

    public void setVolume(String volume)
    {
        this.volume = volume;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
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

    public String getIsDeleted()
    {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Long getTeamid()
    {
        return teamid;
    }

    public void setTeamid(Long teamid)
    {
        this.teamid = teamid;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
        if (team != null)
        {
            try
            {
                Object id = team.getClass().getMethod("getId").invoke(team);
                if (id instanceof Number) this.teamid = ((Number) id).longValue();
            }
            catch (Exception ignored)
            {
            }
        }
    }

    public String getRfid()
    {
        return rfid;
    }

    public void setRfid(String rfid)
    {
        this.rfid = rfid;
    }

    public String getTeamname()
    {
        return teamname;
    }

    public void setTeamname(String teamname)
    {
        this.teamname = teamname;
    }

    public String getCtype()
    {
        return ctype;
    }

    public void setCtype(String ctype)
    {
        this.ctype = ctype;
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
