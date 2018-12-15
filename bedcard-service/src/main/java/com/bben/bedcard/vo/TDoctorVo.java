package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.common.util.JsonUtil;
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
 * @Date: 2018/11/12 15:03
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "医生表返回响应数据")
public class TDoctorVo {

    @ApiModelProperty("医生ID")
    private Integer id;

    @ApiModelProperty("工号")
    private String code;

    @ApiModelProperty("医院ID")
    private Integer hospitalId;

    @ApiModelProperty("医院科室ID")
    private Integer hospitalDeptId;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("医生名称")
    private String doctorName;

    @ApiModelProperty("性别（0-男、1-女、2-未知）")
    private Integer sex;

    @ApiModelProperty("婚姻情况(0-未婚、1-已婚、2-未知)")
    private Integer marriage;

    @ApiModelProperty("出生日期")
    private Date birthday;

    @ApiModelProperty("行政区代码")
    private Integer pcaCode;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("邮政编码")
    private String postCode;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("简介")
    private String intro;

    @ApiModelProperty("是否专家（0-否、1-是）")
    private Boolean isExpert;

    @ApiModelProperty("特长")
    private String specialty;

    @ApiModelProperty("区域编码")
    private String areaCode;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("职称")
    private String title;

    @ApiModelProperty("社会机构及职务")
    private String duties;

    @ApiModelProperty("机构编码")
    private String orgCode;

    @ApiModelProperty("证件类型")
    private Integer idType;

    @ApiModelProperty("证件号码")
    private String idNumber;

    @ApiModelProperty("证书编号")
    private String certificateNo;

    @ApiModelProperty("证件图片")
    private String idUrl;

    @ApiModelProperty("医师执业证书图片")
    private String certificateUrl;

    @ApiModelProperty("医生图像图片")
    private String imageUrl;

    @ApiModelProperty("BJCA医生唯一标识")
    private String openId;

    @ApiModelProperty("身高")
    private BigDecimal height;

    @ApiModelProperty("体重")
    private BigDecimal weight;

    @ApiModelProperty("BPM指数")
    private String bpm;

    @ApiModelProperty("挂号金额")
    private Integer guoHaoMoney;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("科室信息")
    private TDeptVo tDeptVo;

    public static TDoctorVo assemblyData(TDoctor tDoctor){
        return JsonUtil.convert(tDoctor,TDoctorVo.class);
    }

    public static List<TDoctorVo> assemblyDataList(List<TDoctor> tDoctorList){
        return JsonUtil.convertList(tDoctorList,TDoctorVo.class);
    }
}

