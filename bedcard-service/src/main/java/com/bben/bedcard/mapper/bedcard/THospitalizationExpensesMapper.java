package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.THospitalizationExpenses;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalizationExpensesMapper {
    long countByExample(THospitalizationExpensesExample example);

    int deleteByExample(THospitalizationExpensesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THospitalizationExpenses record);

    int insertSelective(THospitalizationExpenses record);

    List<THospitalizationExpenses> selectByExample(THospitalizationExpensesExample example);

    THospitalizationExpenses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THospitalizationExpenses record, @Param("example") THospitalizationExpensesExample example);

    int updateByExample(@Param("record") THospitalizationExpenses record, @Param("example") THospitalizationExpensesExample example);

    int updateByPrimaryKeySelective(THospitalizationExpenses record);

    int updateByPrimaryKey(THospitalizationExpenses record);
}