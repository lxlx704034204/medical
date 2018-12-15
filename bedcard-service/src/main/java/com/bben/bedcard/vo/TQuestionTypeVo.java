package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TQuestionType;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:52
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "问题类型返回响应数据")
public class TQuestionTypeVo {

    @ApiModelProperty("名称")
    private Integer id;

    @ApiModelProperty("所属科室")
    private String name;

    @ApiModelProperty("是否有效性")
    private String deptOwner;

    @ApiModelProperty("备注")
    private String description;

    public static TQuestionTypeVo assemblyData(TQuestionType tQuestionType){
        return JsonUtil.convert(tQuestionType,TQuestionTypeVo.class);
    }

    public static List<TQuestionTypeVo> assemblyDataList(List<TQuestionType> tQuestionTypes){
        return JsonUtil.convertList(tQuestionTypes,TQuestionTypeVo.class);
    }
}
