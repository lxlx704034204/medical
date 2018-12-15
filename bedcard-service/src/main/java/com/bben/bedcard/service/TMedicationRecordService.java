package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TMedicationRecord;
import com.bben.bedcard.vo.TMedicationRecordVo;

import java.util.List;

public interface TMedicationRecordService {

    /**
     * 查询所有信息
     * @return
     */
    List<TMedicationRecordVo> findAll();

    /**
     * 根据主键查询信息
     * @param medicationRecordId
     * @return
     */
    TMedicationRecordVo selectByPrimaryKey(Integer medicationRecordId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    TMedicationRecord insertSelective(TMedicationRecord record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    TMedicationRecord updateByPrimarykey(TMedicationRecord record);

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
    List<TMedicationRecordVo> selectByCondition(TMedicationRecord record);
}
