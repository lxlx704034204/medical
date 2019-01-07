package com.bben.samiservice.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.mapper.samiservice.TNurseMapper;
import com.bben.samiservice.model.samiservice.TNurse;
import com.bben.samiservice.model.samiservice.TNurseExample;
import com.bben.samiservice.service.TNurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TNurseService")
public class TNurseServiceImpl implements TNurseService {

    @Autowired
    private TNurseMapper tNurseMapper;

    @Override
    public TNurse operationNurse(TNurse record) {
        if (U.isBlank(record) || U.isBlank(record.getCode())){
            return null;
        }
        List<TNurse> tNurses = tNurseListByCode(record.getCode());
        if (A.isEmpty(tNurses)){
            /**
             * 添加护士数据
             */
            int count = tNurseMapper.insertSelective(record);
            if (0 == count){
                return null;
            }
        }else {
            /**
             * 更新护士数据
             */
            TNurse tNurse = A.first(tNurses);
            record.setId(tNurse.getId());
            int count = tNurseMapper.updateByPrimaryKeySelective(record);
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
    private List<TNurse> tNurseListByCode(String code){
        if (U.isBlank(code)){
            return null;
        }
        TNurseExample tNurseExample = new TNurseExample();
        TNurseExample.Criteria criteria = tNurseExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<TNurse> tNurses = tNurseMapper.selectByExample(tNurseExample);
        if (A.isEmpty(tNurses)){
            return null;
        }
        return tNurses;
    }
}
