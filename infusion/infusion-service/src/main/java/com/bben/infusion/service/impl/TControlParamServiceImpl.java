package com.bben.infusion.service.impl;

import com.bben.infusion.mapper.infusion.TControlParamMapper;
import com.bben.infusion.model.infusion.TControlParam;
import com.bben.infusion.service.TControlParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@Service(value = "ControlParamService")
@CacheConfig(cacheNames = "TControlParam")
public class TControlParamServiceImpl implements TControlParamService {

    @Autowired
    private TControlParamMapper tControlParamMapper;

    @Override
    public TControlParam selectByPrimaryKey(String code) {
        return tControlParamMapper.selectByPrimaryKey(code);
    }
}
