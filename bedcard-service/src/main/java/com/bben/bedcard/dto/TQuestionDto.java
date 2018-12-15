package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TQuestion;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 15:49
 */
@Getter
@Setter
@NoArgsConstructor
public class TQuestionDto {

    @ApiParam("问题名称")
    private String name;

    @ApiParam("问卷类型")
    private Integer questionTypeId;

    @ApiParam("问题控件类型")
    private String controlType;

    @ApiParam("默认值")
    private String defaultValue;

    @ApiParam("排序")
    private Integer sort;

    @ApiParam("问题图片地址")
    private String imageUrl;

    @ApiParam("问题状态")
    private Integer questionStatus;

    @ApiParam("备注")
    private String description;

    public static TQuestion assemblyData(TQuestionDto tQuestionDto){
        TQuestion tQuestion = JsonUtil.convert(tQuestionDto,TQuestion.class);
        tQuestion.setCreateTime(new Date());
        return tQuestion;
    }
}
