package com.bben.medical.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GradeDto {
    @ApiParam("id")
    private Integer id;

    @ApiParam("grade")
    private String grade;

    @ApiParam("gradecolor")
    private String gradecolor;
}
