package com.bben.infusion.model.infusion;

import java.io.Serializable;
import java.util.Date;

public class TPatientInfusionInfo implements Serializable {
    private Integer id;

    private Integer patientId;

    private String infusionNo;

    private Integer sequenceId;

    private String drugNameList;

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

    private Date endTime;

    private String description;

    private Date createTime;

    private String createBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getInfusionNo() {
        return infusionNo;
    }

    public void setInfusionNo(String infusionNo) {
        this.infusionNo = infusionNo == null ? null : infusionNo.trim();
    }

    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDrugNameList() {
        return drugNameList;
    }

    public void setDrugNameList(String drugNameList) {
        this.drugNameList = drugNameList == null ? null : drugNameList.trim();
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientId=").append(patientId);
        sb.append(", infusionNo=").append(infusionNo);
        sb.append(", sequenceId=").append(sequenceId);
        sb.append(", drugNameList=").append(drugNameList);
        sb.append(", maxDrip=").append(maxDrip);
        sb.append(", minDrip=").append(minDrip);
        sb.append(", maxTimeLen=").append(maxTimeLen);
        sb.append(", minTimeLen=").append(minTimeLen);
        sb.append(", bottleLiquidWeight=").append(bottleLiquidWeight);
        sb.append(", bottleWeight=").append(bottleWeight);
        sb.append(", estimateTimeLen=").append(estimateTimeLen);
        sb.append(", normalDrip=").append(normalDrip);
        sb.append(", runStatus=").append(runStatus);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}