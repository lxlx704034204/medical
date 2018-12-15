package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TBedCard;
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
 * @Date: 2018/11/10 9:32
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "床头卡返回响应数据")
public class TBedCardVo {

    @ApiModelProperty("设备基本表id")
    private Integer id;

    @ApiModelProperty("设备编号")
    private String code;

    @ApiModelProperty("设备名称")
    private String name;

    @ApiModelProperty("设备类型")
    private Integer type;

    @ApiModelProperty("ip地址")
    private String ip;

    @ApiModelProperty("已经使用")
    private String isUsed;

    @ApiModelProperty("软件版本")
    private String softVersion;

    @ApiModelProperty("保修年时长")
    private BigDecimal warrantyYear;

    @ApiModelProperty("MAC地址")
    private String mac;

    @ApiModelProperty("维修次数")
    private Short repairCount;

    @ApiModelProperty("备注")
    private String description;

    public static TBedCardVo assemblyData(TBedCard tBedCard){
        return JsonUtil.convert(tBedCard,TBedCardVo.class);
    }

    public static List<TBedCardVo> assemblyDataList(List<TBedCard> tBedCardList){
        return JsonUtil.convertList(tBedCardList,TBedCardVo.class);
    }
}
