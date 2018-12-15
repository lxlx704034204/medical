package com.bben.bedcard.vo;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
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
@ApiModel(description = "收费详情返回实体")
public class THospitalizationExpensesDetailVo {

    @ApiModelProperty("自增主键")
    private Integer id;

    @ApiModelProperty("费用表关联id")
    private Integer expensesDayId;

    @ApiModelProperty("费用名称")
    private String expensesName;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("单价")
    private Long unitPrice;

    @ApiModelProperty("数量")
    private Integer number;

    @ApiModelProperty("金额")
    private Long amountOfMoney;

    @ApiModelProperty("备注")
    private String description;

    public static THospitalizationExpensesDetailVo assemblyData(THospitalizationExpensesDetail tHospitalizationExpensesDetail){
        return JsonUtil.convert(tHospitalizationExpensesDetail,THospitalizationExpensesDetailVo.class);
    }

    public static List<THospitalizationExpensesDetailVo> assemblyDataList(List<THospitalizationExpensesDetail> tHospitalizationExpensesDetailList){
        return JsonUtil.convertList(tHospitalizationExpensesDetailList,THospitalizationExpensesDetailVo.class);
    }
}
