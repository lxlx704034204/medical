package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.bedcard.vo.THospitalizationExpensesDetailVo;

import java.util.List;

public interface THospitalizationExpensesDetailService {

    /**
     * 查询所有信息
     * @return
     */
    List<THospitalizationExpensesDetailVo> findAll();

    /**
     * 根据主键查询信息
     * @param hospitalizationExpensesDetailId
     * @return
     */
    THospitalizationExpensesDetailVo selectByPrimaryKey(Integer hospitalizationExpensesDetailId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    THospitalizationExpensesDetail insertSelective(THospitalizationExpensesDetail record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    THospitalizationExpensesDetail updateByPrimarykey(THospitalizationExpensesDetail record);

    /**
     * 删除信息
     * @param hospitalizationExpensesDetailId
     * @return
     */
    int deleteByPrimarykey(Integer hospitalizationExpensesDetailId);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<THospitalizationExpensesDetailVo> selectByCondition(THospitalizationExpensesDetail record);
}
