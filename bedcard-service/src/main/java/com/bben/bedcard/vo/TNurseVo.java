package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TNurse;
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
 * @Date: 2018/11/12 15:43
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "护士返回响应数据")
public class TNurseVo {

    @ApiModelProperty("护士ID")
    private Integer id;

    @ApiModelProperty("工号")
    private String code;

    @ApiModelProperty("医院ID")
    private Integer hospitalId;

    @ApiModelProperty("医院科室ID")
    private Integer hospitalDeptId;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("护士姓名")
    private String name;

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

    @ApiModelProperty("证件类型")
    private Integer idType;

    @ApiModelProperty("证件号码")
    private String idNumber;

    @ApiModelProperty("证件图片")
    private String idUrl;

    @ApiModelProperty("护士头像图片")
    private String imageUrl;

    @ApiModelProperty("身高")
    private BigDecimal height;

    @ApiModelProperty("体重")
    private BigDecimal weight;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("科室信息")
    private TDeptVo tDeptVo;

    public static TNurseVo assemblyData(TNurse tNurse){
        return JsonUtil.convert(tNurse,TNurseVo.class);
    }

    public static List<TNurseVo> assemblyDataList(List<TNurse> tNurseList){
        return JsonUtil.convertList(tNurseList,TNurseVo.class);
    }
}
