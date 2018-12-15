package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TControlParam;

public interface TControlParamService {
    TControlParam selectByPrimaryKey(String paramCode);

    int deleteByPrimaryKey(String paramCode);

    TControlParam insertSelective(TControlParam record);

    TControlParam updateByPrimaryKey(TControlParam record);

    /**
     * 多条件查询，找出符合条件的记录
     * @param record   用户信息
     * @param pageNum  页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<TControlParam> findByCondition(TControlParam record, int pageNum, int pageSize);
}
