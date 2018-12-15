package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class THospitalizationExpensesDayDto {

    @ApiParam("住院费用id")
    private Integer expensesId;

    @ApiParam("住院日期")
    private Date dateOfHospitalization;

    @ApiParam("每日住院费用")
    private Long totalCostOfDay;

    @ApiParam("备注")
    private String description;

    public static THospitalizationExpensesDay assemblyData(THospitalizationExpensesDayDto hospitalizationExpensesDayDto){
        THospitalizationExpensesDay tHospitalizationExpensesDay = JsonUtil.convert(hospitalizationExpensesDayDto,THospitalizationExpensesDay.class);
        tHospitalizationExpensesDay.setCreateTime(new Date());
        return tHospitalizationExpensesDay;
    }
}
