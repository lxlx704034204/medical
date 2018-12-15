package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TRole;

import java.util.List;

/**
 * @author lizhenwei
 */
public interface TRoleService {

    /**
     *  查询所有角色
     */
    List<TRole> findAllTRole();

    /**
     * 根据角色Id查询角色信息
     * @param roleId
     * @return
     */
    TRole selectByPrimaryKey(Integer roleId);

    /**
     * 添加角色信息
     * @param record
     * @return
     */
    TRole insertSelective(TRole record);

    /**
     * 更新角色信息
     * @param record
     * @return
     */
    TRole updateByPrimarykey(TRole record);

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    int deleteByPrimarykey(Integer roleId);

    /**
     * 根据分页查询角色信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRole> selectByPage(int pageNum,int pageSize);

    /**
     * 根据条件查询分页信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRole> selectByCondition(TRole record,int pageNum,int pageSize);


}
