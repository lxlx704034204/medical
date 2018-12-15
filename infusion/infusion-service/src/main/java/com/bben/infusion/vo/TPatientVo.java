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
public class TPatientVo {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("code")
    private String code;

    @ApiModelProperty("病人名称")
    private String name;

    @ApiModelProperty("医院号")
    private String hospitalId;

    @ApiModelProperty("院区号")
    private String districtId;

    @ApiModelProperty("科室号")
    private String deptId;

    @ApiModelProperty("病区号")
    private String wardId;

    @ApiModelProperty("病房号")
    private String sickroomNo;

    @ApiModelProperty("住院号")
    private String cureNo;

    @ApiModelProperty("病床号")
    private String bedNo;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("婚否")
    private Integer marriage;

    @ApiModelProperty("出生时间")
    private Date birthday;

    @ApiModelProperty("行政区代码")
    private Integer pcaCode;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("手机")
    private String mobile;

    @ApiModelProperty("区域代码")
    private String areaCode;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("职称")
    private String duties;

    @ApiModelProperty("证件类型")
    private Integer idType;

    @ApiModelProperty("证件号码")
    private String idNumber;

    @ApiModelProperty("护理级别")
    private String nurseLevel;

    @ApiModelProperty("身高")
    private BigDecimal height;

    @ApiModelProperty("体重")
    private BigDecimal weight;
}
