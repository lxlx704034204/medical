package com.bben.infusion.model.infusion;

import java.io.Serializable;

public class TInfusionBatteryLifeKey implements Serializable {
    private String modelType;

    private Integer voltage;

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", modelType=").append(modelType);
        sb.append(", voltage=").append(voltage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}