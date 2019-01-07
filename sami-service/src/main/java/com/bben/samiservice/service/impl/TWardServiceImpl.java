package com.bben.samiservice.service.impl;

import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TWardMapper;
import com.bben.samiservice.model.samiservice.TWard;
import com.bben.samiservice.model.samiservice.TWardExample;
import com.bben.samiservice.service.TWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TWardService")
public class TWardServiceImpl implements TWardService {

    @Autowired
    private TWardMapper tWardMapper;

    @Override
    public List<TWard> selectByCode(String code) {
        if (U.isBlank(code)){
            return null;
        }
        TWardExample tWardExample = new TWardExample();
        TWardExample.Criteria criteria = tWardExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<TWard> tWards = tWardMapper.selectByExample(tWardExample);
        if (U.isBlank(tWards)){
            return null;
        }
        return tWards;
    }
}
