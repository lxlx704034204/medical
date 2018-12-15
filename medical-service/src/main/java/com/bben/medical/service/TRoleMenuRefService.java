package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TRoleMenuRef;
import com.bben.medical.vo.TRoleMenuRefVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 17:28
 */
public interface TRoleMenuRefService {

    /**
     * 查询所有角色菜单
     * @return
     */
    List<TRoleMenuRefVo> findAllTRoleMenuRef();

    /**
     * 根据主键查询菜单资源
     * @param refId
     * @return
     */
    TRoleMenuRefVo selectByPrimaryKey(Integer refId);

    /**
     * 新增菜单资源信息
     * @param record
     * @return
     */
    TRoleMenuRef insertSelective(TRoleMenuRef record);

    /**
     * 更新菜单资源信息
     * @param record
     * @return
     */
    TRoleMenuRef updateByPrimarykey(TRoleMenuRef record);

    /**
     * 删除菜单资源信息
     * @param refId
     * @return
     */
    int deleteByPrimarykey(Integer refId);

    /**
     * 根据分页查询菜单资源信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRoleMenuRefVo> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询菜单资源信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TRoleMenuRefVo> selectByCondition(TRoleMenuRef record,int pageNum,int pageSize);


}
