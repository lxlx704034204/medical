package com.bben.medical.vo;

import com.bben.common.PageInfo;
import com.bben.common.util.JsonUtil;
import com.bben.medical.model.medical.TMenuResourceRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 9:34
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel("返回响应数据")
public class TMenuResourceRefVo {

    @ApiModelProperty("菜单id")
    private Integer meunId;

    @ApiModelProperty("资源id")
    private Integer resourceId;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("资源Model")
    private TResourceVo tResourceVo;

    public static TMenuResourceRefVo assemblyData(TMenuResourceRef tMenuResourceRef){
        return JsonUtil.convert(tMenuResourceRef,TMenuResourceRefVo.class);
    }

    public static List<TMenuResourceRefVo> assemblyDataList(List<TMenuResourceRef> tMenuResourceRefList){
        return JsonUtil.convertList(tMenuResourceRefList,TMenuResourceRefVo.class);
    }

    public static PageInfo<TMenuResourceRefVo> assemblyDataListPageInfo(PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo){
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefPageInfo.getList();
        PageInfo<TMenuResourceRefVo> tMenuResourceRefVoPageInfo = new PageInfo<>(assemblyDataList(tMenuResourceRefList));
        return tMenuResourceRefVoPageInfo;
    }

}
