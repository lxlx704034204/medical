package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TUserGroupRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 11:23
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TUserGroupRefVo {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户组id")
    private Integer groupId;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("组实体")
    private TGroupVo tGroupVo;

    public static TUserGroupRefVo assemblyData(TUserGroupRef tUserGroupRef){
        return JsonUtil.convert(tUserGroupRef,TUserGroupRefVo.class);
    }

    public static List<TUserGroupRefVo> assemblyDataList(List<TUserGroupRef> tUserGroupRefList){
        return JsonUtil.convertList(tUserGroupRefList,TUserGroupRefVo.class);
    }

    public static PageInfo<TUserGroupRefVo> assemblyDataListPageInfo(PageInfo<TUserGroupRef> tUserGroupRefPageInfo){
        List<TUserGroupRef> tUserGroupRefList = tUserGroupRefPageInfo.getList();
        PageInfo<TUserGroupRefVo> tUserGroupRefVoPageInfo = new PageInfo<>(assemblyDataList(tUserGroupRefList));
        return tUserGroupRefVoPageInfo;
    }
}
