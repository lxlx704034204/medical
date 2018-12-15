package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.bedcard.vo.TDrugsDoseVo;

import java.util.List;

public interface TDrugsDoseService {
    
    /**
     * 查询所有信息
     * @return
     */
    List<TDrugsDoseVo> findAll();

    /**
     * 根据主键查询信息
     * @param medicationRecordId
     * @return
     */
    TDrugsDoseVo selectByPrimaryKey(Integer medicationRecordId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    TDrugsDose insertSelective(TDrugsDose record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    TDrugsDose updateByPrimarykey(TDrugsDose record);

    /**
     * 删除信息
     * @param medicationRecordId
     * @return
     */
    int deleteByPrimarykey(Integer medicationRecordId);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<TDrugsDoseVo> selectByCondition(TDrugsDose record);
}
