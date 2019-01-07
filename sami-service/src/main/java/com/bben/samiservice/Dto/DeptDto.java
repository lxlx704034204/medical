package com.bben.samiservice.Dto;

import com.bben.common.util.JsonUtil;
import com.bben.samiservice.model.samiservice.TDept;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DeptDto {

    @ApiParam("科室编码")
    private String code;

    @ApiParam("科室名称")
    private String name;

    @ApiParam("科室英文")
    private String ename;

    @ApiParam("科室简称")
    private String simpleName;

    @ApiParam("科室类型 C 门诊  I  住院  F  财务 L  后勤(logistics)  PI  药库 T 医技(terminal)  O  其它 D  机关(department)P  药房   N 护士站")
    private String type;

    @ApiParam("科室简介")
    private String intro;

    @ApiParam("是否挂号科室 0 假 1 真")
    private Byte regdeptFlag;

    @ApiParam("是否核算科室 0 假 1 真")
    private Byte tatdeptFlag;

    @ApiParam("特殊科室属性 0 普通, 1 手术,  2 麻醉, 3 ICU,  4 CCU, C 产科,E急诊留观,T特诊")
    private String deptPro;

    @ApiParam("有效性标志 1在用 0 停用 2 废弃")
    private Byte status;

    @ApiParam("备注")
    private String description;

    public static TDept assemblyData(DeptDto deptDto){
        TDept tDept = JsonUtil.convert(deptDto,TDept.class);
        tDept.setCreateTime(new Date());
        return tDept;
    }
}
