package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.sqlMedical.Grade;

public interface GradeService {
    Grade selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    Grade insertSelective(Grade record);

    Grade updateByPrimaryKey(Grade record);

    /**
     * 多条件查询，找出符合条件的记录
     *
     * @param record   用户信息
     * @param pageNum  页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<Grade> findByCondition(Grade record, int pageNum, int pageSize);
}
