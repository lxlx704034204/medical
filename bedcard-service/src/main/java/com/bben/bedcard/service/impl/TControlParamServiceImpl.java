package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TControlParamMapper;
import com.bben.bedcard.model.bedcard.TControlParam;
import com.bben.bedcard.model.bedcard.TControlParamExample;
import com.bben.bedcard.service.TControlParamService;
import com.bben.common.PageInfo;
import com.bben.common.util.U;
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

@Service(value = "TControlParamService")
@CacheConfig(cacheNames = "TControlParam")
public class TControlParamServiceImpl implements TControlParamService {

    @Autowired
    private TControlParamMapper tControlParamMapper;//这里会报错，但是并不会影响

    @Override
    @Cacheable(key = "#code", unless = "#result == null")
    public TControlParam selectByPrimaryKey(String code) {
        return tControlParamMapper.selectByPrimaryKey(code);
    }

    @Override
    @CacheEvict(key = "#code")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(String code) {
        return tControlParamMapper.deleteByPrimaryKey(code);
    }

    @Override
    @CachePut(key = "#result.code", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TControlParam insertSelective(TControlParam record) {
        int count = tControlParamMapper.insertSelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    @Override
    @CachePut(key = "#record.code", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TControlParam updateByPrimaryKey(TControlParam record) {
        int count = tControlParamMapper.updateByPrimaryKeySelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    //多条件查询，找出符合条件的记录
    @Override
    public PageInfo<TControlParam> findByCondition(TControlParam record, int pageNum, int pageSize) {
        TControlParamExample tControlParamExample = new TControlParamExample();
        TControlParamExample.Criteria criteria = tControlParamExample.createCriteria();

        tControlParamExample.setOrderByClause(" code");
        if (U.isNotBlank(record.getCode())) {
            criteria.andCodeEqualTo(record.getCode());
        }

        if (U.isNotBlank(record.getName())) {
            criteria.andNameEqualTo(record.getName());
        }

        if (U.isNotBlank(record.getType())) {
            criteria.andTypeEqualTo(record.getType());
        }

        if (U.isNotBlank(record.getValue())) {
            criteria.andValueEqualTo(record.getValue());
        }

        if (U.isNotBlank(record.getUnit())) {
            criteria.andUnitEqualTo(record.getUnit());
        }

        criteria.andStatusEqualTo((byte)1);

        PageHelper.startPage(pageNum, pageSize);
        List<TControlParam> listTControlParam = tControlParamMapper.selectByExample(tControlParamExample);
        PageInfo<TControlParam> pageInfoTControlParam = new PageInfo<>(listTControlParam);

        return pageInfoTControlParam;
    }
}
