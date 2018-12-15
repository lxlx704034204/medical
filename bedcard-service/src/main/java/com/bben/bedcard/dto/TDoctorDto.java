package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 16:36
 */
@Getter
@Setter
@NoArgsConstructor
public class TDoctorDto {

    @ApiParam("医院ID")
    private Integer hospitalId;

    @ApiParam("医院科室ID")
    private Integer hospitalDeptId;

    @ApiParam("用户ID")
    private Integer userId;

    @ApiParam("医生名称")
    private String doctorName;

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

    @ApiParam("邮政编码")
    private String postCode;

    @ApiParam("手机号码")
    private String mobile;

    @ApiParam("简介")
    private String intro;

    @ApiParam("是否专家（0-否、1-是）")
    private Boolean isExpert;

    @ApiParam("特长")
    private String specialty;

    @ApiParam("区域编码")
    private String areaCode;

    @ApiParam("学历")
    private String education;

    @ApiParam("职称")
    private String title;

    @ApiParam("社会机构及职务")
    private String duties;

    @ApiParam("机构编码")
    private String orgCode;

    @ApiParam("证件类型")
    private Integer idType;

    @ApiParam("证件号码")
    private String idNumber;

    @ApiParam("证书编号")
    private String certificateNo;

    @ApiParam("证件图片")
    private String idUrl;

    @ApiParam("认证状态（0-未认证、1-已通过、2-未通过、3-驳回）")
    private Integer checkState;

    @ApiParam("签名图片URL")
    private String signatureUrl;

    @ApiParam("手持证件图片")
    private String handheldIdUrl;

    @ApiParam("医师执业证书图片")
    private String certificateUrl;

    @ApiParam("医生图像图片")
    private String imageUrl;

    @ApiParam("BJCA医生唯一标识")
    private String openId;

    @ApiParam("身高")
    private BigDecimal height;

    @ApiParam("体重")
    private BigDecimal weight;

    @ApiParam("BPM指数")
    private String bpm;

    @ApiParam("挂号金额")
    private Integer guoHaoMoney;

    @ApiParam("备注")
    private String description;

    @ApiParam("消息Id")
    private String messageId;

    @ApiParam("数据Id")
    private String dataId;

    @ApiParam("操作类型")
    private String operationType;

    @ApiParam("医院数据ID")
    private String hospitalDataId;

    @ApiParam("医院科室数据ID")
    private String hospitalDeptDataId;

    public static TDoctor assemblyData(TDoctorDto tDoctorDto){
        TDoctor tDoctor = new TDoctor();
        if (U.isBlank(tDoctorDto)){
            return tDoctor;
        }
        tDoctor.setCreateTime(new Date());
        tDoctor = JsonUtil.convert(tDoctorDto,TDoctor.class);
        return tDoctor;
    }

}
