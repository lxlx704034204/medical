package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TDept;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 17:02
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "科室表返回响应")
public class TDeptVo {

    @ApiModelProperty("科室ID")
    private Integer id;

    @ApiModelProperty("科室名称")
    private String name;

    @ApiModelProperty("简介")
    private String intro;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("子科室表返回响应")
    private List<TDeptVo> tSonDeptVoList;

    public static TDeptVo assemblyData(TDept tDept){
        return JsonUtil.convert(tDept,TDeptVo.class);
    }

    public static List<TDeptVo> assemblyDataList(List<TDept> tDeptList){
        return JsonUtil.convertList(tDeptList,TDeptVo.class);
    }

}
