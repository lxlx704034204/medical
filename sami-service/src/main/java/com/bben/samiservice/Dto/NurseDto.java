package com.bben.samiservice.Dto;

import com.bben.common.util.JsonUtil;
import com.bben.samiservice.model.samiservice.TNurse;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class NurseDto {

    @ApiParam("员工代码")
    private String code;

    @ApiParam("所属科室号")
    private Integer hospitalDeptId;

    @ApiParam("所属护理站")
    private Integer nurseCellCode;

    @ApiParam("员工姓名")
    private String name;

    @ApiParam("性别")
    private Integer sex;

    @ApiParam("出生日期")
    private Date birthday;

    @ApiParam("学历")
    private String education;

    @ApiParam("职级代号")
    private String title;

    @ApiParam("职务代号")
    private String duties;

    @ApiParam("身份证号")
    private String idNumber;

    @ApiParam("状态 1 有效 0 停用 2 废弃")
    private Byte status;

    @ApiParam("备注")
    private String description;

    public static TNurse assemblyData(NurseDto nurseDto){
        TNurse tNurse = JsonUtil.convert(nurseDto,TNurse.class);
        tNurse.setHospitalId(1);
        tNurse.setCreateTime(new Date());
        return tNurse;
    }
}
