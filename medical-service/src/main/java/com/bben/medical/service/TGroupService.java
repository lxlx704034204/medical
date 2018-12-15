package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TGroup;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 15:18
 */
public interface TGroupService {

    /**
     * 查询所有用户组
     * @return
     */
    List<TGroup> findAllTGroup();

    /**
     * 根据主键查询用户组
     * @param groupId
     * @return
     */
    TGroup selectByPrimaryKey(Integer groupId);

    /**
     * 添加用户组信息
     * @param record
     * @return
     */
    TGroup insertSelective(TGroup record);

    /**
     * 更新用户组信息
     * @param record
     * @return
     */
    TGroup updateByPrimaryKey(TGroup record);

    /**
     * 根据Id删除用户组信息
     * @param groupId
     * @return
     */
    int deleteByPrimaryKey(Integer groupId);

    /**
     * 分页查询用户组信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TGroup> findByPage(TGroup record, int pageNum, int pageSize);
}
