package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TWard;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/10 11:06
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "病区表返回响应数据")
public class TWardVo {

    @ApiModelProperty("病区id")
    private Integer id;

    @ApiModelProperty("病区名称")
    private String name;

    @ApiModelProperty("位置")
    private String position;

    @ApiModelProperty("负责人")
    private String dutyBy;

    @ApiModelProperty("HISID")
    private String hisId;

    @ApiModelProperty("备注")
    private String description;

    public static TWardVo assemblyData(TWard tWard){
        return JsonUtil.convert(tWard,TWardVo.class);
    }

    public static List<TWardVo> assemblyDataList(List<TWard> tWardList){
        return JsonUtil.convertList(tWardList,TWardVo.class);
    }
}
