package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalizationExpensesDetailMapper {
    long countByExample(THospitalizationExpensesDetailExample example);

    int deleteByExample(THospitalizationExpensesDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THospitalizationExpensesDetail record);

    int insertSelective(THospitalizationExpensesDetail record);

    List<THospitalizationExpensesDetail> selectByExample(THospitalizationExpensesDetailExample example);

    THospitalizationExpensesDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THospitalizationExpensesDetail record, @Param("example") THospitalizationExpensesDetailExample example);

    int updateByExample(@Param("record") THospitalizationExpensesDetail record, @Param("example") THospitalizationExpensesDetailExample example);

    int updateByPrimaryKeySelective(THospitalizationExpensesDetail record);

    int updateByPrimaryKey(THospitalizationExpensesDetail record);
}