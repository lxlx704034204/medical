package com.bben.nurseboardservice.model.nurseboardservice;

import java.io.Serializable;
import java.util.Date;

public class TDept implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private String ename;

    private String simpleName;

    private String type;

    private String intro;

    private Byte regdeptFlag;

    private Byte tatdeptFlag;

    private String deptPro;

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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName == null ? null : simpleName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Byte getRegdeptFlag() {
        return regdeptFlag;
    }

    public void setRegdeptFlag(Byte regdeptFlag) {
        this.regdeptFlag = regdeptFlag;
    }

    public Byte getTatdeptFlag() {
        return tatdeptFlag;
    }

    public void setTatdeptFlag(Byte tatdeptFlag) {
        this.tatdeptFlag = tatdeptFlag;
    }

    public String getDeptPro() {
        return deptPro;
    }

    public void setDeptPro(String deptPro) {
        this.deptPro = deptPro == null ? null : deptPro.trim();
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", ename=").append(ename);
        sb.append(", simpleName=").append(simpleName);
        sb.append(", type=").append(type);
        sb.append(", intro=").append(intro);
        sb.append(", regdeptFlag=").append(regdeptFlag);
        sb.append(", tatdeptFlag=").append(tatdeptFlag);
        sb.append(", deptPro=").append(deptPro);
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