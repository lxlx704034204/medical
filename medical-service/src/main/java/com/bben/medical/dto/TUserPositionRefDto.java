package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TUserPositionRef;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 15:27
 */
@Getter
@Setter
@NoArgsConstructor
public class TUserPositionRefDto {

    @ApiParam("用户id")
    private Integer userId;

    @ApiParam("岗位id")
    private Integer positionId;

    @ApiParam("备注")
    private String  description;

    public static TUserPositionRef assemblyData(TUserPositionRefDto tUserPositionRefDto){
        return JsonUtil.convert(tUserPositionRefDto,TUserPositionRef.class);
    }
}
