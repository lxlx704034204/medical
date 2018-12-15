package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.THospitalDept;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 14:38
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "医院科室返回数据")
public class THospitalDeptVo {

    @ApiModelProperty("医院科室ID")
    private Integer id;

    @ApiModelProperty("科室ID")
    private Integer deptId;

    @ApiModelProperty("医院ID")
    private Integer hospitalId;

    @ApiModelProperty("父科室ID")
    private Integer parentDeptId;

    @ApiModelProperty("科室地址")
    private String deptAddress;

    @ApiModelProperty("备注")
    private String description;

    public static THospitalDeptVo assemblyData(THospitalDept tHospitalDept){
        return JsonUtil.convert(tHospitalDept,THospitalDeptVo.class);
    }

    public static List<THospitalDeptVo> assemblyDataList(List<THospitalDept> tHospitalDeptList){
        return JsonUtil.convertList(tHospitalDeptList,THospitalDeptVo.class);
    }
}

