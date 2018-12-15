package com.bben.infusion.service.impl;

import com.bben.infusion.mapper.infusion.TGatherDataMapper;
import com.bben.infusion.model.infusion.TGatherData;
import com.bben.infusion.service.TGatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "GatherDataService")
@CacheConfig(cacheNames = "TGatherData")
public class TGatherDataServiceImpl implements TGatherDataService {
    @Autowired
    private TGatherDataMapper tGatherDataMapper;

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public TGatherData selectByPrimaryKey(Integer id) {
        return tGatherDataMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(TGatherData record) {
        return tGatherDataMapper.insert(record);
    }

    @Override
    @CachePut(key = "#result.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertSelective(TGatherData record) {
        return tGatherDataMapper.insertSelective(record);
    }

    @Override
    @CachePut(key = "#record.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(TGatherData record) {
        return tGatherDataMapper.updateByPrimaryKey(record);
    }
}
