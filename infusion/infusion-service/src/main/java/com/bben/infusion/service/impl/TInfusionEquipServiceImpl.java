package com.bben.infusion.service.impl;

import com.bben.infusion.mapper.infusion.TInfusionEquipMapper;
import com.bben.infusion.model.infusion.TInfusionEquip;
import com.bben.infusion.service.TInfusionEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "InfusionEquipService")
public class TInfusionEquipServiceImpl implements TInfusionEquipService {

    @Autowired
    private TInfusionEquipMapper tInfusionEquipMapper;

    @Override
    public TInfusionEquip selectByPrimaryKey(String equipmentSn) {
        return tInfusionEquipMapper.selectByPrimaryKey(equipmentSn);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertSelective(TInfusionEquip record) {
        return tInfusionEquipMapper.insertSelective(record);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(TInfusionEquip record) {
        int count = tInfusionEquipMapper.updateByPrimaryKey(record);
        return count;
    }

}
