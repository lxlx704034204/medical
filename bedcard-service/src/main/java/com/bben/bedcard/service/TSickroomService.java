package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TSickroom;
import com.bben.bedcard.vo.TSickroomVo;

import java.util.List;

public interface TSickroomService {

    /**
     * 查询所有病区
     * @return
     */
    List<TSickroomVo> findAll();

    /**
     * 根据病区Id查询角色信息
     * @param sickroomId
     * @return
     */
    TSickroomVo selectByPrimaryKey(Integer sickroomId);

    /**
     * 添加病区信息
     * @param record
     * @return
     */
    TSickroom insertSelective(TSickroom record);

    /**
     * 更新病区信息
     * @param record
     * @return
     */
    TSickroom updateByPrimarykey(TSickroom record);

    /**
     * 删除病区信息
     * @param sickroomId
     * @return
     */
    int deleteByPrimarykey(Integer sickroomId);


    /**
     * 根据条件查询病区
     * @param record
     * @return
     */
    List<TSickroomVo> selectByCondition(TSickroom record);

    /**
     * 删除病区信息
     * @param record
     * @return
     */
    int deleteByRecord(TSickroom record);
}
