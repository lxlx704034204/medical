package com.bben.infusion.model.infusion;

import java.io.Serializable;
import java.util.Date;

public class TPatientInfusionWarn implements Serializable {
    private Integer id;

    private Integer patientId;

    private String equipmentSn;

    private String warnType;

    private Integer dripSpeed;

    private Date warnTime;

    private Date dealWithTime;

    private String dealWthBy;

    private String description;

    private Date createTime;

    private String createBy;

    private int infusionStatus;//输液状态

    private static final long serialVersionUID = 1L;

    public int getInfusionStatus() {
        return infusionStatus;
    }

    public void setInfusionStatus(int infusionStatus) {
        this.infusionStatus = infusionStatus;
    }

    public static final class WarnTypeConstant{
        public static final String FAST = "滴速过快";
        public static final String SLOW = "滴速过慢";
        public static final String ENDING = "输液即将结束";
        public static final String OVER = "输液结束待处理";
        public static final String PAUSE = "输液暂停";
        public static final String LACK = "电量不足";
        public static final String ERROR = "设备故障";
    }

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

    public String getEquipmentSn() {
        return equipmentSn;
    }

    public void setEquipmentSn(String equipmentSn) {
        this.equipmentSn = equipmentSn == null ? null : equipmentSn.trim();
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType == null ? null : warnType.trim();
    }

    public Integer getDripSpeed() {
        return dripSpeed;
    }

    public void setDripSpeed(Integer dripSpeed) {
        this.dripSpeed = dripSpeed;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Date getDealWithTime() {
        return dealWithTime;
    }

    public void setDealWithTime(Date dealWithTime) {
        this.dealWithTime = dealWithTime;
    }

    public String getDealWthBy() {
        return dealWthBy;
    }

    public void setDealWthBy(String dealWthBy) {
        this.dealWthBy = dealWthBy == null ? null : dealWthBy.trim();
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
        sb.append(", equipmentSn=").append(equipmentSn);
        sb.append(", warnType=").append(warnType);
        sb.append(", dripSpeed=").append(dripSpeed);
        sb.append(", warnTime=").append(warnTime);
        sb.append(", dealWithTime=").append(dealWithTime);
        sb.append(", dealWthBy=").append(dealWthBy);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}