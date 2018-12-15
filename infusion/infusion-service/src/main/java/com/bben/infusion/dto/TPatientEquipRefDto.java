package com.bben.infusion.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TPatientEquipRefDto {
    @ApiParam("id")
    private Integer id;

    @ApiParam("病人id")
    private Integer patientId;

    @ApiParam("设备号")
    private String equipmentSn;
}
