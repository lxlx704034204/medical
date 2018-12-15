package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "药品剂量返回实体")
public class TDrugsDoseVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("用药记录表id")
    private Integer medicationRecordId;

    @ApiModelProperty("药品名称及规格")
    private String drugName;

    @ApiModelProperty("早餐用量")
    private String breakfastConsumption;

    @ApiModelProperty("午餐用量")
    private String lunchConsumption;

    @ApiModelProperty("晚餐用量")
    private String dinnerConsumption;

    @ApiModelProperty("睡前用量")
    private String beforeSleepConsumption;

    @ApiModelProperty("其他")
    private String other;

    @ApiModelProperty("备注")
    private String description;

    public static TDrugsDoseVo assemblyData(TDrugsDose tDrugsDose){
        return JsonUtil.convert(tDrugsDose,TDrugsDoseVo.class);
    }

    public static List<TDrugsDoseVo> assemblyDataList(List<TDrugsDose> tDrugsDoseList){
        return JsonUtil.convertList(tDrugsDoseList,TDrugsDoseVo.class);
    }
}
