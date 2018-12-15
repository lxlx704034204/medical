package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TCareLable;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 9:54
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "护理标签返回响应数据")
public class TCareLableVo {

    @ApiModelProperty("护理标签id")
    private Integer id;

    @ApiModelProperty("标签名称")
    private String lableName;

    @ApiModelProperty("标签颜色(用RGB颜色代码表示)")
    private String viewColor;

    @ApiModelProperty("详细内容")
    private String detailContent;

    @ApiModelProperty("状态1=有效，0=无效")
    private Byte status;

    @ApiModelProperty("备注")
    private String description;

    public static TCareLableVo assemblyData(TCareLable tCareLable){
        return JsonUtil.convert(tCareLable,TCareLableVo.class);
    }

    public static List<TCareLableVo> assemblyDataList(List<TCareLable> tCareLableList){
        return JsonUtil.convertList(tCareLableList,TCareLableVo.class);
    }
}
