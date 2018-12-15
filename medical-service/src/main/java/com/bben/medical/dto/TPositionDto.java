package com.bben.medical.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TPositionDto {

    @ApiParam("岗位名称")
    private String name;

    @ApiParam("备注")
    private String description;

}
