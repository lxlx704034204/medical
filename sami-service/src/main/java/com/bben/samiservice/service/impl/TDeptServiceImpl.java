package com.bben.samiservice.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TDeptMapper;
import com.bben.samiservice.model.samiservice.TDept;
import com.bben.samiservice.model.samiservice.TDeptExample;
import com.bben.samiservice.service.TDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "TDeptService")
//@Component
public class TDeptServiceImpl implements TDeptService {

    //private static TDeptServiceImpl  tDeptService ;

    @Autowired
    private TDeptMapper tDeptMapper;

    @Override
    public TDept operationDept(TDept record) {
        if (U.isBlank(record) || U.isBlank(record.getCode())){
            return null;
        }
        List<TDept> tDeptList = selectListByCode(record.getCode());
        if (A.isEmpty(tDeptList)){
            /**
             * 添加科室数据
             */
            int count = tDeptMapper.insert(record);
            if (0 == count){
                return null;
            }
        }else {
            /**
             * 修改科室数据
             */
            TDept oldRecord = A.first(tDeptList);
            record.setId(oldRecord.getId());
            record.setUpdateTime(new Date());
            int count = tDeptMapper.updateByPrimaryKeySelective(record);
            if (0 == count){
                return null;
            }
        }
        return record;
    }

    @Override
    public List<TDept> selectAll() {
        List<TDept> tDeptList = tDeptMapper.selectByExample(null);
        return tDeptList;
    }

    @Override
    public TDept selectByCode(String code) {
        if (U.isBlank(code)){
            return null;
        }
        List<TDept> tDeptList = selectListByCode(code);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return A.first(tDeptList);
    }

    private List<TDept> selectListByCode(String code){
        if (U.isBlank(code)){
            return null;
        }
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return tDeptList;
    }
}
