package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.THospital;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/13 14:57
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "医院表返回数据")
public class THospitalVo {

    @ApiModelProperty("医院ID")
    private Integer id;

    @ApiModelProperty("医院名称")
    private String name;

    @ApiModelProperty("简介")
    private String intro;

    @ApiModelProperty("许可证")
    private String license;

    @ApiModelProperty("Logo地址")
    private String logoUrl;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("邮编")
    private String postCode;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("图片")
    private String imageUrl;

    @ApiModelProperty("区域")
    private String areaName;

    @ApiModelProperty("负责人姓名")
    private String masterName;

    @ApiModelProperty("负责人电话")
    private String masterMobile;

    @ApiModelProperty("经度")
    private BigDecimal longitude;

    @ApiModelProperty("纬度")
    private BigDecimal latitude;

    @ApiModelProperty("机构类型")
    private Integer orgType;

    @ApiModelProperty("层级")
    private Integer level;

    @ApiModelProperty("层级路径")
    private String path;

    @ApiModelProperty("父级ID")
    private Integer parentId;

    @ApiModelProperty("是否在Web前端显示")
    private Boolean isShowWeb;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("父科室表返回响应")
    private List<TDeptVo> tParentDeptVoList;

    public static THospitalVo assemblyData(THospital tHospital){
        return JsonUtil.convert(tHospital,THospitalVo.class);
    }

    public static List<THospitalVo> assemblyDataList(List<THospital> tHospitalList){
        return JsonUtil.convertList(tHospitalList,THospitalVo.class);
    }
}
