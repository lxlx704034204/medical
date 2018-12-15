package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TUserGroupRef;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 14:28
 */
@Getter
@Setter
@NoArgsConstructor
public class TUserGroupRefDto {

    @ApiParam("用户id")
    private Integer userId;

    @ApiParam("用户组id")
    private Integer groupId;

    @ApiParam("备注")
    private String description;

    public static TUserGroupRef assemblyData(TUserGroupRefDto tUserGroupRefDto){
        return JsonUtil.convert(tUserGroupRefDto,TUserGroupRef.class);
    }
}
