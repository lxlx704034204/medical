package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TMedicationRecord;
import com.bben.common.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "用药记录返回实体")
public class  TMedicationRecordVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("病人id")
    private Integer patientId;

    @ApiModelProperty("住院号")
    private String cureNo;

    @ApiModelProperty("药品发放护士id")
    private Integer drugDeliveryNurseId;

    @ApiModelProperty("药品发放护士姓名")
    private String drugDeliveryNurseName;

    @ApiModelProperty("住院日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateOfHospitalization;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("用药剂量")
    private List<TDrugsDoseVo> tDrugsDoseVoList;

    public static TMedicationRecordVo assemblyData(TMedicationRecord tMedicationRecord){
        return JsonUtil.convert(tMedicationRecord,TMedicationRecordVo.class);
    }

    public static List<TMedicationRecordVo> assemblyDataList(List<TMedicationRecord> tMedicationRecordList){
        return JsonUtil.convertList(tMedicationRecordList,TMedicationRecordVo.class);
    }
}
