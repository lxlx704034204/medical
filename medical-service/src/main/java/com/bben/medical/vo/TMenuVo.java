package com.bben.medical.vo;

import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(description= "返回响应数据")
public class TMenuVo {

    @ApiModelProperty("父菜单id")
    private Integer parentId;

    @ApiModelProperty("菜单类型1=1级菜单;2=2级菜单;3=3级菜单;")
    private Byte type;

    @ApiModelProperty("菜单路径")
    private String url;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("排序号码")
    private Integer sortNumber;

    public static TMenuVo assemblyData(TMenu tMenu){
        return JsonUtil.convert(tMenu,TMenuVo.class);
    }

}
