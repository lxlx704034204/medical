package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRole;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/2 17:10
 */
@Getter
@Setter
@NoArgsConstructor
public class TRoleDto {

    @ApiParam("角色名称")
    private String name;

    @ApiParam("备注")
    private String description;

    public static TRole assemblyData(TRoleDto tRoleDto){
        return JsonUtil.convert(tRoleDto,TRole.class);
    }

}
