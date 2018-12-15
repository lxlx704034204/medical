package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.TBed;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 16:18
 */
@Getter
@Setter
@NoArgsConstructor
public class TBedDto {

    @ApiParam("床头卡id")
    private Integer bedCardId;

    @ApiParam("病区id")
    private Integer sickroomId;

    @ApiParam("床位类型")
    private String bedType;

    @ApiParam("床位号")
    private String bedNum;

    @ApiParam("使用状态")
    private Integer useStatus;

    @ApiParam("备注")
    private String description;

    public static TBed assemblyData(TBedDto tBedDto){
        TBed tBed = JsonUtil.convert(tBedDto,TBed.class);
        tBed.setCreateTime(new Date());
        return tBed;
    }
}
