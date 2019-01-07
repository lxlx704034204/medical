package com.bben.samiservice.Dto;

import com.bben.common.util.JsonUtil;
import com.bben.samiservice.model.samiservice.TPatient;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PatientDto {

    @ApiParam("病人编码")
    private String code;

    @ApiParam("病人姓名")
    private String name;

    @ApiParam("病人医院id")
    private String hospitalId;

    @ApiParam("病人院区id")
    private String districtId;

    @ApiParam("科室id")
    private String deptId;

    @ApiParam("病区id")
    private String wardId;

    @ApiParam("病房号")
    private String sickroomNo;

    @ApiParam("住院号")
    private String cureNo;

    @ApiParam("病床号")
    private String bedNo;

    @ApiParam("护理级别")
    private String nurseLevel;

    @ApiParam("性别（0-男、1-女、2-未知）")
    private Integer sex;

    @ApiParam("婚姻情况(0-未婚、1-已婚、2-未知)")
    private Integer marriage;

    @ApiParam("出生日期")
    private Date birthday;

    @ApiParam("行政区代码")
    private Integer pcaCode;

    @ApiParam("地址")
    private String address;

    @ApiParam("手机号码")
    private String mobile;

    @ApiParam("学历")
    private String education;

    @ApiParam("社会机构及职务")
    private String duties;

    @ApiParam("证件类型")
    private Integer idType;

    @ApiParam("证件号码")
    private String idNumber;

    @ApiParam("身高")
    private BigDecimal height;

    @ApiParam("体重")
    private BigDecimal weight;

    @ApiParam("区域")
    private String areaCode;

    @ApiParam("入院时间")
    private Date admissionTime;

    @ApiParam("出院时间")
    private Date dischargeTime;

    @ApiParam("状态1=有效，0=无效")
    private Byte status;

    @ApiParam("备注")
    private String description;

    public static TPatient assemblyData(PatientDto patientDto){
        TPatient tPatient = JsonUtil.convert(patientDto,TPatient.class);
        tPatient.setHospitalId("1");
        tPatient.setDistrictId("1");
        tPatient.setIdNumber("1");
        tPatient.setIdType(1);
        tPatient.setCreateTime(new Date());
        return tPatient;
    }
}
