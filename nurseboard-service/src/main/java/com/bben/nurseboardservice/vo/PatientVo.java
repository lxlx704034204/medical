package com.bben.nurseboardservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "病人数据")
public class PatientVo {

    @ApiModelProperty("有无数据")
    private boolean hasMore;

    @ApiModelProperty("床位Id")
    private Integer bedId;

    @ApiModelProperty("病人id")
    private Integer id;

    @ApiModelProperty("病人姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("住院号")
    private String cureNo;

    @ApiModelProperty("护理级别")
    private String nurseLevel;

    @ApiModelProperty("护理级别颜色")
    private String nurseLevelColor;

    @ApiModelProperty("责任护士")
    private String nurseName;


}
