package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TGroupMapper;
import com.bben.medical.model.medical.TGroup;
import com.bben.medical.model.medical.TGroupExample;
import com.bben.medical.service.TGroupService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 15:21
 */
@Service(value = "TGroupService")
@CacheConfig(cacheNames = "TGroup")
public class TGroupServiceImpl implements TGroupService {

    @Autowired
    private TGroupMapper tGroupMapper;

    @Override
    public List<TGroup> findAllTGroup() {
        return tGroupMapper.selectByExample(null);
    }

    @Override
    public TGroup selectByPrimaryKey(Integer groupId) {
        if (U.isBlank(groupId)){
            return null;
        }
        return tGroupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public TGroup insertSelective(TGroup record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setCreateTime(new Date());
        int ok = tGroupMapper.insertSelective(record);
        if (0 == ok){
            return null;
        }
        return record;
    }

    @Override
    public TGroup updateByPrimaryKey(TGroup record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setUpdateTime(new Date());
        int ok = tGroupMapper.updateByPrimaryKeySelective(record);
        if (0 == ok){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimaryKey(Integer groupId) {
        return tGroupMapper.deleteByPrimaryKey(groupId);
    }

    @Override
    public PageInfo<TGroup> findByPage(TGroup record, int pageNum, int pageSize) {
        TGroupExample tGroupExample = new TGroupExample();
        TGroupExample.Criteria criteria = tGroupExample.createCriteria();
        if (U.isNotBlank(record.getParentId())){
            criteria.andParentIdEqualTo(record.getParentId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionLike(record.getDescription());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TGroup> tGroupList = tGroupMapper.selectByExample(tGroupExample);
        PageInfo<TGroup> tGroupPageInfo = new PageInfo<>(tGroupList);
        return tGroupPageInfo;
    }
}
