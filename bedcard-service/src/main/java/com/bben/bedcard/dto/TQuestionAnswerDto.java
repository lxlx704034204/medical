package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 11:26
 */
@Getter
@Setter
@NoArgsConstructor
public class TQuestionAnswerDto {

    @ApiParam("问题id")
    private Integer questionId;

    @ApiParam("答案名称")
    private String answerName;

    @ApiParam("答案图片地址")
    private String imageUrl;

    @ApiParam("排序")
    private Integer sort;

    @ApiParam("状态1=有效，0=无效")
    private Byte status;

    @ApiParam("备注")
    private String description;

    public static TQuestionAnswer assemblyData(TQuestionAnswerDto tQuestionAnswerDto){
        TQuestionAnswer tQuestionAnswer = JsonUtil.convert(tQuestionAnswerDto,TQuestionAnswer.class);
        tQuestionAnswer.setCreateTime(new Date());
        return tQuestionAnswer;
    }

}
