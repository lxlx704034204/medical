package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "视频返回响应数据")
public class TVideoVo {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("视频类型")
    private Integer videoType;

    @ApiModelProperty("视频地址")
    private String videoUrl;

    @ApiModelProperty("图片地址")
    private String imageUrl;

    @ApiModelProperty("视频大小M")
    private Integer size;

    @ApiModelProperty("热门")
    private Integer hot;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("备注")
    private String description;

    public static TVideoVo assemblyData(TVideo tVideo){
        return JsonUtil.convert(tVideo,TVideoVo.class);
    }

    public static List<TVideoVo> assemblyDataList(List<TVideo> videoList){
        return JsonUtil.convertList(videoList,TVideoVo.class);
    }

}
