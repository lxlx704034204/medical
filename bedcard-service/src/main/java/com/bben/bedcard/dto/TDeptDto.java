package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TDept;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 14:23
 */
@Getter
@Setter
@NoArgsConstructor
public class TDeptDto {

    @ApiParam("消息Id")
    private String messageId;

    @ApiParam("数据Id")
    private String dataId;

    @ApiParam("科室名称")
    private String name;

    @ApiParam("简介")
    private String intro;

    @ApiParam("备注")
    private String description;

    @ApiParam("操作类型")
    private String operationType;

    public static TDept assemblyData(TDeptDto tDeptDto){
        TDept tDept = JsonUtil.convert(tDeptDto,TDept.class);
        tDept.setCreateTime(new Date());
        return tDept;
    }
}
