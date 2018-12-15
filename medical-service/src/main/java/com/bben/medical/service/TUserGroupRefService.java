package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TUserGroupRef;
import com.bben.medical.vo.TUserGroupRefVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 11:15
 */
public interface TUserGroupRefService {

    /**
     * 查询所有用户组
     * @return
     */
    List<TUserGroupRefVo> findAll();

    /**
     * 根据主键查询用户组
     * @param refId
     * @return
     */
    TUserGroupRefVo selectByPrimaryKey(Integer refId);

    /**
     * 新增用户组信息
     * @param record
     * @return
     */
    TUserGroupRef insertSelective(TUserGroupRef record);

    /**
     * 更新用户组信息
     * @param record
     * @return
     */
    TUserGroupRef updateByPrimarykey(TUserGroupRef record);

    /**
     * 删除用户组信息
     * @param refId
     * @return
     */
    int deleteByPrimarykey(Integer refId);

    /**
     * 根据分页查询用户组信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TUserGroupRefVo> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询用户组信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TUserGroupRefVo> selectByCondition(TUserGroupRef record, int pageNum, int pageSize);
}
