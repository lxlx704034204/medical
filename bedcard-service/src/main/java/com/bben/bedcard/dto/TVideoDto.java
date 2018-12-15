package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TVideoDto {

    @ApiParam("视频类型")
    private Integer videoType;

    @ApiParam("视频链接")
    private String videoUrl;

    @ApiParam("图片链接")
    private String imageUrl;

    @ApiParam("图片大小")
    private Integer size;

    @ApiParam("热门")
    private Integer hot;

    @ApiParam("排序")
    private Integer sort;

    @ApiParam("视频备注")
    private String description;




    public static TVideo assemblyData(TVideoDto tVideoDto){
        TVideo tVideo = JsonUtil.convert(tVideoDto,TVideo.class);
        tVideo.setCreateTime(new Date());
        return tVideo;
    }
}
