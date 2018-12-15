package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TBed;
import com.bben.bedcard.vo.TBedVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/10 9:57
 */
public interface TBedService {

    /**
     * 查询所有床位
     * @return
     */
    List<TBedVo> findAll();

    /**
     * 根据主键查询床位
     * @param bedId
     * @return
     */
    TBedVo selectByPrimaryKey(Integer bedId);

    /**
     * 新增床位信息
     * @param record
     * @return
     */
    TBed insertSelective(TBed record);

    /**
     * 更新床位信息
     * @param record
     * @return
     */
    TBed updateByPrimarykey(TBed record);

    /**
     * 删除床头卡信息
     * @param bedId
     * @return
     */
    int deleteByPrimarykey(Integer bedId);

    /**
     *  根据讲条件查询床头卡信息
     * @param record
     * @return
     */
    List<TBedVo> selectByCondition(TBed record);

}
