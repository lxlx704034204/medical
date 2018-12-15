package com.bben.medical.dto;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TResource;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 10:34
 */
@Getter
@Setter
@NoArgsConstructor
public class TResourceDto {

    @ApiParam("资源类型")
    private String type;

    @ApiParam("资源名称")
    private String name;

    @ApiParam("地址")
    private String url;

    @ApiParam("方法")
    private String method;

    @ApiParam("备注")
    private String description;

    public static TResource assemblyData(TResourceDto tResourceDto){
     return JsonUtil.convert(tResourceDto,TResource.class);
    }

}
