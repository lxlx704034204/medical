package com.bben.samiservice.model.samiservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TNurse implements Serializable {
    private Integer id;

    private String messageId;

    private String dataId;

    private String code;

    private Integer hospitalId;

    private Integer hospitalDeptId;

    private String nurseCellCode;

    private Integer userId;

    private String name;

    private Integer sex;

    private Integer marriage;

    private Date birthday;

    private Integer pcaCode;

    private String address;

    private String postCode;

    private String mobile;

    private String intro;

    private String specialty;

    private String areaCode;

    private String education;

    private String title;

    private String duties;

    private Integer idType;

    private String idNumber;

    private String idUrl;

    private String imageUrl;

    private BigDecimal height;

    private BigDecimal weight;

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

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getHospitalDeptId() {
        return hospitalDeptId;
    }

    public void setHospitalDeptId(Integer hospitalDeptId) {
        this.hospitalDeptId = hospitalDeptId;
    }

    public String getNurseCellCode() {
        return nurseCellCode;
    }

    public void setNurseCellCode(String nurseCellCode) {
        this.nurseCellCode = nurseCellCode == null ? null : nurseCellCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(String idUrl) {
        this.idUrl = idUrl == null ? null : idUrl.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", hospitalDeptId=").append(hospitalDeptId);
        sb.append(", nurseCellCode=").append(nurseCellCode);
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", marriage=").append(marriage);
        sb.append(", birthday=").append(birthday);
        sb.append(", pcaCode=").append(pcaCode);
        sb.append(", address=").append(address);
        sb.append(", postCode=").append(postCode);
        sb.append(", mobile=").append(mobile);
        sb.append(", intro=").append(intro);
        sb.append(", specialty=").append(specialty);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", education=").append(education);
        sb.append(", title=").append(title);
        sb.append(", duties=").append(duties);
        sb.append(", idType=").append(idType);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", idUrl=").append(idUrl);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
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