package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TBed;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/9 18:05
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "床位信息返回响应数据")
public class TBedVo {

    @ApiModelProperty("床位id")
    private Integer id;

    @ApiModelProperty("床头卡id")
    private Integer bedCardId;

    @ApiModelProperty("病区id")
    private Integer sickroomId;

    @ApiModelProperty("床位类型")
    private String bedType;

    @ApiModelProperty("床位号")
    private String bedNum;

    @ApiModelProperty("使用状态")
    private Integer useStatus;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("病房表返回响应数据")
    private TSickroomVo tSickroomVo;

    @ApiModelProperty("病区表返回响应数据")
    private TWardVo tWardVo;

    @ApiModelProperty("病人返回响应数据")
    private TPatientVo tPatientVo;

    public static TBedVo assemblyData(TBed tBed){
        return JsonUtil.convert(tBed,TBedVo.class);
    }

    public static List<TBedVo> assemblyDataList(List<TBed> tBedCardList){
        return JsonUtil.convertList(tBedCardList,TBedVo.class);
    }

}
