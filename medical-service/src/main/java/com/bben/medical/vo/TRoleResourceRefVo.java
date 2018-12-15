package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TRoleResourceRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 15:07
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TRoleResourceRefVo {

    @ApiModelProperty("资源id")
    private Integer resourceId;

    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("资源对象")
    private TResourceVo tResourceVo;

    public static TRoleResourceRefVo assemblyData(TRoleResourceRef tRoleResourceRef){
        return JsonUtil.convert(tRoleResourceRef,TRoleResourceRefVo.class);
    }

    public static List<TRoleResourceRefVo> assemblyDataList(List<TRoleResourceRef> tRoleResourceRefList){
        return JsonUtil.convertList(tRoleResourceRefList,TRoleResourceRefVo.class);
    }

    public static PageInfo<TRoleResourceRefVo> assemblyDataListPageInfo(PageInfo<TRoleResourceRef> tRoleResourceRefPageInfo){
        List<TRoleResourceRef> tRoleResourceRefList = tRoleResourceRefPageInfo.getList();
        PageInfo<TRoleResourceRefVo> tRoleResourceRefVoPageInfo = new PageInfo<>(assemblyDataList(tRoleResourceRefList));
        return tRoleResourceRefVoPageInfo;
    }

}
