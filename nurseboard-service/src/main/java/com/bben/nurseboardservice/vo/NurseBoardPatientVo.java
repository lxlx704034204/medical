package com.bben.nurseboardservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "护理看板数据")
public class NurseBoardPatientVo {

    @ApiModelProperty("病区名称")
    private String wardName;

    @ApiModelProperty("病床总数")
    private Integer bedCount;

    @ApiModelProperty("病人总数")
    private Integer patientCount;

    @ApiModelProperty("空闲位置")
    private Integer freeLocationCount;

    @ApiModelProperty("病人数据集合")
    private List<PatientVo> patientVos;

}
