package com.bben.infusion.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.infusion.mapper.infusion.THospitalMapper;
import com.bben.infusion.model.infusion.THospital;
import com.bben.infusion.model.infusion.THospitalExample;
import com.bben.infusion.service.THospitalService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "HospitalService")
@CacheConfig(cacheNames = "THospital")
public class THospitalServiceImpl implements THospitalService {

    @Autowired
    private THospitalMapper tHospitalMapper;

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public THospital selectByPrimaryKey(Integer id) {
        return tHospitalMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public int deleteByPrimaryKey(Integer id) {
        return tHospitalMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CachePut(key = "#result.id",unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public THospital insertSelective(THospital record) {
        int count = tHospitalMapper.insertSelective(record);
        if (count == 0) return null;
        return record;
    }

    @Override
    @CachePut(key = "#record.id",unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public THospital updateByPrimaryKey(THospital record) {
        int count = tHospitalMapper.updateByPrimaryKey(record);
        if (count == 0) return null;
        return record;
    }

    @Override
    public PageInfo<THospital> findByCondition(THospital record, int pageNum, int pageSize) {
        THospitalExample tHospitalExample = new THospitalExample();
        THospitalExample.Criteria criteria = tHospitalExample.createCriteria();

        tHospitalExample.setOrderByClause("level");
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }

        if (U.isNotBlank(record.getAddress())){
            criteria.andAddressEqualTo(record.getAddress());
        }

        if (U.isNotBlank(record.getAreaName())){
            criteria.andAreaNameEqualTo(record.getAreaName());
        }
        criteria.andStatusEqualTo((byte)1);

        PageHelper.startPage(pageNum,pageSize);
        List<THospital> tHospitalList = tHospitalMapper.selectByExample(tHospitalExample);
        PageInfo<THospital> tHospitalPageInfo = new PageInfo<>(tHospitalList);
        return tHospitalPageInfo;
    }
}
