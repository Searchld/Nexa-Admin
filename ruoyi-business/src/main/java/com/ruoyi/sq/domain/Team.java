package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Team implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String tname;
    private String mine;
    private String tnameuser;
    private String createUser;
    private String createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String status;
    private String isDeleted;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public String getMine()
    {
        return mine;
    }

    public void setMine(String mine)
    {
        this.mine = mine;
    }

    public String getTnameuser()
    {
        return tnameuser;
    }

    public void setTnameuser(String tnameuser)
    {
        this.tnameuser = tnameuser;
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
