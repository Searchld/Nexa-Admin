package com.ruoyi.sq.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Camera implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String shitype;
    private String lname;
    private String company;
    private String carmname;
    private String carmip;
    private String username;
    private String password;
    private String createUser;
    private Long createDept;
    private Timestamp createTime;
    private String updateUser;
    private Timestamp updateTime;
    private String status;
    private String isDeleted;
    private String type;
    private String serverUrl;
    private String serverUrl2;
    private String carmstar;
    private Integer px;
    private Integer dppx;
    private String srcimg;
    private String clist;
    private String rlist;
    private String nowQuantity;
    private String allQuantity;
    private String ton;
    private String locationx;
    private String locationy;
    private String width;
    private String height;
    private String depth;
    private Boolean safeAlert;
    private String channel;
    private String mine;
    private String tname;
    private String config;
    private String shitypename;
    private String rad;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getShitype()
    {
        return shitype;
    }

    public void setShitype(String shitype)
    {
        this.shitype = shitype;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getCarmname()
    {
        return carmname;
    }

    public void setCarmname(String carmname)
    {
        this.carmname = carmname;
    }

    public String getCarmip()
    {
        return carmip;
    }

    public void setCarmip(String carmip)
    {
        this.carmip = carmip;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public Long getCreateDept()
    {
        return createDept;
    }

    public void setCreateDept(Long createDept)
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getServerUrl()
    {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl)
    {
        this.serverUrl = serverUrl;
    }

    public String getServerUrl2()
    {
        return serverUrl2;
    }

    public void setServerUrl2(String serverUrl2)
    {
        this.serverUrl2 = serverUrl2;
    }

    public String getCarmstar()
    {
        return carmstar;
    }

    public void setCarmstar(String carmstar)
    {
        this.carmstar = carmstar;
    }

    public Integer getPx()
    {
        return px;
    }

    public void setPx(Integer px)
    {
        this.px = px;
    }

    public Integer getDppx()
    {
        return dppx;
    }

    public void setDppx(Integer dppx)
    {
        this.dppx = dppx;
    }

    public String getSrcimg()
    {
        return srcimg;
    }

    public void setSrcimg(String srcimg)
    {
        this.srcimg = srcimg;
    }

    public String getClist()
    {
        return clist;
    }

    public void setClist(String clist)
    {
        this.clist = clist;
    }

    public String getRlist()
    {
        return rlist;
    }

    public void setRlist(String rlist)
    {
        this.rlist = rlist;
    }

    public String getNowQuantity()
    {
        return nowQuantity;
    }

    public void setNowQuantity(String nowQuantity)
    {
        this.nowQuantity = nowQuantity;
    }

    public String getAllQuantity()
    {
        return allQuantity;
    }

    public void setAllQuantity(String allQuantity)
    {
        this.allQuantity = allQuantity;
    }

    public String getTon()
    {
        return ton;
    }

    public void setTon(String ton)
    {
        this.ton = ton;
    }

    public String getLocationx()
    {
        return locationx;
    }

    public void setLocationx(String locationx)
    {
        this.locationx = locationx;
    }

    public String getLocationy()
    {
        return locationy;
    }

    public void setLocationy(String locationy)
    {
        this.locationy = locationy;
    }

    public String getWidth()
    {
        return width;
    }

    public void setWidth(String width)
    {
        this.width = width;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getDepth()
    {
        return depth;
    }

    public void setDepth(String depth)
    {
        this.depth = depth;
    }

    public Boolean getSafeAlert()
    {
        return safeAlert;
    }

    public void setSafeAlert(Boolean safeAlert)
    {
        this.safeAlert = safeAlert;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getMine()
    {
        return mine;
    }

    public void setMine(String mine)
    {
        this.mine = mine;
    }

    public String getTname()
    {
        return tname;
    }

    public void setTname(String tname)
    {
        this.tname = tname;
    }

    public String getConfig()
    {
        return config;
    }

    public void setConfig(String config)
    {
        this.config = config;
    }

    public String getShitypename()
    {
        return shitypename;
    }

    public void setShitypename(String shitypename)
    {
        this.shitypename = shitypename;
    }

    public String getRad()
    {
        return rad;
    }

    public void setRad(String rad)
    {
        this.rad = rad;
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
