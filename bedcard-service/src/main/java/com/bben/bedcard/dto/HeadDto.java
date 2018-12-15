package com.bben.bedcard.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeadDto {

    @ApiParam("跳转Controller")
    private String controller;
}
