package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.bedcard.vo.THospitalizationExpensesDayVo;

import java.util.List;

public interface THospitalizationExpensesDayService {

    /**
     * 查询所有信息
     * @return
     */
    List<THospitalizationExpensesDayVo> findAll();

    /**
     * 根据主键查询信息
     * @param hospitalizationExpensesDayId
     * @return
     */
    THospitalizationExpensesDayVo selectByPrimaryKey(Integer hospitalizationExpensesDayId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    THospitalizationExpensesDay insertSelective(THospitalizationExpensesDay record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    THospitalizationExpensesDay updateByPrimarykey(THospitalizationExpensesDay record);

    /**
     * 删除信息
     * @param hospitalizationExpensesDayId
     * @return
     */
    int deleteByPrimarykey(Integer hospitalizationExpensesDayId);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<THospitalizationExpensesDayVo> selectByCondition(THospitalizationExpensesDay record);
}
