package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TGroup;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 16:48
 */
@Getter
@Setter
@NoArgsConstructor
public class TGroupDto {

    @ApiParam("用户组父id")
    private Integer parentId;

    @ApiParam("用户组名称")
    private String name;

    @ApiParam("备注")
    private String description;

    public static TGroup assemblyData(TGroupDto tGroupDto){
        return JsonUtil.convert(tGroupDto,TGroup.class);
    }
}
