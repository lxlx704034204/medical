package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:57
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "问题答案返回响应数据")
public class TQuestionAnswerVo {
    @ApiModelProperty("问题答案id")
    private Integer id;

    @ApiModelProperty("答案名称")
    private String answerName;

    @ApiModelProperty("问题id")
    private Integer questionId;

    @ApiModelProperty("答案图片地址")
    private String imageUrl;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("是否选中")
    private boolean ischoose;

    public static TQuestionAnswerVo assemblyData(TQuestionAnswer tQuestionAnswer){
        return JsonUtil.convert(tQuestionAnswer,TQuestionAnswerVo.class);
    }

    public static List<TQuestionAnswerVo> assemblyDataList(List<TQuestionAnswer> tQuestionAnswerList){
        return JsonUtil.convertList(tQuestionAnswerList,TQuestionAnswerVo.class);
    }
}
