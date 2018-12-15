package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TMedicationRecord;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TMedicationRecordDto {

    @ApiParam("病人id")
    private Integer patientId;

    @ApiParam("住院号")
    private String cureNo;


    @ApiParam("药品发放护士id")
    private Integer drugDeliveryNurseId;

    @ApiModelProperty("住院日期")
    private Date dateOfHospitalization;

    @ApiParam("备注")
    private String description;

    public static TMedicationRecord assemblyData(TMedicationRecordDto tMedicationRecordDto){
        TMedicationRecord tMedicationRecord = JsonUtil.convert(tMedicationRecordDto,TMedicationRecord.class);
        tMedicationRecord.setCreateTime(new Date());
        return tMedicationRecord;
    }
}
