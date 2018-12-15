package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TRoleResourceRef;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 14:17
 */
public interface TRoleResourceRefService {

    /**
     * 查询所有角色资源
     * @return
     */
    List<TRoleResourceRef> findAllTRoleResource();

    /**
     * 根据Id查询角色资源
     * @param refId
     * @return
     */
    TRoleResourceRef selectByPrimaryKey(Integer refId);

    /**
     * 添加角色资源
     * @param record
     * @return
     */
    TRoleResourceRef insertSelective(TRoleResourceRef record);

    /**
     * 更新角色资源
     * @param record
     * @return
     */
    TRoleResourceRef updateByPrimarykey(TRoleResourceRef record);

    /**
     * 删除角色资源
     * @param refId
     * @return
     */
    int deleteByPrimarykey(Integer refId);

    /**
     * 分页查询角色资源
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRoleResourceRef> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询角色资源
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRoleResourceRef> selectByCondition(TRoleResourceRef record, int pageNum, int pageSize);


}
