package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/15 11:35
 */
@Getter
@Setter
@NoArgsConstructor
public class TUserQuestionnaireDto {

    @ApiParam("问题id")
    private Integer questionId;

    @ApiParam("答案id")
    private Integer answerId;

    @ApiParam("答题用户id")
    private Integer userId;

    @ApiParam("状态1=有效，0=无效")
    private Byte status;

    @ApiParam("备注")
    private String description;

    public static TUserQuestionnaire assemblyData(TUserQuestionnaireDto tUserQuestionnaireDto){
        TUserQuestionnaire tUserQuestionnaire = JsonUtil.convert(tUserQuestionnaireDto,TUserQuestionnaire.class);
        tUserQuestionnaire.setCreateTime(new Date());
        return tUserQuestionnaire;
    }

}
