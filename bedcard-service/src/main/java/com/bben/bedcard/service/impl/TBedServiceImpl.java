package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.*;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TBedService;
import com.bben.bedcard.vo.*;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/10 9:56
 */
@Service(value = "TBedService")
public class TBedServiceImpl implements TBedService {

    @Autowired
    private TBedMapper tBedMapper;

    @Autowired
    private TSickroomMapper tSickroomMapper;

    @Autowired
    private TWardMapper tWardMapper;

    @Autowired
    private TPatientBedMapper tPatientBedMapper;

    @Autowired
    private TPatientMapper tPatientMapper;

    @Autowired
    private TPatientAllergyTypeRefMapper tPatientAllergyTypeRefMapper;

    @Autowired
    private TAllergyTypeMapper tAllergyTypeMapper;

    @Autowired
    private TPatientCareLableRefMapper tPatientCareLableRefMapper;

    @Autowired
    private TCareLableMapper tCareLableMapper;

    @Autowired
    private TPatientDoctorRefMapper tPatientDoctorRefMapper;

    @Autowired
    private TDoctorMapper tDoctorMapper;

    @Autowired
    private TPatientNurseRefMapper tPatientNurseRefMapper;

    @Autowired
    private TNurseMapper tNurseMapper;

    @Override
    public List<TBedVo> findAll() {
        List<TBed> tBedList = tBedMapper.selectByExample(null);
        if (A.isEmpty(tBedList)){
            return null;
        }

        return assemblyDataList(tBedList);
    }

    @Override
    public TBedVo selectByPrimaryKey(Integer bedId) {
        if (U.isBlank(bedId)){
            return null;
        }
        TBed tBed = tBedMapper.selectByPrimaryKey(bedId);
        if (U.isBlank(tBed)){
            return null;
        }
        return assemblyData(tBed);
    }

    @Override
    public TBed insertSelective(TBed record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tBedMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TBed updateByPrimarykey(TBed record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tBedMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer bedId) {
        return tBedMapper.deleteByPrimaryKey(bedId);
    }

    @Override
    public List<TBedVo> selectByCondition(TBed record) {
        TBedExample tBedExample = new TBedExample();
        TBedExample.Criteria criteria = tBedExample.createCriteria();
        if (U.isNotBlank(record.getBedCardId())){
            criteria.andBedCardIdEqualTo(record.getBedCardId());
        }
        if (U.isNotBlank(record.getSickroomId())){
            criteria.andSickroomIdEqualTo(record.getSickroomId());
        }
        if (U.isNotBlank(record.getBedType())){
            criteria.andBedTypeEqualTo(record.getBedType());
        }
        if (U.isNotBlank(record.getBedNum())){
            criteria.andBedNumEqualTo(record.getBedNum());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        List<TBed> tBedList = tBedMapper.selectByExample(tBedExample);
        if (A.isEmpty(tBedList)){
            return null;
        }
        return assemblyDataList(tBedList);
    }

    private TBedVo assemblyData(TBed tBed){
        TBedVo tBedVo = TBedVo.assemblyData(tBed);
        if (U.isBlank(tBed) || U.isBlank(tBed.getId())){
            return tBedVo;
        }
        TPatientBedExample tPatientBedExample = new TPatientBedExample();
        TPatientBedExample.Criteria criteria = tPatientBedExample.createCriteria();
        criteria.andBedIdEqualTo(tBed.getId());
        /**
         * 病人对应的床位
         */
        List<TPatientBed> tPatientBedList = tPatientBedMapper.selectByExample(tPatientBedExample);
        if (A.isNotEmpty(tPatientBedList)){
            TPatientBed tPatientBed = tPatientBedList.get(0);
            if (U.isNotBlank(tPatientBed.getPatientId())){
                TPatientVo tPatientVo;
                /**
                 * 病人信息
                 */
                TPatient tPatient = tPatientMapper.selectByPrimaryKey(tPatientBed.getPatientId());
                if (U.isNotBlank(tPatient)){
                    tPatientVo = TPatientVo.assemblyData(tPatient);

                    TPatientAllergyTypeRefExample tPatientAllergyTypeRefExample = new TPatientAllergyTypeRefExample();
                    TPatientAllergyTypeRefExample.Criteria criteriaPatientAllergyTypeRef = tPatientAllergyTypeRefExample.createCriteria();
                    criteriaPatientAllergyTypeRef.andPatientIdEqualTo(tPatient.getId());
                    criteriaPatientAllergyTypeRef.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                    List<TPatientAllergyTypeRef> tPatientAllergyTypeRef = tPatientAllergyTypeRefMapper.selectByExample(tPatientAllergyTypeRefExample);
                    if (A.isNotEmpty(tPatientAllergyTypeRef)){
                        /**
                         * java8特性，从List对象中取某元素的List
                         */
                        List<Integer> allergyTypeIdList=tPatientAllergyTypeRef.stream().map(TPatientAllergyTypeRef::getAllergyTypeId).collect(Collectors.toList());
                        TAllergyTypeExample tAllergyTypeExample = new TAllergyTypeExample();
                        TAllergyTypeExample.Criteria criteriaAllergyType = tAllergyTypeExample.createCriteria();
                        criteriaAllergyType.andIdIn(allergyTypeIdList);
                        criteriaAllergyType.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                        /**
                         * 过敏类型表
                         */
                        List<TAllergyType> tAllergyTypeList = tAllergyTypeMapper.selectByExample(tAllergyTypeExample);
                        if (A.isNotEmpty(tAllergyTypeList)){
                            tPatientVo.setTAllergyTypeVoList(TAllergyTypeVo.assemblyDataList(tAllergyTypeList));
                        }
                    }
                    TPatientCareLableRefExample tPatientCareLableRefExample = new TPatientCareLableRefExample();
                    TPatientCareLableRefExample.Criteria criteriaPatientCareLable = tPatientCareLableRefExample.createCriteria();
                    criteriaPatientCareLable.andPatientIdEqualTo(tPatientBed.getPatientId());
                    criteriaPatientCareLable.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                    /**
                     *病人和护理标签关联表
                     */
                    List<TPatientCareLableRef> tPatientCareLableRef = tPatientCareLableRefMapper.selectByExample(tPatientCareLableRefExample);
                    if (A.isNotEmpty(tPatientCareLableRef)){
                        List<Integer> careLableIdList=tPatientCareLableRef.stream().map(TPatientCareLableRef::getCareLableId).collect(Collectors.toList());
                        TCareLableExample tCareLableExample = new TCareLableExample();
                        TCareLableExample.Criteria criteriaCareLable = tCareLableExample.createCriteria();
                        criteriaCareLable.andIdIn(careLableIdList);
                        criteriaCareLable.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                        List<TCareLable> careLableList = tCareLableMapper.selectByExample(tCareLableExample);
                        if (A.isNotEmpty(careLableList)){
                            tPatientVo.setTCareLableVoList(TCareLableVo.assemblyDataList(careLableList));
                        }
                    }
                    TPatientDoctorRefExample tPatientDoctorRefExample = new TPatientDoctorRefExample();
                    TPatientDoctorRefExample.Criteria criteriaPatientDoctor = tPatientDoctorRefExample.createCriteria();
                    criteriaPatientDoctor.andPatientIdEqualTo(tPatientBed.getPatientId());
                    criteriaPatientDoctor.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                    /**
                     * 病人和医生关联表
                     */
                    List<TPatientDoctorRef> tPatientDoctorRefList = tPatientDoctorRefMapper.selectByExample(tPatientDoctorRefExample);
                    if (A.isNotEmpty(tPatientDoctorRefList)){
                        List<Integer> doctorId=tPatientDoctorRefList.stream().map(TPatientDoctorRef::getDoctorId).collect(Collectors.toList());
                        TDoctorExample tDoctorExample = new TDoctorExample();
                        TDoctorExample.Criteria criteriaDoctor = tDoctorExample.createCriteria();
                        criteriaDoctor.andIdIn(doctorId);
                        criteriaDoctor.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(tDoctorExample);
                        if (A.isNotEmpty(tDoctorList)){
                            tPatientVo.setTDoctorBrieflyVoList(TDoctorBrieflyVo.assemblyDataList(tDoctorList));
                        }
                    }
                    /**
                     * 病人和护士关联表
                     */
                    TPatientNurseRefExample tPatientNurseRefExample = new TPatientNurseRefExample();
                    TPatientNurseRefExample.Criteria criteriaPatientNurse = tPatientNurseRefExample.createCriteria();
                    criteriaPatientNurse.andPatientIdEqualTo(tPatientBed.getPatientId());
                    criteriaPatientNurse.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                    List<TPatientNurseRef> tPatientNurseRefList = tPatientNurseRefMapper.selectByExample(tPatientNurseRefExample);
                    if (A.isNotEmpty(tPatientNurseRefList)){
                        List<Integer> nurseId  =tPatientNurseRefList.stream().map(TPatientNurseRef::getNurseId).collect(Collectors.toList());
                        TNurseExample tNurseExample = new TNurseExample();
                        TNurseExample.Criteria criteriaNurse = tNurseExample.createCriteria();
                        criteriaNurse.andIdIn(nurseId);
                        criteriaNurse.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                        List<TNurse> tNurseList = tNurseMapper.selectByExample(tNurseExample);
                        if (A.isNotEmpty(tNurseList)){
                            tPatientVo.setTNurseBrieflyVoList(TNurseBrieflyVo.assemblyDataList(tNurseList));
                        }
                    }
                    tBedVo.setTPatientVo(tPatientVo);
                }
            }

        }
        if (U.isBlank(tBed.getSickroomId())){
            return tBedVo;
        }
        TSickroom tSickroom = tSickroomMapper.selectByPrimaryKey(tBed.getSickroomId());
        if (U.isBlank(tSickroom)){
            return tBedVo;
        }
        tBedVo.setTSickroomVo(TSickroomVo.assemblyData(tSickroom));
        TSickroomVo tSickroomVo = TSickroomVo.assemblyData(tSickroom);
        if (U.isBlank(tSickroomVo.getWardId())){
            return tBedVo;
        }
        TWard tWard = tWardMapper.selectByPrimaryKey(tSickroomVo.getWardId());
        if (U.isBlank(tWard)){
            return tBedVo;
        }
        tBedVo.setTWardVo(TWardVo.assemblyData(tWard));
        return tBedVo;
    }

    public List<TBedVo> assemblyDataList(List<TBed> tBedList){
        List<TBedVo> tBedVoList = new ArrayList<>();
        if (A.isEmpty(tBedList)){
            return tBedVoList;
        }
        for (TBed tBed : tBedList) {
            TBedVo tBedVo = assemblyData(tBed);
            if (U.isNotBlank(tBedVo)){
                tBedVoList.add(tBedVo);
            }
        }
        return tBedVoList;
    }
}
