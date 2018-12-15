package com.bben.infusion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(description= "返回响应数据")
public class TPatientEquipRefVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("病人id")
    private Integer patientId;

    @ApiModelProperty("设备号")
    private String equipmentSn;
}
