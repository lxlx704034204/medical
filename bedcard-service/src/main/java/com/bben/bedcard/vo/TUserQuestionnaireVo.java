package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/15 10:54
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "调查问卷返回实体")
public class TUserQuestionnaireVo {

    @ApiModelProperty("调查问卷id")
    private Integer id;

    @ApiModelProperty("问题id")
    private Integer questionId;

    @ApiModelProperty("答案id")
    private Integer answerId;

    @ApiModelProperty("答题用户id")
    private Integer userId;

    @ApiModelProperty("状态1=有效，0=无效")
    private Byte status;

    @ApiModelProperty("备注")
    private String description;

    public static TUserQuestionnaireVo assemblyData(TUserQuestionnaire tUserQuestionnaire){
        return JsonUtil.convert(tUserQuestionnaire,TUserQuestionnaireVo.class);
    }

    public static List<TUserQuestionnaireVo> assemblyDataList(List<TUserQuestionnaire> tUserQuestionnaireList){
        return JsonUtil.convertList(tUserQuestionnaireList,TUserQuestionnaireVo.class);
    }


}
