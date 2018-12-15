package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 17:03
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TGroupVo {

    @ApiModelProperty("组id")
    private Integer id;

    @ApiModelProperty("用户组父id")
    private Integer parentId;

    @ApiModelProperty("用户组名称")
    private String name;

    @ApiModelProperty("备注")
    private String description;

    public static TGroupVo assemblyData(TGroup tGroup){
        return JsonUtil.convert(tGroup,TGroupVo.class);
    }

    public static List<TGroupVo> assemblyDataList(List<TGroup> tGroupList){
        List<TGroupVo> tGroupVoList = JsonUtil.convertList(tGroupList,TGroupVo.class);
        return tGroupVoList;
    }

    public static PageInfo<TGroupVo> assemblyDataListPage(PageInfo<TGroup> tGroupPageInfo){
        List<TGroup> tGroupList = tGroupPageInfo.getList();
        PageInfo<TGroupVo> tGroupVoPageInfo = new PageInfo<>(assemblyDataList(tGroupList));
        return tGroupVoPageInfo;
    }

}
