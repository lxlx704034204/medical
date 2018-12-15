package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TMenuResourceRef;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 9:09
 */
@Getter
@Setter
@NoArgsConstructor
public class TMenuResourceRefDto {

    @ApiParam("菜单id")
    private Integer meunId;

    @ApiParam("资源id")
    private Integer resourceId;

    @ApiParam("备注")
    private String description;

    public static TMenuResourceRef assemblyData(TMenuResourceRefDto tMenuResourceRefDto){
        return JsonUtil.convert(tMenuResourceRefDto,TMenuResourceRef.class);
    }
}
