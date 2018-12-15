package com.bben.infusion.model.infusion;

import java.io.Serializable;

public class TInfusionBatteryLife implements Serializable {
    private Integer id;

    private String modelType;

    private Integer voltage;

    private Integer continueTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType == null ? null : modelType.trim();
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(Integer continueTime) {
        this.continueTime = continueTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", modelType=").append(modelType);
        sb.append(", voltage=").append(voltage);
        sb.append(", continueTime=").append(continueTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}