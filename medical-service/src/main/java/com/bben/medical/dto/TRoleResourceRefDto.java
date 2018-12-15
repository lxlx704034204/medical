package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRoleResourceRef;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 15:02
 */
@Getter
@Setter
@NoArgsConstructor
public class TRoleResourceRefDto {

    @ApiParam("资源id")
    private Integer resourceId;

    @ApiParam("角色id")
    private Integer roleId;

    @ApiParam("备注")
    private String description;

    public static TRoleResourceRef assemblyData(TRoleResourceRefDto tRoleResourceRefDto){
        return JsonUtil.convert(tRoleResourceRefDto,TRoleResourceRef.class);
    }

}
