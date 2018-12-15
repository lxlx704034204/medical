package com.bben.infusion.service;

import com.bben.common.PageInfo;
import com.bben.infusion.model.infusion.TPatient;
import com.bben.infusion.model.param_model.TPatientParam;
import org.json.simple.JSONArray;

import java.util.List;


public interface TPatientService {
    TPatient selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    TPatient insertSelective(TPatient record);

    TPatient updateByPrimaryKey(TPatient record);

    /**
     * 多条件查询，找出符合条件的记录
     * @param record   用户信息
     * @param pageNum  页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<TPatient> findByCondition(TPatient record, int pageNum, int pageSize);

    PageInfo<TPatientParam> findPatientEquipByCondition(TPatient record, int pageNum, int pageSize);

    /**
     * 根据病区查找正在输液的病人信息
     * @param record
     * @return
     */
    List<TPatient> findRunPatientByCondition(TPatient record);

    /**
     * 封装病人信息 输液信息 设备信息
     * @param record
     * @return
     */
    JSONArray findPatientInfusionByCondition(boolean hasVoice,TPatient record);

}
