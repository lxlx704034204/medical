package com.bben.infusion.model.param_model;

import com.bben.infusion.model.infusion.TPatient;

import java.io.Serializable;
import java.util.Date;

public class TPatientInfusionEquipParam implements Serializable {

    private String infusionNo;//输液单号

    private String sequenceId;//输液序号

    private String drugNameList;//药品名称清单

    private Integer maxDrip;

    private Integer minDrip;

    private Integer maxTimeLen;

    private Integer minTimeLen;

    private Integer bottleLiquidWeight;

    private Integer bottleWeight;

    private Integer estimateTimeLen;

    private Integer normalDrip;

    private Integer runStatus;

    private Date beginTime;

    private String equipmentSn;

    private Integer batteryLifeId;

    private Integer voltageWarn;

    private Integer lowAlarm;

    private Integer dripWarn;

    private Integer continueTime;//持续时间（分钟）

    private Integer voltage; //设备测试出来的电压值

    private static final long serialVersionUID = 1L;

    public String getInfusionNo() {
        return infusionNo;
    }

    public void setInfusionNo(String infusionNo) {
        this.infusionNo = infusionNo;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDrugNameList() {
        return drugNameList;
    }

    public void setDrugNameList(String drugNameList) {
        this.drugNameList = drugNameList;
    }

    public Integer getMaxDrip() {
        return maxDrip;
    }

    public void setMaxDrip(Integer maxDrip) {
        this.maxDrip = maxDrip;
    }

    public Integer getMinDrip() {
        return minDrip;
    }

    public void setMinDrip(Integer minDrip) {
        this.minDrip = minDrip;
    }

    public Integer getMaxTimeLen() {
        return maxTimeLen;
    }

    public void setMaxTimeLen(Integer maxTimeLen) {
        this.maxTimeLen = maxTimeLen;
    }

    public Integer getMinTimeLen() {
        return minTimeLen;
    }

    public void setMinTimeLen(Integer minTimeLen) {
        this.minTimeLen = minTimeLen;
    }

    public Integer getBottleLiquidWeight() {
        return bottleLiquidWeight;
    }

    public void setBottleLiquidWeight(Integer bottleLiquidWeight) {
        this.bottleLiquidWeight = bottleLiquidWeight;
    }

    public Integer getBottleWeight() {
        return bottleWeight;
    }

    public void setBottleWeight(Integer bottleWeight) {
        this.bottleWeight = bottleWeight;
    }

    public Integer getEstimateTimeLen() {
        return estimateTimeLen;
    }

    public void setEstimateTimeLen(Integer estimateTimeLen) {
        this.estimateTimeLen = estimateTimeLen;
    }

    public Integer getNormalDrip() {
        return normalDrip;
    }

    public void setNormalDrip(Integer normalDrip) {
        this.normalDrip = normalDrip;
    }

    public Integer getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Integer runStatus) {
        this.runStatus = runStatus;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getEquipmentSn() {
        return equipmentSn;
    }

    public void setEquipmentSn(String equipmentSn) {
        this.equipmentSn = equipmentSn;
    }

    public Integer getBatteryLifeId() {
        return batteryLifeId;
    }

    public void setBatteryLifeId(Integer batteryLifeId) {
        this.batteryLifeId = batteryLifeId;
    }

    public Integer getVoltageWarn() {
        return voltageWarn;
    }

    public void setVoltageWarn(Integer voltageWarn) {
        this.voltageWarn = voltageWarn;
    }

    public Integer getLowAlarm() {
        return lowAlarm;
    }

    public void setLowAlarm(Integer lowAlarm) {
        this.lowAlarm = lowAlarm;
    }

    public Integer getDripWarn() {
        return dripWarn;
    }

    public void setDripWarn(Integer dripWarn) {
        this.dripWarn = dripWarn;
    }

    public Integer getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(Integer continueTime) {
        this.continueTime = continueTime;
    }


    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }
}