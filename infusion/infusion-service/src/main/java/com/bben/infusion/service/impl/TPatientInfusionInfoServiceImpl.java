package com.bben.infusion.service.impl;

import com.bben.infusion.mapper.infusion.TPatientInfusionInfoMapper;
import com.bben.infusion.model.infusion.TPatientInfusionInfo;
import com.bben.infusion.service.TPatientInfusionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "PatientInfusionInfoService")
public class TPatientInfusionInfoServiceImpl implements TPatientInfusionInfoService {

    @Autowired
    private TPatientInfusionInfoMapper tPatientInfusionInfoMapper;

    @Override
    public TPatientInfusionInfo selectByPrimaryKey(Integer id) {
        return tPatientInfusionInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertSelective(TPatientInfusionInfo record) {
        return tPatientInfusionInfoMapper.insertSelective(record);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(TPatientInfusionInfo record) {
        return tPatientInfusionInfoMapper.updateByPrimaryKey(record);
    }
}
