package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TMenu;

import java.util.List;

/**
 * @author lizhenwei
 */
public interface TMenuService {

    /**
     * 查询全部菜单
     * @return
     */
    List<TMenu> findAllTMenu();

    /**
     * 根据Id查询菜单
     * @param TMenuId
     * @return
     */
    TMenu selectByPrimaryKey(Integer TMenuId);

    /**
     * 根据Id查询菜单
     * @param TMenuId
     * @return
     */
    int deleteByPrimaryKey(Integer TMenuId);

    /**
     * 添加菜单
     * @param record
     * @return
     */
    TMenu insertSelective(TMenu record);

    /**
     * 跟新菜单
     * @param record
     * @return
     */
    TMenu updateByPrimaryKey(TMenu record);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TMenu> findByPage(int pageNum, int pageSize);

    /**
     * 根据条件分页查询
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TMenu> findByCondition(TMenu record, int pageNum, int pageSize);


}
