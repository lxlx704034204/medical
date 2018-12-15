package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TAllergyType;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/9 15:25
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "过敏类型返回响应数据")
public class TAllergyTypeVo {

    @ApiModelProperty("过敏类型id")
    private Integer id;

    @ApiModelProperty("过敏内容")
    private String allergyContent;

    @ApiModelProperty("过敏级别")
    private byte[] allergyLevel;

    @ApiModelProperty("注意事项")
    private String mattersNeedAttention;

    public static TAllergyTypeVo assemblyData(TAllergyType tAllergyType){
        return JsonUtil.convert(tAllergyType,TAllergyTypeVo.class);
    }

    public static List<TAllergyTypeVo> assemblyDataList(List<TAllergyType> tAllergyTypeList){
        return JsonUtil.convertList(tAllergyTypeList,TAllergyTypeVo.class);
    }
}
