package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRoleMenuRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 17:31
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TRoleMenuRefVo {

    @ApiModelProperty("角色菜单id")
    private Integer id;

    @ApiModelProperty("菜单id")
    private Integer menuId;

    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("菜单返回数据")
    private TMenuVo tMenuVo;

    public static TRoleMenuRefVo assemblyData(TRoleMenuRef tRoleMenuRef){
        return JsonUtil.convert(tRoleMenuRef,TRoleMenuRefVo.class);
    }

    public static List<TRoleMenuRefVo> assemblyDataList(List<TRoleMenuRef> tRoleMenuRefList){
        return JsonUtil.convertList(tRoleMenuRefList,TRoleMenuRefVo.class);
    }

    public static PageInfo<TRoleMenuRefVo> assemblyDataListPageInfo(PageInfo<TRoleMenuRef> tRoleMenuRefPageInfo){
        List<TRoleMenuRef> tRoleMenuRefList = tRoleMenuRefPageInfo.getList();
        PageInfo<TRoleMenuRefVo> tRoleMenuRefVoPageInfo = new PageInfo<>(assemblyDataList(tRoleMenuRefList));
        return tRoleMenuRefVoPageInfo;
    }


}
