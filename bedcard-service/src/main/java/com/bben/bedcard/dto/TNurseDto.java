package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TNurse;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author BBEN_LI
 */
@Getter
@Setter
@NoArgsConstructor
public class TNurseDto {

    @ApiParam("消息id")
    private String messageId;

    @ApiParam("数据id")
    private String dataId;

    @ApiParam("工号")
    private String code;

    @ApiParam("医院ID")
    private Integer hospitalId;

    @ApiParam("医院科室ID")
    private Integer hospitalDeptId;

    @ApiParam("用户ID")
    private Integer userId;

    @ApiParam("护士姓名")
    private String name;

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

    @ApiParam("证件类型")
    private Integer idType;

    @ApiParam("证件号码")
    private String idNumber;

    @ApiParam("证件图片")
    private String idUrl;

    @ApiParam("护士头像图片")
    private String imageUrl;

    @ApiParam("身高")
    private BigDecimal height;

    @ApiParam("体重")
    private BigDecimal weight;

    @ApiParam("备注")
    private String description;

    @ApiParam("操作类型")
    private String operationType;

    @ApiParam("医院数据ID")
    private String hospitalDataId;

    @ApiParam("医院科室数据ID")
    private String hospitalDeptDataId;

    public static TNurse assemblyData(TNurseDto tNurseDto){
        TNurse tNurse = JsonUtil.convert(tNurseDto,TNurse.class);
        tNurse.setCreateTime(new Date());
        return tNurse;
    }
}
