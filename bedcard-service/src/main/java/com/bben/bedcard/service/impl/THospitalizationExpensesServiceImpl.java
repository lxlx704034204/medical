package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesDayMapper;
import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesDetailMapper;
import com.bben.bedcard.mapper.bedcard.THospitalizationExpensesMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.THospitalizationExpensesService;
import com.bben.bedcard.vo.THospitalizationExpensesDayVo;
import com.bben.bedcard.vo.THospitalizationExpensesDetailVo;
import com.bben.bedcard.vo.THospitalizationExpensesVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "THospitalizationExpensesService")
public class THospitalizationExpensesServiceImpl implements THospitalizationExpensesService {

    @Autowired
    private THospitalizationExpensesMapper tHospitalizationExpensesMapper;

    @Autowired
    private THospitalizationExpensesDayMapper tHospitalizationExpensesDayMapper;

    @Autowired
    private THospitalizationExpensesDetailMapper tHospitalizationExpensesDetailMapper;

    @Override
    public List<THospitalizationExpensesVo> findAll() {
        List<THospitalizationExpenses> tHospitalizationExpensesList = tHospitalizationExpensesMapper.selectByExample(null);
        if (A.isEmpty(tHospitalizationExpensesList)){
            return null;
        }
        return THospitalizationExpensesVo.assemblyDataList(tHospitalizationExpensesList);
    }

    @Override
    public THospitalizationExpensesVo selectByPrimaryKey(Integer hospitalizationExpensesId) {
        if (U.isBlank(hospitalizationExpensesId)){
            return null;
        }
        THospitalizationExpenses tHospitalizationExpenses = tHospitalizationExpensesMapper.selectByPrimaryKey(hospitalizationExpensesId);
        if (U.isBlank(tHospitalizationExpenses)){
            return null;
        }
        return THospitalizationExpensesVo.assemblyData(tHospitalizationExpenses);
    }

    @Override
    public THospitalizationExpenses insertSelective(THospitalizationExpenses record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public THospitalizationExpenses updateByPrimarykey(THospitalizationExpenses record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalizationExpensesMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer hospitalizationExpensesId) {
        if (U.isBlank(hospitalizationExpensesId)){
            return 0;
        }
        return tHospitalizationExpensesMapper.deleteByPrimaryKey(hospitalizationExpensesId);
    }

    @Override
    public List<THospitalizationExpensesVo> selectByCondition(THospitalizationExpenses record) {
        THospitalizationExpensesExample tHospitalizationExpensesExample = new THospitalizationExpensesExample();
        THospitalizationExpensesExample.Criteria criteria = tHospitalizationExpensesExample.createCriteria();
        if (U.isNotBlank(record.getPatientId())){
            criteria.andPatientIdEqualTo(record.getPatientId());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpenses> tHospitalizationExpensesList = tHospitalizationExpensesMapper.selectByExample(tHospitalizationExpensesExample);
        if (A.isEmpty(tHospitalizationExpensesList)){
            return null;
        }
        return THospitalizationExpensesVo.assemblyDataList(tHospitalizationExpensesList);
    }

    @Override
    public THospitalizationExpensesVo selectByPrimaryKeyAndDetail(Integer hospitalizationExpensesId) {
        if (U.isBlank(hospitalizationExpensesId)){
            return null;
        }
        THospitalizationExpenses tHospitalizationExpenses = tHospitalizationExpensesMapper.selectByPrimaryKey(hospitalizationExpensesId);
        if (U.isBlank(tHospitalizationExpenses)){
            return null;
        }
        return assemblyData(tHospitalizationExpenses);
    }

    @Override
    public List<THospitalizationExpensesVo> selectByConditionAndDetail(THospitalizationExpenses record) {
        THospitalizationExpensesExample tHospitalizationExpensesExample = new THospitalizationExpensesExample();
        THospitalizationExpensesExample.Criteria criteria = tHospitalizationExpensesExample.createCriteria();
        if (U.isNotBlank(record.getPatientId())){
            criteria.andPatientIdEqualTo(record.getPatientId());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpenses> tHospitalizationExpensesList = tHospitalizationExpensesMapper.selectByExample(tHospitalizationExpensesExample);
        if (A.isEmpty(tHospitalizationExpensesList)){
            return null;
        }
        return assemblyDataList(tHospitalizationExpensesList);
    }


    private THospitalizationExpensesVo assemblyData(THospitalizationExpenses record){
        if (U.isBlank(record)){
            return null;
        }
        THospitalizationExpensesVo tHospitalizationExpensesVo = THospitalizationExpensesVo.assemblyData(record);
        THospitalizationExpensesDayExample tHospitalizationExpensesDayExample = new THospitalizationExpensesDayExample();
        THospitalizationExpensesDayExample.Criteria criteriaDay = tHospitalizationExpensesDayExample.createCriteria();
        criteriaDay.andExpensesIdEqualTo(record.getId());
        criteriaDay.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalizationExpensesDay> tHospitalizationExpensesDayList = tHospitalizationExpensesDayMapper.selectByExample(tHospitalizationExpensesDayExample);
        if (A.isNotEmpty(tHospitalizationExpensesDayList)){
            List<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoList = new ArrayList<>();
            /*List<Integer> dayIdList=tHospitalizationExpensesDayList.stream().map(THospitalizationExpensesDay::getId).collect(Collectors.toList());*/
            for (THospitalizationExpensesDay tHospitalizationExpensesDay : tHospitalizationExpensesDayList) {
                THospitalizationExpensesDayVo tHospitalizationExpensesDayVo = THospitalizationExpensesDayVo.assemblyData(tHospitalizationExpensesDay);
                THospitalizationExpensesDetailExample tHospitalizationExpensesDetailExample = new THospitalizationExpensesDetailExample();
                THospitalizationExpensesDetailExample.Criteria criteria = tHospitalizationExpensesDetailExample.createCriteria();
                criteria.andExpensesDayIdEqualTo(tHospitalizationExpensesDay.getId());
                criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                List<THospitalizationExpensesDetail> tHospitalizationExpensesDetailList = tHospitalizationExpensesDetailMapper.selectByExample(tHospitalizationExpensesDetailExample);
                if (A.isNotEmpty(tHospitalizationExpensesDetailList)){
                    tHospitalizationExpensesDayVo.setTHospitalizationExpensesDetailVoList(THospitalizationExpensesDetailVo.assemblyDataList(tHospitalizationExpensesDetailList));
                }
                tHospitalizationExpensesDayVoList.add(tHospitalizationExpensesDayVo);
            }

            tHospitalizationExpensesVo.setTHospitalizationExpensesDayVoList(tHospitalizationExpensesDayVoList);
            
        }
        return tHospitalizationExpensesVo;
    }

    private List<THospitalizationExpensesVo> assemblyDataList(List<THospitalizationExpenses> tHospitalizationExpensesList){
        if (A.isEmpty(tHospitalizationExpensesList)){
            return null;
        }
        List<THospitalizationExpensesVo> tHospitalizationExpensesVoList = new ArrayList<>();
        for (THospitalizationExpenses tHospitalizationExpenses : tHospitalizationExpensesList) {
            THospitalizationExpensesVo hospitalizationExpensesVo = assemblyData(tHospitalizationExpenses);
            tHospitalizationExpensesVoList.add(hospitalizationExpensesVo);
        }
        return tHospitalizationExpensesVoList;
    }

}
