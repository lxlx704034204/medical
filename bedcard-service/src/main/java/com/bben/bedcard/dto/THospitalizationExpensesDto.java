package com.bben.bedcard.dto;

import com.bben.bedcard.model.bedcard.THospitalizationExpenses;
import com.bben.common.util.JsonUtil;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class THospitalizationExpensesDto {

    @ApiParam("病人id")
    private Integer patientId;

    @ApiParam("已缴费")
    private Long alreadyPaid;

    @ApiParam("余额")
    private Long balance;

    @ApiParam("支付宝二维码链接")
    private String alipayUrl;

    @ApiParam("微信二维码链接")
    private String wechatUrl;

    @ApiParam("备注")
    private String description;

    public static THospitalizationExpenses assemblyData(THospitalizationExpensesDto tHospitalizationExpensesDto){
        THospitalizationExpenses tHospitalizationExpenses = JsonUtil.convert(tHospitalizationExpensesDto,THospitalizationExpenses.class);
        tHospitalizationExpenses.setCreateTime(new Date());
        return tHospitalizationExpenses;
    }
}
