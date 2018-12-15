package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.THospitalDept;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 14:59
 */
@Getter
@Setter
@NoArgsConstructor
public class THospitalDeptDto {

    @ApiParam("消息Id")
    private String messageId;

    @ApiParam("数据Id")
    private String dataId;

    @ApiParam("科室ID")
    private Integer deptId;

    @ApiParam("医院ID")
    private Integer hospitalId;

    @ApiParam("父科室ID")
    private Integer parentDeptId;

    @ApiParam("科室地址")
    private String deptAddress;

    @ApiParam("备注")
    private String description;

    @ApiParam("医院数据id")
    private String hospitalDataId;

    @ApiParam("科室数据id")
    private String deptDataId;

    @ApiParam("父科室数据id")
    private String parentDeptIDataid;

    @ApiParam("操作类型")
    private String operationType;

    public static THospitalDept assemblyData(THospitalDeptDto tHospitalDeptDto){
        THospitalDept tHospitalDept = JsonUtil.convert(tHospitalDeptDto,THospitalDept.class);
        tHospitalDept.setCreateTime(new Date());
        return tHospitalDept;
    }
}
