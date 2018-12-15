package com.bben.medical.service;

import com.bben.common.PageInfo;
import com.bben.medical.model.medical.TResource;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 9:57
 */
public interface TResourceService {

    /**
     * 查询所有资源
     * @return
     */
    List<TResource> findAllTRsource();

    /**
     * 根据主键查询资源信息
     * @param resourceId
     * @return
     */
    TResource selectByPrimaryKey(Integer resourceId);

    /**
     * 添加资源信息
     * @param record
     * @return
     */
    TResource insertSelective(TResource record);

    /**
     * 更新资源信息
     * @param record
     * @return
     */
    TResource updateByPrimaryKey(TResource record);

    /**
     * 根据Id删除资源信息
     * @param resourceId
     * @return
     */
    int deleteByPrimaryKey(Integer resourceId);

    /**
     * 分页查询资源信息
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TResource> findByPage(TResource record,int pageNum,int pageSize);


}
