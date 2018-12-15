package com.bben.infusion.service;

import com.bben.common.PageInfo;
import com.bben.infusion.model.infusion.TPatientEquipRef;


public interface TPatientEquipRefService {
    TPatientEquipRef selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    TPatientEquipRef insertSelective(TPatientEquipRef record);

    TPatientEquipRef updateByPrimaryKey(TPatientEquipRef record);

    /**
     * 多条件查询，找出符合条件的记录
     * @param record   用户信息
     * @param pageNum  页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<TPatientEquipRef> findByCondition(TPatientEquipRef record, int pageNum, int pageSize);
}
