package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalizationExpensesDayMapper {
    long countByExample(THospitalizationExpensesDayExample example);

    int deleteByExample(THospitalizationExpensesDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THospitalizationExpensesDay record);

    int insertSelective(THospitalizationExpensesDay record);

    List<THospitalizationExpensesDay> selectByExample(THospitalizationExpensesDayExample example);

    THospitalizationExpensesDay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THospitalizationExpensesDay record, @Param("example") THospitalizationExpensesDayExample example);

    int updateByExample(@Param("record") THospitalizationExpensesDay record, @Param("example") THospitalizationExpensesDayExample example);

    int updateByPrimaryKeySelective(THospitalizationExpensesDay record);

    int updateByPrimaryKey(THospitalizationExpensesDay record);
}