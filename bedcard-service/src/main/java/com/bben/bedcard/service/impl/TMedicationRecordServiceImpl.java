package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TDrugsDoseMapper;
import com.bben.bedcard.mapper.bedcard.TMedicationRecordMapper;
import com.bben.bedcard.mapper.bedcard.TNurseMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TMedicationRecordService;
import com.bben.bedcard.vo.TDrugsDoseVo;
import com.bben.bedcard.vo.TMedicationRecordVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "TMedicationRecordService")
public class TMedicationRecordServiceImpl implements TMedicationRecordService {

    @Autowired
    private TMedicationRecordMapper tMedicationRecordMapper;

    @Autowired
    private TDrugsDoseMapper tDrugsDoseMapper;

    @Autowired
    private TNurseMapper tNurseMapper;

    @Override
    public List<TMedicationRecordVo> findAll() {
        List<TMedicationRecord> tMedicationRecordList = tMedicationRecordMapper.selectByExample(null);
        if (A.isEmpty(tMedicationRecordList)){
            return null;
        }
        return assemblyDataList(tMedicationRecordList);
    }

    @Override
    public TMedicationRecordVo selectByPrimaryKey(Integer medicationRecordId) {
        if (U.isBlank(medicationRecordId)){
            return null;
        }
        TMedicationRecord tMedicationRecord = tMedicationRecordMapper.selectByPrimaryKey(medicationRecordId);
        if (U.isBlank(tMedicationRecord)){
            return null;
        }
        return assemblyData(tMedicationRecord);
    }

    @Override
    public TMedicationRecord insertSelective(TMedicationRecord record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tMedicationRecordMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TMedicationRecord updateByPrimarykey(TMedicationRecord record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tMedicationRecordMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer medicationRecordId) {
        if (U.isBlank(medicationRecordId)){
            return 0;
        }
        return tMedicationRecordMapper.deleteByPrimaryKey(medicationRecordId);
    }

    @Override
    public List<TMedicationRecordVo> selectByCondition(TMedicationRecord record) {
        TMedicationRecordExample tMedicationRecordExample = new TMedicationRecordExample();
        TMedicationRecordExample.Criteria criteria = tMedicationRecordExample.createCriteria();
        if (U.isNotBlank(record.getPatientId())){
            criteria.andPatientIdEqualTo(record.getPatientId());
        }
        if (U.isNotBlank(record.getCureNo())){
            criteria.andCureNoEqualTo(record.getCureNo());
        }
        if (U.isNotBlank(record.getDrugDeliveryNurseId())){
            criteria.andDrugDeliveryNurseIdEqualTo(record.getDrugDeliveryNurseId());
        }
        if (U.isNotBlank(record.getDateOfHospitalization())){
            criteria.andDateOfHospitalizationEqualTo(record.getDateOfHospitalization());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        tMedicationRecordExample.setOrderByClause(" date_of_hospitalization desc ");
        List<TMedicationRecord> tMedicationRecordList = tMedicationRecordMapper.selectByExample(tMedicationRecordExample);
        if (A.isEmpty(tMedicationRecordList)){
            return null;
        }
        return assemblyDataList(tMedicationRecordList);
    }

    private TMedicationRecordVo assemblyData(TMedicationRecord tMedicationRecord){
        if (U.isBlank(tMedicationRecord)){
            return null;
        }
        TMedicationRecordVo tMedicationRecordVo = TMedicationRecordVo.assemblyData(tMedicationRecord);
        TNurse tNurse = tNurseMapper.selectByPrimaryKey(tMedicationRecord.getDrugDeliveryNurseId());
        if (U.isNotBlank(tNurse)){
            tMedicationRecordVo.setDrugDeliveryNurseName(tNurse.getName());
        }
        TDrugsDoseExample tDrugsDoseExample = new TDrugsDoseExample();
        TDrugsDoseExample.Criteria criteria = tDrugsDoseExample.createCriteria();
        criteria.andMedicationRecordIdEqualTo(tMedicationRecord.getId());
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TDrugsDose> tDrugsDoseList = tDrugsDoseMapper.selectByExample(tDrugsDoseExample);
        if (A.isNotEmpty(tDrugsDoseList)){
            tMedicationRecordVo.setTDrugsDoseVoList(TDrugsDoseVo.assemblyDataList(tDrugsDoseList));
        }
        return tMedicationRecordVo;
    }

    private List<TMedicationRecordVo> assemblyDataList(List<TMedicationRecord> tMedicationRecordList){
        if (A.isEmpty(tMedicationRecordList)){
            return null;
        }
        List<TMedicationRecordVo> tMedicationRecordVoList = new ArrayList<>();
        for (TMedicationRecord tMedicationRecord : tMedicationRecordList) {
            TMedicationRecordVo tMedicationRecordVo = assemblyData(tMedicationRecord);
            tMedicationRecordVoList.add(tMedicationRecordVo);
        }
        return tMedicationRecordVoList;
    }
}
