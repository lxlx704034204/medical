package com.bben.bedcard.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TControlParamDto {
    @ApiParam("参数代码")
    private String code;

    @ApiParam("参数名称")
    private String name;

    @ApiParam("参数类型")
    private String type;

    @ApiParam("参数值")
    private String value;

    @ApiParam("单位")
    private String unit;
}
