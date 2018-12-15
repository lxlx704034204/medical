package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TPosition;

import java.util.List;

public interface TPositionService {

    /**
     * 查询所有岗位信息
     * @return
     */
    List<TPosition> findAllTPosition();

    /**
     * 根据主键查询岗位信息
     * @param TPositionId   自增主键
     * @return
     */
    TPosition selectByPrimaryKey(Integer TPositionId);

    /**
     * 根据主键删除岗位信息
     * @param TPositionId   自增主键
     * @return
     */
    int deleteByPrimaryKey(Integer TPositionId);

    /**
     * 添加岗位信息
     * @param record    岗位表对象
     * @return
     */
    TPosition insertSelective(TPosition record);

    /**
     * 跟新岗位信息
     * @param record    岗位表对象
     * @return
     */
    TPosition updateByPrimaryKey(TPosition record);

    /**
     * 分页查询
     * @param pageNum   页号
     * @param pageSize  煤业显示记录数
     * @return
     */
    PageInfo<TPosition> findByPage(int pageNum, int pageSize);

    /**
     * 多条件查询，找出符合条件的记录
     * @param record   用户信息
     * @param pageNum  页号
     * @param pageSize 每页显示记录数
     * @return
     */
    PageInfo<TPosition> findByCondition(TPosition record, int pageNum, int pageSize);



}
