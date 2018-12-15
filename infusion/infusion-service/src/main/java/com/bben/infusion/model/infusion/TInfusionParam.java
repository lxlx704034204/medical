package com.bben.infusion.model.infusion;

import java.io.Serializable;
import java.util.Date;

public class TInfusionParam implements Serializable {
    private Integer id;

    private String dripType;

    private Integer oldMax;

    private Integer oldMin;

    private Integer maxDripSpeed;

    private Integer minDripSpeed;

    private String medicineName;

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

    public String getDripType() {
        return dripType;
    }

    public void setDripType(String dripType) {
        this.dripType = dripType == null ? null : dripType.trim();
    }

    public Integer getOldMax() {
        return oldMax;
    }

    public void setOldMax(Integer oldMax) {
        this.oldMax = oldMax;
    }

    public Integer getOldMin() {
        return oldMin;
    }

    public void setOldMin(Integer oldMin) {
        this.oldMin = oldMin;
    }

    public Integer getMaxDripSpeed() {
        return maxDripSpeed;
    }

    public void setMaxDripSpeed(Integer maxDripSpeed) {
        this.maxDripSpeed = maxDripSpeed;
    }

    public Integer getMinDripSpeed() {
        return minDripSpeed;
    }

    public void setMinDripSpeed(Integer minDripSpeed) {
        this.minDripSpeed = minDripSpeed;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
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
        sb.append(", dripType=").append(dripType);
        sb.append(", oldMax=").append(oldMax);
        sb.append(", oldMin=").append(oldMin);
        sb.append(", maxDripSpeed=").append(maxDripSpeed);
        sb.append(", minDripSpeed=").append(minDripSpeed);
        sb.append(", medicineName=").append(medicineName);
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