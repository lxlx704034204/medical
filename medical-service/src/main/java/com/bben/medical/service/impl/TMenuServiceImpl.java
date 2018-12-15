package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TMenuMapper;
import com.bben.medical.model.medical.TMenu;
import com.bben.medical.model.medical.TMenuExample;
import com.bben.medical.service.TMenuService;
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

@Service(value = "TMenuService")
@CacheConfig(cacheNames = "TMenu")
public class TMenuServiceImpl implements TMenuService {

    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public List<TMenu> findAllTMenu() {
        TMenuExample tMenuExample = new TMenuExample();
        return tMenuMapper.selectByExample(tMenuExample);
    }

    @Override
    public TMenu selectByPrimaryKey(Integer TMenuId) {
        return tMenuMapper.selectByPrimaryKey(TMenuId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer TMenuId) {
        return tMenuMapper.deleteByPrimaryKey(TMenuId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TMenu insertSelective(TMenu record) {
        TMenuExample tMenuExample = new TMenuExample();
        TMenuExample.Criteria criteria = tMenuExample.createCriteria();
        if (U.isNotBlank(record.getParentId()) || 0 == record.getParentId()){
        long parentCount = tMenuMapper.selectCountParentMenu();
        record.setSortNumber((int)parentCount+1);
        }else {
            int sonMenuCount = 0;
            criteria.andParentIdEqualTo(record.getParentId());
            criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
            List<TMenu> tMenuList = tMenuMapper.selectByExample(tMenuExample);
            sonMenuCount = A.isEmpty(tMenuList) ? 0 : tMenuList.size();
            record.setSortNumber(sonMenuCount+1);
        }
        record.setCreateTime(new Date());
        int count = tMenuMapper.insertSelective(record);
        if (0 == count){
            throw new RuntimeException("添加菜单失败");
        }
        record.setParentId(record.getId());
        int updateCount = tMenuMapper.updateByPrimaryKeySelective(record);
        if (0 == updateCount){
            throw new RuntimeException("更新父菜单Id失败");
        }
         return record;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public TMenu updateByPrimaryKey(TMenu record) {
        int count = tMenuMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public PageInfo<TMenu> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TMenu> tMenuList = tMenuMapper.selectByExample(null);
        PageInfo<TMenu> pageInfoTMenu = new PageInfo<>(tMenuList);
        return pageInfoTMenu;
    }

    @Override
    public PageInfo<TMenu> findByCondition(TMenu record, int pageNum, int pageSize) {
        TMenuExample tMenuExample = new TMenuExample();
        TMenuExample.Criteria criteria = tMenuExample.createCriteria();
        tMenuExample.setOrderByClause("sort_number ASC");
        if (U.isNotBlank(record.getParentId())){
            criteria.andParentIdEqualTo(record.getParentId());
        }
        if (U.isNotBlank(record.getType())){
            criteria.andTypeEqualTo(record.getType());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }
        if (U.isNotBlank(record.getIsVisible())){
            criteria.andIsVisibleEqualTo(record.getIsVisible());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TMenu> tMenuList = tMenuMapper.selectByExample(tMenuExample);
        PageInfo<TMenu> tMenuPageInfo = new PageInfo<>(tMenuList);

        return tMenuPageInfo;
    }
}
