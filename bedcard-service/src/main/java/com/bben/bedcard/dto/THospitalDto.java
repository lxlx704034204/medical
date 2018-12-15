package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.THospital;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/13 16:59
 */
@Getter
@Setter
@NoArgsConstructor
public class THospitalDto {

    @ApiParam("医院名称")
    private String name;

    @ApiParam("简介")
    private String intro;

    @ApiParam("许可证")
    private String license;

    @ApiParam("Logo地址")
    private String logoUrl;

    @ApiParam("地址")
    private String address;

    @ApiParam("邮编")
    private String postCode;

    @ApiParam("电话")
    private String phone;

    @ApiParam("电子邮箱")
    private String email;

    @ApiParam("图片")
    private String imageUrl;

    @ApiParam("区域")
    private String areaName;

    @ApiParam("负责人姓名")
    private String masterName;

    @ApiParam("负责人电话")
    private String masterMobile;

    @ApiParam("经度")
    private BigDecimal longitude;

    @ApiParam("纬度")
    private BigDecimal latitude;

    @ApiParam("机构类型")
    private Integer orgType;

    @ApiParam("层级")
    private Integer level;

    @ApiParam("层级路径")
    private String path;

    @ApiParam("父级ID")
    private Integer parentId;

    @ApiParam("是否在Web前端显示")
    private Boolean isShowWeb;

    @ApiParam("备注")
    private String description;

    @ApiParam("消息Id")
    private String messageId;

    @ApiParam("数据Id")
    private String dataId;

    @ApiParam("操作类型")
    private String operationType;


    public static THospital assemblyData(THospitalDto tHospitalDto){
        THospital tHospital = JsonUtil.convert(tHospitalDto,THospital.class);
        tHospital.setCreateTime(new Date());
        return tHospital;
    }
}
