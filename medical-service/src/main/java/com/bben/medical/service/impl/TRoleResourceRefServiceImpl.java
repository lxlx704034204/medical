package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TRoleResourceRefMapper;
import com.bben.medical.model.medical.TRoleResourceRef;
import com.bben.medical.model.medical.TRoleResourceRefExample;
import com.bben.medical.service.TRoleResourceRefService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 14:18
 */
@Service(value = "TRoleResourceRefService")
public class TRoleResourceRefServiceImpl implements TRoleResourceRefService {

    @Autowired
    private TRoleResourceRefMapper tRoleResourceRefMapper;

    @Override
    public List<TRoleResourceRef> findAllTRoleResource() {
        return tRoleResourceRefMapper.selectByExample(null);
    }

    @Override
    public TRoleResourceRef selectByPrimaryKey(Integer refId) {
        if (U.isBlank(refId)){
            return null;
        }
        return tRoleResourceRefMapper.selectByPrimaryKey(refId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TRoleResourceRef insertSelective(TRoleResourceRef record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tRoleResourceRefMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TRoleResourceRef updateByPrimarykey(TRoleResourceRef record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tRoleResourceRefMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer refId) {
        return tRoleResourceRefMapper.deleteByPrimaryKey(refId);
    }

    @Override
    public PageInfo<TRoleResourceRef> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TRoleResourceRef> tRoleResourceRefList = tRoleResourceRefMapper.selectByExample(null);
        PageInfo<TRoleResourceRef> tRoleResourceRefPageInfo = new PageInfo<>(tRoleResourceRefList);
        return tRoleResourceRefPageInfo;
    }

    @Override
    public PageInfo<TRoleResourceRef> selectByCondition(TRoleResourceRef record, int pageNum, int pageSize) {
        TRoleResourceRefExample tRoleResourceRefExample = new TRoleResourceRefExample();
        TRoleResourceRefExample.Criteria criteria = tRoleResourceRefExample.createCriteria();
        if (U.isNotBlank(record.getResourceId())){
            criteria.andResourceIdEqualTo(record.getResourceId());
        }
        if (U.isNotBlank(record.getRoleId())){
            criteria.andRoleIdEqualTo(record.getRoleId());
        }
        if (U.isNotBlank(record.getIsEnable())){
            criteria.andIsEnableEqualTo(record.getIsEnable());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        List<TRoleResourceRef> tRoleResourceRefList = tRoleResourceRefMapper.selectByExample(tRoleResourceRefExample);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TRoleResourceRef> tRoleResourceRefPageInfo = new PageInfo<>(tRoleResourceRefList);
        return tRoleResourceRefPageInfo;
    }
}
