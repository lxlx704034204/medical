package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 11:29
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "医生简要信息返回响应数据")
public class TDoctorBrieflyVo {

    @ApiModelProperty("医生ID")
    private Integer id;

    @ApiModelProperty("医生名称")
    private String doctorName;

    @ApiModelProperty("性别（0-男、1-女、2-未知）")
    private Integer sex;

    public static TDoctorBrieflyVo assemblyData(TDoctor tDoctor){
        return JsonUtil.convert(tDoctor,TDoctorBrieflyVo.class);
    }

    public static List<TDoctorBrieflyVo> assemblyDataList(List<TDoctor> tDoctorList){
        return JsonUtil.convertList(tDoctorList,TDoctorBrieflyVo.class);
    }
}
