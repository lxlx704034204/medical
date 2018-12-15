package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TPatient;
import com.bben.bedcard.vo.TPatientVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 17:27
 */
public interface TPatientService {

    /**
     * 查询病人所有信息
     * @return
     */
    List<TPatientVo> findAll();

    /**
     * 根据主键查询病人信息
     * @param patientId
     * @return
     */
    TPatientVo selectByPrimaryKey(Integer patientId);

    /**
     * 添加病人信息
     * @param record
     * @return
     */
    TPatient insertSelective(TPatient record);

    /**
     * 更新病人信息
     * @param record
     * @return
     */
    TPatient updateByPrimarykey(TPatient record);

    /**
     * 删除病人信息
     * @param patientId
     * @return
     */
    int deleteByPrimarykey(Integer patientId);

    /**
     * 根据条件查询病人分页信息
     * @param record
     * @return
     */
    List<TPatientVo> selectByCondition(TPatient record);
    /**
     * 根据条件查询病人分页信息
     * @param record
     * @return
     */
    List<TPatient> selectListByCondition(TPatient record);


    /**
     * 根据条件删除信息
     * @param record
     * @return
     */
    int deleteByCondition(TPatient record);
}
