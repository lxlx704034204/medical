package com.bben.samiservice.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TSickroomMapper;
import com.bben.samiservice.model.samiservice.TSickroom;
import com.bben.samiservice.model.samiservice.TSickroomExample;
import com.bben.samiservice.service.TSickroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TSickroomService")
public class TSickroomServiceImpl implements TSickroomService {

    @Autowired
    private TSickroomMapper tSickroomMapper;

    @Override
    public List<TSickroom> selectByCode(String code) {
        if (U.isBlank(code)){
            return null;
        }
        TSickroomExample tSickroomExample = new TSickroomExample();
        TSickroomExample.Criteria criteria = tSickroomExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<TSickroom> tSickrooms = tSickroomMapper.selectByExample(tSickroomExample);
        if (A.isEmpty(tSickrooms)){
            return null;
        }
        return tSickrooms;
    }
}
