package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 10:55
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TResourceVo {

    @ApiModelProperty("资源id")
    private Integer id;

    @ApiModelProperty("资源代码")
    private String code;

    @ApiModelProperty("资源类型")
    private String type;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("地址")
    private String url;

    @ApiModelProperty("方法")
    private String method;

    @ApiModelProperty("备注")
    private String description;

    public static TResourceVo assemblyData(TResource tResource){
        return JsonUtil.convert(tResource,TResourceVo.class);
    }

    public static List<TResourceVo> assemblyDataList(List<TResource> tResourceList){
        List<TResourceVo> tPositionVoList = JsonUtil.convertList(tResourceList,TResourceVo.class);
        return tPositionVoList;
    }

    public static PageInfo<TResourceVo> assemblyDataListPage(PageInfo<TResource> tResourcePageInfo){
        List<TResource> tResourceList = tResourcePageInfo.getList();
        PageInfo<TResourceVo> tResourceVoPageInfo = new PageInfo<>(assemblyDataList(tResourceList));
        return tResourceVoPageInfo;
    }

}
