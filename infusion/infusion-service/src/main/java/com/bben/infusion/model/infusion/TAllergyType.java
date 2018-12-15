package com.bben.infusion.model.infusion;

import java.io.Serializable;
import java.util.Date;

public class TAllergyType implements Serializable {
    private Integer id;

    private String allergyContent;

    private String mattersNeedAttention;

    private Byte status;

    private String description;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private byte[] allergyLevel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllergyContent() {
        return allergyContent;
    }

    public void setAllergyContent(String allergyContent) {
        this.allergyContent = allergyContent == null ? null : allergyContent.trim();
    }

    public String getMattersNeedAttention() {
        return mattersNeedAttention;
    }

    public void setMattersNeedAttention(String mattersNeedAttention) {
        this.mattersNeedAttention = mattersNeedAttention == null ? null : mattersNeedAttention.trim();
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

    public byte[] getAllergyLevel() {
        return allergyLevel;
    }

    public void setAllergyLevel(byte[] allergyLevel) {
        this.allergyLevel = allergyLevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", allergyContent=").append(allergyContent);
        sb.append(", mattersNeedAttention=").append(mattersNeedAttention);
        sb.append(", status=").append(status);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", allergyLevel=").append(allergyLevel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}