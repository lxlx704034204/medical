package com.bben.bedcard.model.bedcard;

import java.io.Serializable;
import java.util.Date;

public class TDrugsDose implements Serializable {
    private Integer id;

    private Integer medicationRecordId;

    private String drugName;

    private String breakfastConsumption;

    private String lunchConsumption;

    private String dinnerConsumption;

    private String beforeSleepConsumption;

    private String other;

    private Byte status;

    private String description;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicationRecordId() {
        return medicationRecordId;
    }

    public void setMedicationRecordId(Integer medicationRecordId) {
        this.medicationRecordId = medicationRecordId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getBreakfastConsumption() {
        return breakfastConsumption;
    }

    public void setBreakfastConsumption(String breakfastConsumption) {
        this.breakfastConsumption = breakfastConsumption == null ? null : breakfastConsumption.trim();
    }

    public String getLunchConsumption() {
        return lunchConsumption;
    }

    public void setLunchConsumption(String lunchConsumption) {
        this.lunchConsumption = lunchConsumption == null ? null : lunchConsumption.trim();
    }

    public String getDinnerConsumption() {
        return dinnerConsumption;
    }

    public void setDinnerConsumption(String dinnerConsumption) {
        this.dinnerConsumption = dinnerConsumption == null ? null : dinnerConsumption.trim();
    }

    public String getBeforeSleepConsumption() {
        return beforeSleepConsumption;
    }

    public void setBeforeSleepConsumption(String beforeSleepConsumption) {
        this.beforeSleepConsumption = beforeSleepConsumption == null ? null : beforeSleepConsumption.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", medicationRecordId=").append(medicationRecordId);
        sb.append(", drugName=").append(drugName);
        sb.append(", breakfastConsumption=").append(breakfastConsumption);
        sb.append(", lunchConsumption=").append(lunchConsumption);
        sb.append(", dinnerConsumption=").append(dinnerConsumption);
        sb.append(", beforeSleepConsumption=").append(beforeSleepConsumption);
        sb.append(", other=").append(other);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}