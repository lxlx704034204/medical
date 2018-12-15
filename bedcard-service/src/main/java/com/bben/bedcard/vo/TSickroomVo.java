package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TSickroom;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/10 10:52
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel( description = "病房表返回响应数据")
public class TSickroomVo {

    @ApiModelProperty("病房id")
    private Integer id;

    @ApiModelProperty("房名称")
    private String sickroomName;

    @ApiModelProperty("病区id")
    private Integer wardId;

    @ApiModelProperty("床位数")
    private Integer bedCount;

    @ApiModelProperty("位置")
    private String position;

    @ApiModelProperty("负责医生")
    private String dutyDoctor;

    @ApiModelProperty("负责护士")
    private String dutyNurse;

    @ApiModelProperty("备注")
    private String description;

    public static TSickroomVo assemblyData(TSickroom tSickroom){
        return JsonUtil.convert(tSickroom,TSickroomVo.class);
    }

    public static List<TSickroomVo> assemblyDataList(List<TSickroom> tSickroomList){
        return JsonUtil.convertList(tSickroomList,TSickroomVo.class);
    }

}
