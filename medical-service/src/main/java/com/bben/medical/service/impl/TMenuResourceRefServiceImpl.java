package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TMenuResourceRefMapper;
import com.bben.medical.mapper.medical.TResourceMapper;
import com.bben.medical.model.medical.TMenuResourceRef;
import com.bben.medical.model.medical.TMenuResourceRefExample;
import com.bben.medical.service.TMenuResourceRefService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/6 17:11
 */
@Service(value = "TMenuResourceRefService")
public class TMenuResourceRefServiceImpl implements TMenuResourceRefService {

    @Autowired
    private TMenuResourceRefMapper tMenuResourceRefMapper;

    @Autowired
    private TResourceMapper tResourceMapper;


    @Override
    public List<TMenuResourceRef> findAllTRole() {
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefMapper.selectByExample(null);
        return tMenuResourceRefList;
    }

    @Override
    public TMenuResourceRef selectByPrimaryKey(Integer refId) {
        if (U.isBlank(refId)){
            return null;
        }
        TMenuResourceRef tMenuResourceRef = tMenuResourceRefMapper.selectByPrimaryKey(refId);
        return tMenuResourceRef;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TMenuResourceRef insertSelective(TMenuResourceRef record) {
        record.setCreateTime(new Date());
        int count = tMenuResourceRefMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TMenuResourceRef updateByPrimarykey(TMenuResourceRef record) {
        record.setUpdateTime(new Date());
        int count = tMenuResourceRefMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimarykey(Integer refId) {
        return tMenuResourceRefMapper.deleteByPrimaryKey(refId);
    }

    @Override
    public PageInfo<TMenuResourceRef> selectByPage(int pageNum, int pageSize) {
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefMapper.selectByExample(null);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo = new PageInfo<>(tMenuResourceRefList);
        return tMenuResourceRefPageInfo;
    }

    @Override
    public PageInfo<TMenuResourceRef> selectByCondition(TMenuResourceRef record, int pageNum, int pageSize) {
        TMenuResourceRefExample tMenuResourceRefExample = new TMenuResourceRefExample();
        TMenuResourceRefExample.Criteria criteria = tMenuResourceRefExample.createCriteria();
        if (U.isNotBlank(record.getMeunId())){
            criteria.andMeunIdEqualTo(record.getMeunId());
        }
        if (U.isNotBlank(record.getResourceId())){
            criteria.andResourceIdEqualTo(record.getResourceId());
        }
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefMapper.selectByExample(tMenuResourceRefExample);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo = new PageInfo<>(tMenuResourceRefList);
        return tMenuResourceRefPageInfo;
    }
}
