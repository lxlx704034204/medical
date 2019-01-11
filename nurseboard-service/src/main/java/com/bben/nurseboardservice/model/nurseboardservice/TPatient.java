package com.bben.nurseboardservice.model.nurseboardservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TPatient implements Serializable {
    private Integer id;

    private String messageId;

    private String dataId;

    private String code;

    private String name;

    private String hospitalId;

    private String districtId;

    private String deptId;

    private String wardId;

    private String sickroomNo;

    private String cureNo;

    private String bedNo;

    private String nurseLevel;

    private Integer sex;

    private Integer marriage;

    private Date birthday;

    private Integer pcaCode;

    private String address;

    private String mobile;

    private String education;

    private String duties;

    private Integer idType;

    private String idNumber;

    private BigDecimal height;

    private BigDecimal weight;

    private String areaCode;

    private Integer customInfusionRule;

    private Integer runStatus;

    private Date beginTime;

    private Date endTime;

    private Date admissionTime;

    private Date dischargeTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId == null ? null : wardId.trim();
    }

    public String getSickroomNo() {
        return sickroomNo;
    }

    public void setSickroomNo(String sickroomNo) {
        this.sickroomNo = sickroomNo == null ? null : sickroomNo.trim();
    }

    public String getCureNo() {
        return cureNo;
    }

    public void setCureNo(String cureNo) {
        this.cureNo = cureNo == null ? null : cureNo.trim();
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public String getNurseLevel() {
        return nurseLevel;
    }

    public void setNurseLevel(String nurseLevel) {
        this.nurseLevel = nurseLevel == null ? null : nurseLevel.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPcaCode() {
        return pcaCode;
    }

    public void setPcaCode(Integer pcaCode) {
        this.pcaCode = pcaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties == null ? null : duties.trim();
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public Integer getCustomInfusionRule() {
        return customInfusionRule;
    }

    public void setCustomInfusionRule(Integer customInfusionRule) {
        this.customInfusionRule = customInfusionRule;
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

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Date dischargeTime) {
        this.dischargeTime = dischargeTime;
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
        sb.append(", name=").append(name);
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", districtId=").append(districtId);
        sb.append(", deptId=").append(deptId);
        sb.append(", wardId=").append(wardId);
        sb.append(", sickroomNo=").append(sickroomNo);
        sb.append(", cureNo=").append(cureNo);
        sb.append(", bedNo=").append(bedNo);
        sb.append(", nurseLevel=").append(nurseLevel);
        sb.append(", sex=").append(sex);
        sb.append(", marriage=").append(marriage);
        sb.append(", birthday=").append(birthday);
        sb.append(", pcaCode=").append(pcaCode);
        sb.append(", address=").append(address);
        sb.append(", mobile=").append(mobile);
        sb.append(", education=").append(education);
        sb.append(", duties=").append(duties);
        sb.append(", idType=").append(idType);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", customInfusionRule=").append(customInfusionRule);
        sb.append(", runStatus=").append(runStatus);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", admissionTime=").append(admissionTime);
        sb.append(", dischargeTime=").append(dischargeTime);
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