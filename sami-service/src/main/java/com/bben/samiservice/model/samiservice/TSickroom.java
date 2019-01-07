package com.bben.samiservice.model.samiservice;

import java.io.Serializable;
import java.util.Date;

public class TSickroom implements Serializable {
    private Integer id;

    private String messageId;

    private String dataId;

    private String code;

    private String sickroomName;

    private Integer wardId;

    private Integer bedCount;

    private String position;

    private String dutyDoctor;

    private String dutyNurse;

    private Integer sort;

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

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSickroomName() {
        return sickroomName;
    }

    public void setSickroomName(String sickroomName) {
        this.sickroomName = sickroomName == null ? null : sickroomName.trim();
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getDutyDoctor() {
        return dutyDoctor;
    }

    public void setDutyDoctor(String dutyDoctor) {
        this.dutyDoctor = dutyDoctor == null ? null : dutyDoctor.trim();
    }

    public String getDutyNurse() {
        return dutyNurse;
    }

    public void setDutyNurse(String dutyNurse) {
        this.dutyNurse = dutyNurse == null ? null : dutyNurse.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        sb.append(", messageId=").append(messageId);
        sb.append(", dataId=").append(dataId);
        sb.append(", code=").append(code);
        sb.append(", sickroomName=").append(sickroomName);
        sb.append(", wardId=").append(wardId);
        sb.append(", bedCount=").append(bedCount);
        sb.append(", position=").append(position);
        sb.append(", dutyDoctor=").append(dutyDoctor);
        sb.append(", dutyNurse=").append(dutyNurse);
        sb.append(", sort=").append(sort);
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