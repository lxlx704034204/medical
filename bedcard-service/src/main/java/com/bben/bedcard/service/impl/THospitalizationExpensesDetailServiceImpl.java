package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesDetailMapper;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetailExample;
import com.bben.bedcard.service.THospitalizationExpensesDetailService;
import com.bben.bedcard.vo.THospitalizationExpensesDetailVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "THospitalizationExpensesDetailService")
public class THospitalizationExpensesDetailServiceImpl implements THospitalizationExpensesDetailService {

    @Autowired
    private THospitalizationExpensesDetailMapper tHospitalizationExpensesDetailMapper;

    @Override
    public List<THospitalizationExpensesDetailVo> findAll() {
        List<THospitalizationExpensesDetail> tHospitalizationExpensesDetailList = tHospitalizationExpensesDetailMapper.selectByExample(null);
        if (A.isEmpty(tHospitalizationExpensesDetailList)){
            return null;
        }
        return THospitalizationExpensesDetailVo.assemblyDataList(tHospitalizationExpensesDetailList);
    }

    @Override
    public THospitalizationExpensesDetailVo selectByPrimaryKey(Integer hospitalizationExpensesDetailId) {
        if (U.isBlank(hospitalizationExpensesDetailId)){
            return null;
        }
        THospitalizationExpensesDetail tHospitalizationExpensesDetail = tHospitalizationExpensesDetailMapper.selectByPrimaryKey(hospitalizationExpensesDetailId);
        if (U.isBlank(tHospitalizationExpensesDetail)){
            return null;
        }
        return THospitalizationExpensesDetailVo.assemblyData(tHospitalizationExpensesDetail);
    }

    @Override
    public THospitalizationExpensesDetail insertSelective(THospitalizationExpensesDetail record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesDetailMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public THospitalizationExpensesDetail updateByPrimarykey(THospitalizationExpensesDetail record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesDetailMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer hospitalizationExpensesDetailId) {
        if (U.isBlank(hospitalizationExpensesDetailId)){
            return 0;
        }
        return tHospitalizationExpensesDetailMapper.deleteByPrimaryKey(hospitalizationExpensesDetailId);
    }

    @Override
    public List<THospitalizationExpensesDetailVo> selectByCondition(THospitalizationExpensesDetail record) {
        THospitalizationExpensesDetailExample tHospitalizationExpensesDetailExample = new THospitalizationExpensesDetailExample();
        THospitalizationExpensesDetailExample.Criteria criteria = tHospitalizationExpensesDetailExample.createCriteria();
        if (U.isNotBlank(record.getExpensesDayId())){
            criteria.andExpensesDayIdEqualTo(record.getExpensesDayId());
        }
        if (U.isNotBlank(record.getExpensesName())){
            criteria.andExpensesNameLike(record.getExpensesName());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpensesDetail> tHospitalizationExpensesDetailList = tHospitalizationExpensesDetailMapper.selectByExample(tHospitalizationExpensesDetailExample);
        if (A.isEmpty(tHospitalizationExpensesDetailList)){
            return null;
        }
        return THospitalizationExpensesDetailVo.assemblyDataList(tHospitalizationExpensesDetailList);
    }
}
