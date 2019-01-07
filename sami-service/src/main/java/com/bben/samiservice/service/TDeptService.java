package com.bben.samiservice.service;

import com.bben.samiservice.model.samiservice.TDept;

import java.util.List;

/**
 * 科室接口
 */
public interface TDeptService {

    /**
     * 操作科室数据
     * @param record
     * @return
     */
    TDept operationDept(TDept record);

    List<TDept> selectAll();

    /**
     * 根据科室编号查询科室信息
     * @return
     */
    TDept selectByCode(String code);

}
