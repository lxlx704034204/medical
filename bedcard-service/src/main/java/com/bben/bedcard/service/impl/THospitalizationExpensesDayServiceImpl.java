package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesDayMapper;
import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesDetailMapper;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDayExample;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetailExample;
import com.bben.bedcard.service.THospitalizationExpensesDayService;
import com.bben.bedcard.vo.THospitalizationExpensesDayVo;
import com.bben.bedcard.vo.THospitalizationExpensesDetailVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "THospitalizationExpensesDayService")
public class THospitalizationExpensesDayServiceImpl implements THospitalizationExpensesDayService {

    @Autowired
    private THospitalizationExpensesDayMapper tHospitalizationExpensesDayMapper;

    @Autowired
    private THospitalizationExpensesDetailMapper tHospitalizationExpensesDetailMapper;

    @Override
    public List<THospitalizationExpensesDayVo> findAll() {
        List<THospitalizationExpensesDay> tHospitalizationExpensesDayList = tHospitalizationExpensesDayMapper.selectByExample(null);
        if (A.isEmpty(tHospitalizationExpensesDayList)){
            return null;
        }
        return assemblyDataList(tHospitalizationExpensesDayList);
    }

    @Override
    public THospitalizationExpensesDayVo selectByPrimaryKey(Integer hospitalizationExpensesDayId) {
        if (U.isBlank(hospitalizationExpensesDayId)){
            return null;
        }
        THospitalizationExpensesDay tHospitalizationExpensesDay = tHospitalizationExpensesDayMapper.selectByPrimaryKey(hospitalizationExpensesDayId);
        if (U.isBlank(tHospitalizationExpensesDay)){
            return null;
        }
        return assemblyData(tHospitalizationExpensesDay);
    }

    @Override
    public THospitalizationExpensesDay insertSelective(THospitalizationExpensesDay record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesDayMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public THospitalizationExpensesDay updateByPrimarykey(THospitalizationExpensesDay record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesDayMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer hospitalizationExpensesDayId) {
        if (U.isBlank(hospitalizationExpensesDayId)){
            return 0;
        }
        return tHospitalizationExpensesDayMapper.deleteByPrimaryKey(hospitalizationExpensesDayId);
    }

    @Override
    public List<THospitalizationExpensesDayVo> selectByCondition(THospitalizationExpensesDay record) {
        THospitalizationExpensesDayExample tHospitalizationExpensesDayExample = new THospitalizationExpensesDayExample();
        THospitalizationExpensesDayExample.Criteria criteria = tHospitalizationExpensesDayExample.createCriteria();
        if (U.isNotBlank(record.getExpensesId())){
            criteria.andExpensesIdEqualTo(record.getExpensesId());
        }
        if (U.isNotBlank(record.getDateOfHospitalization())){
            criteria.andDateOfHospitalizationEqualTo(record.getDateOfHospitalization());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpensesDay> tHospitalizationExpensesDayList = tHospitalizationExpensesDayMapper.selectByExample(tHospitalizationExpensesDayExample);
        if (A.isEmpty(tHospitalizationExpensesDayList)){
            return null;
        }
        return assemblyDataList(tHospitalizationExpensesDayList);
    }

    private THospitalizationExpensesDayVo assemblyData(THospitalizationExpensesDay record){
        if (U.isBlank(record)){
            return null;
        }
        THospitalizationExpensesDayVo tHospitalizationExpensesDayVo = THospitalizationExpensesDayVo.assemblyData(record);
        THospitalizationExpensesDetailExample tHospitalizationExpensesDetailExample = new THospitalizationExpensesDetailExample();
        THospitalizationExpensesDetailExample.Criteria criteria = tHospitalizationExpensesDetailExample.createCriteria();
        criteria.andExpensesDayIdEqualTo(record.getId());
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpensesDetail> tHospitalizationExpensesDetailList = tHospitalizationExpensesDetailMapper.selectByExample(tHospitalizationExpensesDetailExample);
        if (A.isNotEmpty(tHospitalizationExpensesDetailList)){
            tHospitalizationExpensesDayVo.setTHospitalizationExpensesDetailVoList(THospitalizationExpensesDetailVo.assemblyDataList(tHospitalizationExpensesDetailList));
        }
        return tHospitalizationExpensesDayVo;
    }

    private List<THospitalizationExpensesDayVo> assemblyDataList(List<THospitalizationExpensesDay> tHospitalizationExpensesDayList){
        if (A.isEmpty(tHospitalizationExpensesDayList)){
            return null;
        }
        List<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoList = new ArrayList<>();
        for (THospitalizationExpensesDay tHospitalizationExpensesDay : tHospitalizationExpensesDayList) {
            THospitalizationExpensesDayVo tHospitalizationExpensesDayVo = assemblyData(tHospitalizationExpensesDay);
            tHospitalizationExpensesDayVoList.add(tHospitalizationExpensesDayVo);
        }
        return tHospitalizationExpensesDayVoList;
    }
}
