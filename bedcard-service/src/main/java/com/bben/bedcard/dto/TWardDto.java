package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TWard;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TWardDto {

    @ApiParam("消息id")
    private String messageId;

    @ApiParam("数据id")
    private String dataId;

    @ApiParam("病区名称")
    private String name;

    @ApiParam("位置")
    private String position;

    @ApiParam("负责人")
    private String dutyBy;

    @ApiParam("HISID")
    private String hisId;

    @ApiParam("备注")
    private String description;

    @ApiParam("操作类型")
    private String operationType;

    public static TWard assemblyData(TWardDto tWardDto){
        TWard tWard = JsonUtil.convert(tWardDto,TWard.class);
        tWard.setCreateTime(new Date());
        return tWard;
    }

}
