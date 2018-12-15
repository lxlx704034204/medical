package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TDrugsDoseMapper;
import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.bedcard.model.bedcard.TDrugsDoseExample;
import com.bben.bedcard.service.TDrugsDoseService;
import com.bben.bedcard.vo.TDrugsDoseVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TDrugsDoseService")
public class TDrugsDoseServiceImpl implements TDrugsDoseService {

    @Autowired
    private TDrugsDoseMapper tDrugsDoseMapper;

    @Override
    public List<TDrugsDoseVo> findAll() {
        List<TDrugsDose> tDrugsDoseList = tDrugsDoseMapper.selectByExample(null);
        if (A.isEmpty(tDrugsDoseList)){
            return null;
        }
        return TDrugsDoseVo.assemblyDataList(tDrugsDoseList);
    }

    @Override
    public TDrugsDoseVo selectByPrimaryKey(Integer drugsDoseId) {
        if (U.isBlank(drugsDoseId)){
            return null;
        }
        TDrugsDose tDrugsDose = tDrugsDoseMapper.selectByPrimaryKey(drugsDoseId);
        if (U.isBlank(tDrugsDose)){
            return null;
        }
        return TDrugsDoseVo.assemblyData(tDrugsDose);
    }

    @Override
    public TDrugsDose insertSelective(TDrugsDose record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tDrugsDoseMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TDrugsDose updateByPrimarykey(TDrugsDose record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tDrugsDoseMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer drugsDoseId) {
        if (U.isBlank(drugsDoseId)){
            return 0;
        }
        return tDrugsDoseMapper.deleteByPrimaryKey(drugsDoseId);
    }

    @Override
    public List<TDrugsDoseVo> selectByCondition(TDrugsDose record) {
        TDrugsDoseExample tDrugsDoseExample = new TDrugsDoseExample();
        TDrugsDoseExample.Criteria criteria = tDrugsDoseExample.createCriteria();
        if (U.isNotBlank(record.getMedicationRecordId())){
            criteria.andMedicationRecordIdEqualTo(record.getMedicationRecordId());
        }
        if (U.isNotBlank(record.getDrugName())){
            criteria.andDrugNameEqualTo(record.getDrugName());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TDrugsDose> tDrugsDoseList = tDrugsDoseMapper.selectByExample(tDrugsDoseExample);
        if (A.isEmpty(tDrugsDoseList)){
            return null;
        }
        return TDrugsDoseVo.assemblyDataList(tDrugsDoseList);
    }
}
