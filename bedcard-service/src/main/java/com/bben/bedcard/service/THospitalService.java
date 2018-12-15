package com.bben.bedcard.service;

import com.bben.bedcard.dto.THospitalDto;
import com.bben.bedcard.model.bedcard.THospital;
import com.bben.bedcard.vo.THospitalVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/13 14:36
 */
public interface THospitalService {

    /**
     *  查询所有医院
     */
    List<THospitalVo> findAllTHospital();

    /**
     * 根据医院Id查询医院信息
     * @param hospitalId
     * @return
     */
    THospitalVo selectByPrimaryKey(Integer hospitalId);

    /**
     * 添加医院信息
     * @param record
     * @return
     */
    THospital insertSelective(THospital record);

    /**
     * 更新医院信息
     * @param record
     * @return
     */
    THospital updateByPrimarykey(THospital record);

    /**
     * 删除医院信息
     * @param hospitalId
     * @return
     */
    int deleteByPrimarykey(Integer hospitalId);

    /**
     *
     * @param record
     * @return
     */
    List<THospitalVo> findByCondition(THospitalDto record);

}
