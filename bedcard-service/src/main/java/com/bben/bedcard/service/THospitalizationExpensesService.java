package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.THospitalizationExpenses;
import com.bben.bedcard.vo.THospitalizationExpensesVo;

import java.util.List;

public interface THospitalizationExpensesService {

    /**
     * 查询所有信息
     * @return
     */
    List<THospitalizationExpensesVo> findAll();

    /**
     * 根据主键查询信息
     * @param hospitalizationExpensesId
     * @return
     */
    THospitalizationExpensesVo selectByPrimaryKey(Integer hospitalizationExpensesId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    THospitalizationExpenses insertSelective(THospitalizationExpenses record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    THospitalizationExpenses updateByPrimarykey(THospitalizationExpenses record);

    /**
     * 删除信息
     * @param hospitalizationExpensesId
     * @return
     */
    int deleteByPrimarykey(Integer hospitalizationExpensesId);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<THospitalizationExpensesVo> selectByCondition(THospitalizationExpenses record);

    /**
     * 根据主键查询收费信息及详情
     * @param hospitalizationExpensesId
     * @return
     */
    THospitalizationExpensesVo selectByPrimaryKeyAndDetail(Integer hospitalizationExpensesId);


    /**
     * 根据条件查询分页收费信息及详情
     * @param record
     * @return
     */
    List<THospitalizationExpensesVo> selectByConditionAndDetail(THospitalizationExpenses record);
}
