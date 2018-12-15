package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.CodeUtil;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TRoleMapper;
import com.bben.medical.model.medical.TRole;
import com.bben.medical.model.medical.TRoleExample;
import com.bben.medical.service.TRoleService;
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
 * @author lizhenwei
 */
@Service(value = "TRoleService")
@CacheConfig(cacheNames = "TRole")
public class TRoleServiceImpl implements TRoleService {

    @Autowired
    /**
     * 这里会报错，但不影响
     */
    private TRoleMapper tRoleMapper;

    @Override
    public List<TRole> findAllTRole() {
        return tRoleMapper.selectByExample(null);
    }

    @Override
    public TRole selectByPrimaryKey(Integer roleId) {
        return tRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TRole insertSelective(TRole record) {
        record.setCode(CodeUtil.generatRoleCode());
        record.setCreateTime(new Date());
        int count = tRoleMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TRole updateByPrimarykey(TRole record) {
        int count = tRoleMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimarykey(Integer roleId) {
        return tRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public PageInfo<TRole> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TRole> tRoleList = tRoleMapper.selectByExample(null);
        PageInfo<TRole> tRolePageInfo = new PageInfo<>(tRoleList);
        return tRolePageInfo;
    }

    @Override
    public PageInfo<TRole> selectByCondition(TRole record, int pageNum, int pageSize) {
        TRoleExample tRoleExample = new TRoleExample();
        TRoleExample.Criteria criteria = tRoleExample.createCriteria();
        if (U.isNotBlank(record.getCode())){
            criteria.andCodeEqualTo(record.getCode());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andCodeEqualTo(record.getName());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TRole> tRoleList = tRoleMapper.selectByExample(tRoleExample);
        PageInfo<TRole> tRolePageInfo = new PageInfo<>(tRoleList);
        return tRolePageInfo;
    }
}
