package com.bben.infusion.service;

import com.bben.common.PageInfo;
import com.bben.infusion.model.infusion.THospital;

public interface THospitalService {

    THospital selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    THospital insertSelective(THospital record);

    THospital updateByPrimaryKey(THospital record);

    /**
     * 多条件分页查询
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<THospital> findByCondition(THospital record,int pageNum,int pageSize);


}
