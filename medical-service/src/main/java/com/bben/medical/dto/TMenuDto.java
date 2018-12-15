package com.bben.medical.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lizhenwei
 */
@Setter
@Getter
@NoArgsConstructor
public class TMenuDto {

    @ApiParam("父菜单Id")
    private Integer parentId;

    @ApiParam("菜单类型1=1级菜单;2=2级菜单;3=3级菜单; ")
    private Byte type;

    @ApiParam("菜单路径")
    private String url;

    @ApiParam("菜单图标")
    private String icon;

    @ApiParam("菜单名称")
    private String name;

    @ApiParam("层次号码")
    private Integer levelNumber;

}
