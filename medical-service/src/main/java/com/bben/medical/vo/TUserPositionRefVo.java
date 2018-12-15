package com.bben.medical.vo;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TUserPositionRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 15:16
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TUserPositionRefVo {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("岗位id")
    private Integer positionId;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("岗位响应Model")
    private TPositionVo tPositionVo;

    public static TUserPositionRefVo assemblyData(TUserPositionRef tUserPositionRef){
        return JsonUtil.convert(tUserPositionRef,TUserPositionRefVo.class);
    }

    public static List<TUserPositionRefVo> assemblyDataList(List<TUserPositionRef> tUserPositionRefList){
        return JsonUtil.convertList(tUserPositionRefList,TUserPositionRefVo.class);
    }

}
