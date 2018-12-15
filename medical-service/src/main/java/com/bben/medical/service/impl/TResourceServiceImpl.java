package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.CodeUtil;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TResourceMapper;
import com.bben.medical.model.medical.TResource;
import com.bben.medical.model.medical.TResourceExample;
import com.bben.medical.service.TResourceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 10:06
 */
@Service(value = "TResourceService")
@CacheConfig(cacheNames = "TResource")
public class TResourceServiceImpl implements TResourceService {

    @Autowired
    private TResourceMapper tResourceMapper;

    @Override
    public List<TResource> findAllTRsource() {
        return tResourceMapper.selectByExample(null);
    }

    @Override
    public TResource selectByPrimaryKey(Integer resourceId) {
        if (U.isBlank(resourceId)){
            return null;
        }
        return tResourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TResource insertSelective(TResource record) {
        record.setCode(CodeUtil.generatResourceCode());
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(new Date()));
        record.setCreateTime(new Date());
        if (U.isBlank(record)){
            return null;
        }
        int count = tResourceMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TResource updateByPrimaryKey(TResource record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tResourceMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer resourceId) {
        return tResourceMapper.deleteByPrimaryKey(resourceId);
    }

    @Override
    public PageInfo<TResource> findByPage(TResource record, int pageNum, int pageSize) {
        TResourceExample tResourceExample = new TResourceExample();
        TResourceExample.Criteria criteria = tResourceExample.createCriteria();
        if (U.isNotBlank(record.getId())){
            criteria.andIdEqualTo(record.getId());
        }
        if (U.isNotBlank(record.getCode())){
            criteria.andCodeEqualTo(record.getCode());
        }
        if (U.isNotBlank(record.getType())){
            criteria.andTypeEqualTo(record.getType());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }
        if (U.isNotBlank(record.getUrl())){
            criteria.andUrlEqualTo(record.getUrl());
        }
        if (U.isNotBlank(record.getMethod())){
            criteria.andMethodEqualTo(record.getMethod());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionEqualTo(record.getDescription());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TResource> tResourceList = tResourceMapper.selectByExample(tResourceExample);
        PageInfo<TResource> tResourcePageInfo = new PageInfo<>(tResourceList);
        return tResourcePageInfo;
    }
}
