package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.THospitalizationExpenses;
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
@ApiModel(description = "住院费用返回实体")
public class THospitalizationExpensesVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("病人id")
    private Integer patientId;

    @ApiModelProperty("已缴费")
    private Long alreadyPaid;

    @ApiModelProperty("余额")
    private Long balance;

    @ApiModelProperty("支付宝二维码链接")
    private String alipayUrl;

    @ApiModelProperty("微信二维码链接")
    private String wechatUrl;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("日住院费用实体")
    private List<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoList;

    public static THospitalizationExpensesVo assemblyData(THospitalizationExpenses tHospitalizationExpenses){
        return JsonUtil.convert(tHospitalizationExpenses,THospitalizationExpensesVo.class);
    }

    public static List<THospitalizationExpensesVo> assemblyDataList(List<THospitalizationExpenses> tHospitalizationExpensesList){
        return JsonUtil.convertList(tHospitalizationExpensesList,THospitalizationExpensesVo.class);
    }

}
