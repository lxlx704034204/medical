package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TMenuResourceRef;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/6 16:45
 */
public interface TMenuResourceRefService {

    /**
     * 查询所有菜单资源
     * @return
     */
    List<TMenuResourceRef> findAllTRole();

    /**
     * 根据主键查询菜单资源
     * @param refId
     * @return
     */
    TMenuResourceRef selectByPrimaryKey(Integer refId);

    /**
     * 新增菜单资源信息
     * @param record
     * @return
     */
    TMenuResourceRef insertSelective(TMenuResourceRef record);

    /**
     * 更新菜单资源信息
     * @param record
     * @return
     */
    TMenuResourceRef updateByPrimarykey(TMenuResourceRef record);

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
    PageInfo<TMenuResourceRef> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询菜单资源信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TMenuResourceRef> selectByCondition(TMenuResourceRef record,int pageNum,int pageSize);

}
