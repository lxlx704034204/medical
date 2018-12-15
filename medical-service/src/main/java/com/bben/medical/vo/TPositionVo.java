package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TPosition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ApiModel(description= "返回响应数据")
public class TPositionVo {

    @ApiModelProperty("岗位id")
    private Integer id;

    @ApiModelProperty("岗位名称")
    private String name;

    @ApiModelProperty("备注")
    private String description;



    /**
     * 汇编岗位返回集合
     * @param tPositionList
     * @return
     */
    public static List<TPositionVo> assemblyDataList(List<TPosition> tPositionList){
        List<TPositionVo> tPositionVoList = JsonUtil.convertList(tPositionList,TPositionVo.class);
        return tPositionVoList;
    }

    /**
     * 汇编岗位返回
     * @param tPosition
     * @return
     */
    public static TPositionVo assemblyData(TPosition tPosition){
        TPositionVo tPositionVo = JsonUtil.convert(tPosition,TPositionVo.class);
        return tPositionVo;
    }

    /**
     * 分页信息汇编
     * @param tPositionPageInfo
     * @return
     */
    public static PageInfo<TPositionVo> assemblyDataListPage(PageInfo<TPosition> tPositionPageInfo){
        List<TPosition> tPositionList = tPositionPageInfo.getList();
        List<TPositionVo> tPositionVoList = assemblyDataList(tPositionList);
        PageInfo<TPositionVo> tPositionVoPageInfo = new PageInfo<>(tPositionVoList);
        return tPositionVoPageInfo;
    }

}

