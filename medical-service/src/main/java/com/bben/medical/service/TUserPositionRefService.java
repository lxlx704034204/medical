package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TUserPositionRef;
import com.bben.medical.vo.TUserPositionRefVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 15:15
 */
public interface TUserPositionRefService {

    /**
     * 查询所有用户组
     * @return
     */
    List<TUserPositionRefVo> findAll();

    /**
     * 根据主键查询用户组
     * @param refId
     * @return
     */
    TUserPositionRefVo selectByPrimaryKey(Integer refId);

    /**
     * 新增用户组信息
     * @param record
     * @return
     */
    TUserPositionRef insertSelective(TUserPositionRef record);

    /**
     * 更新用户组信息
     * @param record
     * @return
     */
    TUserPositionRef updateByPrimarykey(TUserPositionRef record);

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
    PageInfo<TUserPositionRefVo> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询用户组信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TUserPositionRefVo> selectByCondition(TUserPositionRef record, int pageNum, int pageSize);

}
