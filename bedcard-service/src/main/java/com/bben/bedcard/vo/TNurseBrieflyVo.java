package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TNurse;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 11:41
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "护士简要信息数据返回")
public class TNurseBrieflyVo {

    @ApiModelProperty("护士ID")
    private Integer id;

    @ApiModelProperty("护士姓名")
    private String name;

    @ApiModelProperty("性别（0-男、1-女、2-未知）")
    private Integer sex;

    public static TNurseBrieflyVo assemblyData(TNurse tNurse){
        return JsonUtil.convert(tNurse,TNurseBrieflyVo.class);
    }

    public static List<TNurseBrieflyVo> assemblyDataList(List<TNurse> tNurseList){
        return JsonUtil.convertList(tNurseList,TNurseBrieflyVo.class);
    }
}
