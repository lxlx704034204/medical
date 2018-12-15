package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TDrugsDoseDto {

    @ApiParam("用药记录表id")
    private Integer medicationRecordId;

    @ApiParam("药品名称及规格")
    private String drugName;

    @ApiParam("早餐用量")
    private String breakfastConsumption;

    @ApiParam("午餐用量")
    private String lunchConsumption;

    @ApiParam("晚餐用量")
    private String dinnerConsumption;

    @ApiParam("睡前用量")
    private String beforeSleepConsumption;

    @ApiParam("其他")
    private String other;

    @ApiParam("备注")
    private String description;

    public static TDrugsDose assemblyData(TDrugsDoseDto tDrugsDoseDto){
        TDrugsDose tDrugsDose = JsonUtil.convert(tDrugsDoseDto,TDrugsDose.class);
        tDrugsDose.setCreateTime(new Date());
        return tDrugsDose;
    }
}
