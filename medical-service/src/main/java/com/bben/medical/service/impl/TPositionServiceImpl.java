package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TPositionMapper;
import com.bben.medical.model.medical.TPosition;
import com.bben.medical.model.medical.TPositionExample;
import com.bben.medical.service.TPositionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 李振伟
 */
@Service(value = "TPositionService")
@CacheConfig(cacheNames = "TPosition")
public class TPositionServiceImpl implements TPositionService {

    @Autowired
    /**
     * 这里会报错，但不影响
     */
    private TPositionMapper tPositionMapper;

    @Override
    public List<TPosition> findAllTPosition() {
        return tPositionMapper.selectByExample(null);
    }

    @Override
    public TPosition selectByPrimaryKey(Integer TPositionId) {
        return tPositionMapper.selectByPrimaryKey(TPositionId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer TPositionId) {
        return tPositionMapper.deleteByPrimaryKey(TPositionId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TPosition insertSelective(TPosition record) {
        record.setCreateTime(new Date());
        int count = tPositionMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TPosition updateByPrimaryKey(TPosition record) {
        int count = tPositionMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public PageInfo<TPosition> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TPosition> tPositionList = tPositionMapper.selectByExample(null);
        PageInfo<TPosition> pageInfoTPosition = new PageInfo<>(tPositionList);
        return pageInfoTPosition;
    }

    @Override
    public PageInfo<TPosition> findByCondition(TPosition record, int pageNum, int pageSize) {

        TPositionExample tPositionExample = new TPositionExample();
        TPositionExample.Criteria criteria = tPositionExample.createCriteria();
        if (U.isNotBlank(record.getId())){
            criteria.andIdEqualTo(record.getId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TPosition> tPositionList = tPositionMapper.selectByExample(tPositionExample);
        PageInfo<TPosition> pageInfoTPosition = new PageInfo<>(tPositionList);
        return pageInfoTPosition;
    }
}
