package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class THospitalizationExpensesDetailDto {

    @ApiParam("费用表关联id")
    private Integer expensesDayId;

    @ApiParam("费用名称")
    private String expensesName;

    @ApiParam("单位")
    private String unit;

    @ApiParam("单价")
    private Long unitPrice;

    @ApiParam("数量")
    private Integer number;

    @ApiParam("金额")
    private Long amountOfMoney;

    @ApiParam("备注")
    private String description;

    public static THospitalizationExpensesDetail assemblyData(THospitalizationExpensesDetailDto hospitalizationExpensesDetailDto){
        THospitalizationExpensesDetail tHospitalizationExpensesDetail = JsonUtil.convert(hospitalizationExpensesDetailDto,THospitalizationExpensesDetail.class);
        tHospitalizationExpensesDetail.setCreateTime(new Date());
        return tHospitalizationExpensesDetail;
    }
}
