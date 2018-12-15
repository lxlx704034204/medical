package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRoleMenuRef;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 17:31
 */
@Getter
@Setter
@NoArgsConstructor
public class TRoleMenuRefDto {

    @ApiParam("菜单id")
    private Integer menuId;

    @ApiParam("角色id")
    private Integer roleId;

    @ApiParam("备注")
    private String description;

    public static TRoleMenuRef assemblyData(TRoleMenuRefDto tRoleMenuRefDto){
        return JsonUtil.convert(tRoleMenuRefDto,TRoleMenuRef.class);
    }
}
