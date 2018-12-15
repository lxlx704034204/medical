package com.bben.medical.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(description= "返回响应数据")
public class GradeVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("grade")
    private String grade;

    @ApiModelProperty("gradecolor")
    private String gradecolor;
}
