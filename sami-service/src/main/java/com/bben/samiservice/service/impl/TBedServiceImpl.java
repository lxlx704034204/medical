package com.bben.samiservice.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TBedMapper;
import com.bben.samiservice.model.samiservice.TBed;
import com.bben.samiservice.model.samiservice.TBedExample;
import com.bben.samiservice.service.TBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TBedService")
public class TBedServiceImpl implements TBedService {

    @Autowired
    private TBedMapper tBedMapper;
    @Override
    public List<TBed> selectByCode(String code) {
        if (U.isBlank(code)){
            return null;
        }
        TBedExample tBedExample = new TBedExample();
        TBedExample.Criteria criteria = tBedExample.createCriteria();
        criteria.andBedCodeEqualTo(code);
        List<TBed> tBeds = tBedMapper.selectByExample(tBedExample);
        if (A.isEmpty(tBeds)){
            return null;
        }
        return tBeds;
    }
}
