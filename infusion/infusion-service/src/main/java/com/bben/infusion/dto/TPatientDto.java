package com.bben.infusion.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TPatientDto {
    @ApiParam("id")
    private Integer id;

    @ApiParam("code")
    private String code;

    @ApiParam("病人名称")
    private String name;

    @ApiParam("医院号")
    private String hospitalId;

    @ApiParam("院区号")
    private String districtId;

    @ApiParam("科室号")
    private String deptId;

    @ApiParam("病区号")
    private String wardId;

    @ApiParam("病房号")
    private String sickroomNo;

    @ApiParam("住院号")
    private String cureNo;

    @ApiParam("病床号")
    private String bedNo;

    @ApiParam("性别")
    private Integer sex;

    @ApiParam("婚否")
    private Integer marriage;

    @ApiParam("出生时间")
    private Date birthday;

    @ApiParam("行政区代码")
    private Integer pcaCode;

    @ApiParam("地址")
    private String address;

    @ApiParam("手机")
    private String mobile;

    @ApiParam("区域代码")
    private String areaCode;

    @ApiParam("学历")
    private String education;

    @ApiParam("职称")
    private String duties;

    @ApiParam("证件类型")
    private Integer idType;

    @ApiParam("证件号码")
    private String idNumber;

    @ApiParam("护理级别")
    private String nurseLevel;

    @ApiParam("身高")
    private BigDecimal height;

    @ApiParam("体重")
    private BigDecimal weight;
}

