package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TQuestion;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:43
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "问题返回响应数据")
public class TQuestionVo {

    @ApiModelProperty("问题列表id")
    private Integer id;

    @ApiModelProperty("问题名称")
    private String name;

    @ApiModelProperty("问卷类型")
    private Integer questionTypeId;

    @ApiModelProperty("问题控件类型")
    private String controlType;

    @ApiModelProperty("默认值")
    private String defaultValue;

    @ApiModelProperty("问题图片地址")
    private String imageUrl;

    @ApiModelProperty("问题状态")
    private Integer questionStatus;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("问题类型实体")
    private TQuestionTypeVo tQuestionTypeVo;

    @ApiModelProperty("问题答案返回实体")
    private List<TQuestionAnswerVo> tQuestionAnswerVoList;

    public static TQuestionVo assemblyData(TQuestion tQuestion){
        return JsonUtil.convert(tQuestion,TQuestionVo.class);
    }

    public static List<TQuestionVo> assemblyDataList(List<TQuestion> tQuestionList){
        return JsonUtil.convertList(tQuestionList,TQuestionVo.class);
    }
}
