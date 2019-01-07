package com.bben.samiservice.Dto;

import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.samiservice.model.samiservice.TDoctor;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

    @ApiParam("员工代码")
    private String code;

    @ApiParam("所属科室号")
    private Integer hospitalDeptId;

    @ApiParam("所属护理站")
    private Integer nurseCellCode;

    @ApiParam("员工姓名")
    private String doctorName;

    @ApiParam("性别")
    private Integer sex;

    @ApiParam("出生日期")
    private Date birthday;

    @ApiParam("是否专家")
    private Byte isExpert;

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

    public static TDoctor assemblyData(DoctorDto doctorDto){
        TDoctor tDoctor = JsonUtil.convert(doctorDto,TDoctor.class);
        tDoctor.setHospitalId(1);
        if (U.isNotBlank(tDoctor)){
            tDoctor.setCreateTime(new Date());
        }
        return tDoctor;
    }

}
