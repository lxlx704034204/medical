package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TPatient;
import com.bben.common.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/9 15:24
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "查询病人信息返回响应数据")
public class TPatientVo {

    @ApiModelProperty("病人ID")
    private Integer id;

    @ApiModelProperty("病人代码")
    private String code;

    @ApiModelProperty("病人姓名")
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

    @ApiModelProperty("护理级别")
    private String nurseLevel;

    @ApiModelProperty("性别（0-男、1-女、2-未知）")
    private Integer sex;

    @ApiModelProperty("婚姻情况(0-未婚、1-已婚、2-未知)")
    private Integer marriage;

    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty("行政区代码")
    private Integer pcaCode;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("证件类型")
    private Integer idType;

    @ApiModelProperty("证件号码")
    private String idNumber;

    @ApiModelProperty("身高")
    private BigDecimal height;

    @ApiModelProperty("体重")
    private BigDecimal weight;

    @ApiModelProperty("入院时间")
    private Date admissionTime;

    @ApiModelProperty("病人过敏类型")
    private List<TAllergyTypeVo> tAllergyTypeVoList;

    @ApiModelProperty("病人护理标签")
    private List<TCareLableVo> tCareLableVoList;

    @ApiModelProperty("医生简要信息")
    private List<TDoctorBrieflyVo> tDoctorBrieflyVoList;

    @ApiModelProperty("护士简要信息")
    private List<TNurseBrieflyVo> tNurseBrieflyVoList;

    public static TPatientVo assemblyData(TPatient tPatient){
        return JsonUtil.convert(tPatient,TPatientVo.class);
    }

    public static List<TPatientVo> assemblyDataList(List<TPatient> tPatientList){
        return JsonUtil.convertList(tPatientList,TPatientVo.class);
    }
}
