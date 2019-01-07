package com.bben.samiservice.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TDoctorMapper;
import com.bben.samiservice.model.samiservice.TDoctor;
import com.bben.samiservice.model.samiservice.TDoctorExample;
import com.bben.samiservice.service.TDoctorService;
import org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TDoctorService")
public class TDoctorServiceImpl implements TDoctorService {

    @Autowired
    private TDoctorMapper tDoctorMapper;

    @Override
    public TDoctor operationDoctor(TDoctor record) {
        if (U.isBlank(record) || U.isBlank(record.getCode())){
            return null;
        }
        List<TDoctor> tDoctors = tDoctorListByCode(record.getCode());
        if (A.isEmpty(tDoctors)){
            /**
             * 添加医生数据
             */
            int count = tDoctorMapper.insertSelective(record);
            if (0 == count){
                return null;
            }
        }else {
            /**
             * 更新医生数据
             */
            TDoctor tDoctor = A.first(tDoctors);
            record.setId(tDoctor.getId());
            int count = tDoctorMapper.updateByPrimaryKeySelective(record);
            if (0 == count){
                return null;
            }
        }
        return record;
    }

    /**
     * 根据编码查询code
     * @param code
     * @return
     */
    private List<TDoctor> tDoctorListByCode(String code){
        if (U.isBlank(code)){
            return null;
        }
        TDoctorExample tDoctorExample = new TDoctorExample();
        TDoctorExample.Criteria criteria = tDoctorExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<TDoctor> tDoctors = tDoctorMapper.selectByExample(tDoctorExample);
        if (A.isEmpty(tDoctors)){
            return null;
        }
        return tDoctors;
    }
}
