package com.bben.bedcard.service.impl;

import com.bben.bedcard.dto.TDoctorDto;
import com.bben.bedcard.mapper.bedcard.TDeptMapper;
import com.bben.bedcard.mapper.bedcard.TDoctorMapper;
import com.bben.bedcard.mapper.bedcard.THospitalDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TDoctorService;
import com.bben.bedcard.vo.TDeptVo;
import com.bben.bedcard.vo.TDoctorVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 15:02
 */
@Service(value = "TDoctorService")
public class TDoctorServiceImpl implements TDoctorService {

    @Autowired
    private TDoctorMapper tDoctorMapper;

    @Autowired
    private THospitalDeptMapper tHospitalDeptMapper;

    @Autowired
    private TDeptMapper tDeptMapper;

    @Autowired
    private THospitalMapper tHospitalMapper;

    @Override
    public List<TDoctorVo> findAllTDoctor() {
        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(null);
        if (A.isEmpty(tDoctorList)){
            return null;
        }
        List<TDoctorVo> tDoctorVoList = assemblyDataList(tDoctorList);
        return tDoctorVoList;
    }

    @Override
    public TDoctorVo selectByPrimaryKey(Integer doctorId) {
        if (U.isBlank(doctorId)){
            return null;
        }
        TDoctor tDoctor = tDoctorMapper.selectByPrimaryKey(doctorId);
        return assemblyData(tDoctor);
    }

    @Override
    public TDoctor insertSelective(TDoctorDto record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId()) || U.isBlank(record.getMessageId()) || U.isBlank(record.getHospitalDeptDataId())){
            return null;
        }
        TDoctor tDoctor = selectByDateId(record.getDataId());
        if (U.isNotBlank(tDoctor)){
            return null;
        }
        if (U.isBlank(record.getHospitalDataId())){
            record.setHospitalDeptId(1);
        } else {
            THospital tHospital = selectTHospitalByDataId(record.getHospitalDataId());
            if (U.isBlank(tHospital)){
                record.setHospitalDeptId(1);
            }else {
                record.setHospitalDeptId(tHospital.getId());
            }
        }
        THospitalDept tHospitalDept = selectTHospitalDeptByDataId(record.getHospitalDeptDataId());
        if (U.isBlank(tHospitalDept)){
            return null;
        }
        record.setHospitalDeptId(tHospitalDept.getId());
        TDoctor doctor = TDoctorDto.assemblyData(record);
        int count = tDoctorMapper.insertSelective(doctor);
        if (0 == count){
            return null;
        }
        return doctor;
    }

    @Override
    public TDoctor updateByPrimarykey(TDoctorDto record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId())){
            return null;
        }
        THospital tHospital = new THospital();
        if (U.isNotBlank(record.getHospitalDataId())){
            tHospital = selectTHospitalByDataId(record.getHospitalDataId());
            if (U.isBlank(tHospital)){
                record.setHospitalId(1);
            }else {
                record.setHospitalId(tHospital.getId());
            }
        }
        if (U.isNotBlank(record.getHospitalDeptDataId())){
            THospitalDept tHospitalDept = selectTHospitalDeptByDataId(record.getHospitalDeptDataId());
            if (U.isNotBlank(tHospitalDept)){
                record.setHospitalDeptId(tHospitalDept.getId());
            }else {
                return null;
            }
        }
        TDoctor tDoctor1 = selectByDateId(record.getDataId());
        TDoctor tDoctor2 = TDoctorDto.assemblyData(record);
        tDoctor2.setId(tDoctor1.getId());
        int count = tDoctorMapper.updateByPrimaryKeySelective(tDoctor2);
        if (0 == count){
            return null;
        }
        return tDoctor2;
    }

    @Override
    public int deleteByPrimarykey(Integer doctorId) {
        if (U.isBlank(doctorId)){
            return 0;
        }
        return tDoctorMapper.deleteByPrimaryKey(doctorId);
    }

    @Override
    public List<TDoctorVo> selectByCondition(TDoctor record) {
        TDoctorExample tDoctorExample = new TDoctorExample();
        TDoctorExample.Criteria criteriaDoctor = tDoctorExample.createCriteria();
        if (U.isNotBlank(record.getCode())){
            criteriaDoctor.andCodeEqualTo(record.getCode());
        }
        if (U.isNotBlank(record.getHospitalId())){
            criteriaDoctor.andHospitalIdEqualTo(record.getHospitalId());
        }
        if (U.isNotBlank(record.getHospitalDeptId())){
            criteriaDoctor.andHospitalDeptIdEqualTo(record.getHospitalDeptId());
        }
        if (U.isNotBlank(record.getUserId())){
            criteriaDoctor.andUserIdEqualTo(record.getUserId());
        }
        if (U.isNotBlank(record.getDoctorName())){
            criteriaDoctor.andDoctorNameLike(record.getDoctorName());
        }
        if (U.isNotBlank(record.getSex())){
            criteriaDoctor.andSexEqualTo(record.getSex());
        }
        if (U.isNotBlank(record.getMarriage())){
            criteriaDoctor.andMarriageEqualTo(record.getMarriage());
        }
        if (U.isNotBlank(record.getMobile())){
            criteriaDoctor.andMobileEqualTo(record.getMobile());
        }
        if (U.isNotBlank(record.getIsExpert())){
            criteriaDoctor.andIsExpertEqualTo(record.getIsExpert());
        }
        if (U.isNotBlank(record.getIdNumber())){
            criteriaDoctor.andIdNumberEqualTo(record.getIdNumber());
        }
        if (U.isNotBlank(record.getCheckState())){
            criteriaDoctor.andCheckStateEqualTo(record.getCheckState());
        }
        if (U.isNotBlank(record.getDataId())){
            criteriaDoctor.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteriaDoctor.andDataIdEqualTo(record.getDataId());
        }
        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(tDoctorExample);
        if (A.isEmpty(tDoctorList)){
            return null;
        }
        return TDoctorVo.assemblyDataList(tDoctorList);
    }

    @Override
    public List<TDoctor> selectListByCondition(TDoctor record) {
        TDoctorExample tDoctorExample = new TDoctorExample();
        TDoctorExample.Criteria criteriaDoctor = tDoctorExample.createCriteria();
        if (U.isNotBlank(record.getCode())){
            criteriaDoctor.andCodeEqualTo(record.getCode());
        }
        if (U.isNotBlank(record.getHospitalId())){
            criteriaDoctor.andHospitalIdEqualTo(record.getHospitalId());
        }
        if (U.isNotBlank(record.getHospitalDeptId())){
            criteriaDoctor.andHospitalDeptIdEqualTo(record.getHospitalDeptId());
        }
        if (U.isNotBlank(record.getUserId())){
            criteriaDoctor.andUserIdEqualTo(record.getUserId());
        }
        if (U.isNotBlank(record.getDoctorName())){
            criteriaDoctor.andDoctorNameLike(record.getDoctorName());
        }
        if (U.isNotBlank(record.getSex())){
            criteriaDoctor.andSexEqualTo(record.getSex());
        }
        if (U.isNotBlank(record.getMarriage())){
            criteriaDoctor.andMarriageEqualTo(record.getMarriage());
        }
        if (U.isNotBlank(record.getMobile())){
            criteriaDoctor.andMobileEqualTo(record.getMobile());
        }
        if (U.isNotBlank(record.getIsExpert())){
            criteriaDoctor.andIsExpertEqualTo(record.getIsExpert());
        }
        if (U.isNotBlank(record.getIdNumber())){
            criteriaDoctor.andIdNumberEqualTo(record.getIdNumber());
        }
        if (U.isNotBlank(record.getCheckState())){
            criteriaDoctor.andCheckStateEqualTo(record.getCheckState());
        }
        if (U.isNotBlank(record.getDataId())){
            criteriaDoctor.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteriaDoctor.andDataIdEqualTo(record.getDataId());
        }
        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(tDoctorExample);
        if (A.isEmpty(tDoctorList)){
            return null;
        }
        return tDoctorList;
    }

    @Override
    public int deleteByCondition(TDoctor record) {
        if (U.isBlank(record)){
            return 0;
        }
        record.setStatus((byte) Status.INVALID.getStatus().intValue());
        return tDoctorMapper.updateByPrimaryKeySelective(record);
    }

    private TDoctorVo assemblyData(TDoctor tDoctor){
        TDoctorVo tDoctorVo = new TDoctorVo();
        if (U.isBlank(tDoctor)){
            return tDoctorVo;
        }
        tDoctorVo = TDoctorVo.assemblyData(tDoctor);
        if (U.isNotBlank(tDoctor.getHospitalDeptId())){
            THospitalDept tHospitalDept = tHospitalDeptMapper.selectByPrimaryKey(tDoctor.getHospitalDeptId());
            if (U.isNotBlank(tHospitalDept) || U.isNotBlank(tHospitalDept.getDeptId())){
                TDept tDept = tDeptMapper.selectByPrimaryKey(tHospitalDept.getDeptId());
                if (U.isNotBlank(tDept)){
                    tDoctorVo.setTDeptVo(TDeptVo.assemblyData(tDept));
                }
            }
        }
        return tDoctorVo;
    }

    private List<TDoctorVo> assemblyDataList(List<TDoctor> tDoctorList){
        List<TDoctorVo> tDoctorVoList = new ArrayList<>();
        if (A.isEmpty(tDoctorList)){
            return tDoctorVoList;
        }
        for (TDoctor tDoctor : tDoctorList) {
            TDoctorVo tDoctorVo = assemblyData(tDoctor);
            tDoctorVoList.add(tDoctorVo);
        }
        return tDoctorVoList;
    }

    private TDoctor selectByDateId(String dateId){
        if (U.isBlank(dateId)){
            return null;
        }
        TDoctorExample tDoctorExample = new TDoctorExample();
        TDoctorExample.Criteria criteria = tDoctorExample.createCriteria();
        criteria.andDataIdEqualTo(dateId);
        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(tDoctorExample);
        if (A.isEmpty(tDoctorList)){
            return null;
        }
        return A.first(tDoctorList);
    }

    private THospital selectTHospitalByDataId(String dataId){
        THospitalExample tHospitalExample = new THospitalExample();
        THospitalExample.Criteria criteriaHospital = tHospitalExample.createCriteria();
        criteriaHospital.andDataIdEqualTo(dataId);
        List<THospital> tHospitalList = tHospitalMapper.selectByExample(tHospitalExample);
        if (A.isEmpty(tHospitalList)){
            return null;
        }
        return A.first(tHospitalList);
    }

    private THospitalDept selectTHospitalDeptByDataId(String dataId){
        THospitalDeptExample tHospitalDeptExample = new THospitalDeptExample();
        THospitalDeptExample.Criteria criteriaHospitalDept = tHospitalDeptExample.createCriteria();
        criteriaHospitalDept.andDataIdEqualTo(dataId);
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(tHospitalDeptExample);
        if (A.isEmpty(tHospitalDeptList)){
            return null;
        }
        return A.first(tHospitalDeptList);
    }

}
