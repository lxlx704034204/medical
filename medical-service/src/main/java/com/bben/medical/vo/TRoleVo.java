package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/2 16:42
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "返回响应数据")
public class TRoleVo {

    @ApiModelProperty("角色id")
    private Integer id;

    @ApiModelProperty("角色编码")
    private String code;

    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 对象汇编
     * @param tRole
     * @return
     */
    public static TRoleVo assemblyData(TRole tRole){
        TRoleVo tRoleVo = JsonUtil.convert(tRole,TRoleVo.class);
        return tRoleVo;
    }

    /**
     * List对象汇编
     * @param tRoleList
     * @return
     */
    public static List<TRoleVo> assemblyDataList(List<TRole> tRoleList){
        List<TRoleVo> tRoleVoList = JsonUtil.convertList(tRoleList,TRoleVo.class);
        return tRoleVoList;
    }

    /**
     * 分页List对象汇编
     * @param tRolePageInfo
     * @return
     */
    public static PageInfo<TRoleVo> assemblyDataListPage(PageInfo<TRole> tRolePageInfo){
        List<TRole> tRoleList = tRolePageInfo.getList();
        PageInfo<TRoleVo> tRoleVoPageInfo = new PageInfo<>(assemblyDataList(tRoleList));
        return tRoleVoPageInfo;
    }

}
