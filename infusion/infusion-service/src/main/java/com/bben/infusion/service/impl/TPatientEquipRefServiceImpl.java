package com.bben.infusion.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.U;
import com.bben.infusion.mapper.infusion.TPatientEquipRefMapper;
import com.bben.infusion.model.infusion.TPatientEquipRef;
import com.bben.infusion.model.infusion.TPatientEquipRefExample;
import com.bben.infusion.service.TPatientEquipRefService;
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

@Service(value = "TPatientEquipRef")
@CacheConfig(cacheNames = "TPatientEquipRef")
public class TPatientEquipRefServiceImpl implements TPatientEquipRefService {
    @Autowired
    private TPatientEquipRefMapper tPatientEquipRefMapper;//这里会报错，但是并不会影响

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public TPatientEquipRef selectByPrimaryKey(Integer id) {
        return tPatientEquipRefMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public int deleteByPrimaryKey(Integer id) {
        return tPatientEquipRefMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CachePut(key = "#result.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TPatientEquipRef insertSelective(TPatientEquipRef record) {
        int count = tPatientEquipRefMapper.insertSelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    @Override
    @CachePut(key = "#record.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TPatientEquipRef updateByPrimaryKey(TPatientEquipRef record) {
        int count = tPatientEquipRefMapper.updateByPrimaryKeySelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    //多条件查询，找出符合条件的记录
    @Override
    public PageInfo<TPatientEquipRef> findByCondition(TPatientEquipRef record, int pageNum, int pageSize) {
        TPatientEquipRefExample TPatientEquipRefExample = new TPatientEquipRefExample();
        TPatientEquipRefExample.Criteria criteria = TPatientEquipRefExample.createCriteria();

        TPatientEquipRefExample.setOrderByClause(" equipment_sn");
        if (U.isNotBlank(record.getEquipmentSn())) {
            criteria.andEquipmentSnEqualTo(record.getEquipmentSn());
        }

        if (U.isNotBlank(record.getPatientId())) {
            criteria.andPatientIdEqualTo(record.getPatientId());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<TPatientEquipRef> listTPatientEquipRef = tPatientEquipRefMapper.selectByExample(TPatientEquipRefExample);
        PageInfo<TPatientEquipRef> pageInfoTPatientEquipRef = new PageInfo<>(listTPatientEquipRef);

        return pageInfoTPatientEquipRef;
    }
}
