package com.bben.infusion.service.impl;

import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.bben.infusion.mapper.infusion.TWardMapper;
import com.bben.infusion.model.infusion.TWard;
import com.bben.infusion.model.infusion.TWardExample;
import com.bben.infusion.service.TWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("WardService")
@CacheConfig(cacheNames = "TWard")
public class TWardServiceImpl implements TWardService {
    @Autowired
    private TWardMapper tWardMapper;

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public TWard selectByPrimaryKey(Integer id) {
        TWard tWard = tWardMapper.selectByPrimaryKey(id);
        return tWard;
    }

}
