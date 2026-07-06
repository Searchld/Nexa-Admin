package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class YnWxSend implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer types;
    private String sendUser;
    private String isSend;
    private String level;
    private String createUser;
    private String createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String tname;
    private String userName;
    private String deptId;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getTypes()
    {
        return types;
    }

    public void setTypes(Integer types)
    {
        this.types = types;
    }

    public String getSendUser()
    {
        return sendUser;
    }

    public void setSendUser(String sendUser)
    {
        this.sendUser = sendUser;
    }

    public String getIsSend()
    {
        return isSend;
    }

    public void setIsSend(String isSend)
    {
        this.isSend = isSend;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
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

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getDeptId()
    {
        return deptId;
    }

    public void setDeptId(String deptId)
    {
        this.deptId = deptId;
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
