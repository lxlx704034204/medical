package com.bben.bedcard.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TPatientDoctorAndNurseDto {

    @ApiParam("/病人数据id")
    private Integer patientDataId;

    @ApiParam("/医生数据id")
    private Integer doctorDataId;

    @ApiParam("/护士数据id")
    private Integer nurseDataId;
}
