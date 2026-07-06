package com.ruoyi.sq.domain;

import java.io.Serializable;

public class YnLogsOut implements SqTableEntity, Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String ydNo;
    private String leader;
    private String plateNumber;
    private String taskTime;
    private String createTime;
    private String instruction;
    private String team;
    private String vehicles;
    private String schedule;
    private String carType;
    private String wellingPoint;
    private String wellingPointId;
    private String mineralType;
    private String miners;
    private String discharge;
    private String releaseDate;
    private String releaseConfirmation;
    private String weighingTime;
    private String totalTonnage;
    private String unloadingPoint;
    private String unloadingTypes;
    private String unloadUser;
    private String unloadingTime;
    private String numberVehicles;
    private String unloadingConfirmation;
    private String progress;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getYdNo()
    {
        return ydNo;
    }

    public void setYdNo(String ydNo)
    {
        this.ydNo = ydNo;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    public String getPlateNumber()
    {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber)
    {
        this.plateNumber = plateNumber;
    }

    public String getTaskTime()
    {
        return taskTime;
    }

    public void setTaskTime(String taskTime)
    {
        this.taskTime = taskTime;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getVehicles()
    {
        return vehicles;
    }

    public void setVehicles(String vehicles)
    {
        this.vehicles = vehicles;
    }

    public String getSchedule()
    {
        return schedule;
    }

    public void setSchedule(String schedule)
    {
        this.schedule = schedule;
    }

    public String getCarType()
    {
        return carType;
    }

    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public String getWellingPoint()
    {
        return wellingPoint;
    }

    public void setWellingPoint(String wellingPoint)
    {
        this.wellingPoint = wellingPoint;
    }

    public String getWellingPointId()
    {
        return wellingPointId;
    }

    public void setWellingPointId(String wellingPointId)
    {
        this.wellingPointId = wellingPointId;
    }

    public String getMineralType()
    {
        return mineralType;
    }

    public void setMineralType(String mineralType)
    {
        this.mineralType = mineralType;
    }

    public String getMiners()
    {
        return miners;
    }

    public void setMiners(String miners)
    {
        this.miners = miners;
    }

    public String getDischarge()
    {
        return discharge;
    }

    public void setDischarge(String discharge)
    {
        this.discharge = discharge;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getReleaseConfirmation()
    {
        return releaseConfirmation;
    }

    public void setReleaseConfirmation(String releaseConfirmation)
    {
        this.releaseConfirmation = releaseConfirmation;
    }

    public String getWeighingTime()
    {
        return weighingTime;
    }

    public void setWeighingTime(String weighingTime)
    {
        this.weighingTime = weighingTime;
    }

    public String getTotalTonnage()
    {
        return totalTonnage;
    }

    public void setTotalTonnage(String totalTonnage)
    {
        this.totalTonnage = totalTonnage;
    }

    public String getUnloadingPoint()
    {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint)
    {
        this.unloadingPoint = unloadingPoint;
    }

    public String getUnloadingTypes()
    {
        return unloadingTypes;
    }

    public void setUnloadingTypes(String unloadingTypes)
    {
        this.unloadingTypes = unloadingTypes;
    }

    public String getUnloadUser()
    {
        return unloadUser;
    }

    public void setUnloadUser(String unloadUser)
    {
        this.unloadUser = unloadUser;
    }

    public String getUnloadingTime()
    {
        return unloadingTime;
    }

    public void setUnloadingTime(String unloadingTime)
    {
        this.unloadingTime = unloadingTime;
    }

    public String getNumberVehicles()
    {
        return numberVehicles;
    }

    public void setNumberVehicles(String numberVehicles)
    {
        this.numberVehicles = numberVehicles;
    }

    public String getUnloadingConfirmation()
    {
        return unloadingConfirmation;
    }

    public void setUnloadingConfirmation(String unloadingConfirmation)
    {
        this.unloadingConfirmation = unloadingConfirmation;
    }

    public String getProgress()
    {
        return progress;
    }

    public void setProgress(String progress)
    {
        this.progress = progress;
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
