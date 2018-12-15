package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.common.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "日住院费用返回实体")
public class THospitalizationExpensesDayVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("住院费用id")
    private Integer expensesId;

    @ApiModelProperty("住院日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dateOfHospitalization;

    @ApiModelProperty("每日住院费用")
    private Long totalCostOfDay;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("收费详情实体")
    private List<THospitalizationExpensesDetailVo> tHospitalizationExpensesDetailVoList;

    public static THospitalizationExpensesDayVo assemblyData(THospitalizationExpensesDay tHospitalizationExpensesDay){
        return JsonUtil.convert(tHospitalizationExpensesDay,THospitalizationExpensesDayVo.class);
    }

    public static List<THospitalizationExpensesDayVo> assemblyDataList(List<THospitalizationExpensesDay> tHospitalizationExpensesDayList){
        return JsonUtil.convertList(tHospitalizationExpensesDayList,THospitalizationExpensesDayVo.class);
    }
}
