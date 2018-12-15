package com.bben.bedcard.service.impl;

import com.bben.bedcard.dto.THospitalDto;
import com.bben.bedcard.mapper.bedcard.TDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.THospitalService;
import com.bben.bedcard.vo.TDeptVo;
import com.bben.bedcard.vo.THospitalVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/13 14:55
 */
@Service(value = "THospitalService")
public class THospitalServiceImpl implements THospitalService {

    @Autowired
    private THospitalMapper tHospitalMapper;

    @Autowired
    private THospitalDeptMapper tHospitalDeptMapper;

    @Autowired
    private TDeptMapper tDeptMapper;

    @Override
    public List<THospitalVo> findAllTHospital() {
        List<THospital> tHospitalList = tHospitalMapper.selectByExample(null);
        if (A.isEmpty(tHospitalList)){
            return null;
        }
        return assemblyDataList(tHospitalList);
    }

    @Override
    public THospitalVo selectByPrimaryKey(Integer hospitalId) {
        if (U.isBlank(hospitalId)){
            return null;
        }
        THospital tHospital = tHospitalMapper.selectByPrimaryKey(hospitalId);
        if (U.isBlank(tHospital)){
            return null;
        }
        return assemblyData(tHospital);
    }

    @Override
    public THospital insertSelective(THospital record) {
        if (U.isBlank(record)){
            return null;
        }
        int ok = tHospitalMapper.insertSelective(record);
        if (0 == ok){
            return null;
        }
        return record;
    }

    @Override
    public THospital updateByPrimarykey(THospital record) {
        if (U.isBlank(record)){
            return null;
        }
        int ok = tHospitalMapper.updateByPrimaryKeySelective(record);
        if (0 == ok){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer hospitalId) {
        if (U.isBlank(hospitalId)){
            return 0;
        }
        return tHospitalMapper.deleteByPrimaryKey(hospitalId);
    }

    @Override
    public List<THospitalVo> findByCondition(THospitalDto record) {
        THospitalExample tHospitalExample = new THospitalExample();
        THospitalExample.Criteria criteria = tHospitalExample.createCriteria();
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike("%"+record.getName()+"%");
        }
        List<THospital> tHospitalList = tHospitalMapper.selectByExample(tHospitalExample);
        if (A.isEmpty(tHospitalList)){
            return null;
        }
        return THospitalVo.assemblyDataList(tHospitalList);
    }

    private THospitalVo assemblyData(THospital tHospital){
        if (U.isBlank(tHospital)){
            return null;
        }
        THospitalVo tHospitalVo = THospitalVo.assemblyData(tHospital);
        THospitalDeptExample tHospitalDeptExample = new THospitalDeptExample();
        THospitalDeptExample.Criteria criteriaHospital = tHospitalDeptExample.createCriteria();
        criteriaHospital.andHospitalIdEqualTo(tHospital.getId());
        criteriaHospital.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(tHospitalDeptExample);
        if (A.isNotEmpty(tHospitalDeptList)){
            List<TDeptVo> tDeptVoList = new ArrayList<>();
            for (THospitalDept tHospitalDept : tHospitalDeptList) {
                TDeptVo tDeptVo = new TDeptVo();
                if (tHospitalDept.getId().equals(tHospitalDept.getParentDeptId())){
                    TDept tDept = tDeptMapper.selectByPrimaryKey(tHospitalDept.getDeptId());
                    if (U.isNotBlank(tDept)){
                        tDeptVo = TDeptVo.assemblyData(tDept);
                    }
                }
                List<Integer> tSonHospitalDeptIdList = new ArrayList<>();
                for (THospitalDept hospitalDept : tHospitalDeptList) {
                   if (!hospitalDept.getParentDeptId().equals(hospitalDept.getId()) && hospitalDept.getParentDeptId().equals(tHospitalDept.getId())){
                       tSonHospitalDeptIdList.add(hospitalDept.getDeptId());
                   }
                }
                if (A.isNotEmpty(tSonHospitalDeptIdList)){
                    TDeptExample tDeptExample = new TDeptExample();
                    TDeptExample.Criteria criteriaDept = tDeptExample.createCriteria();
                    criteriaDept.andIdIn(tSonHospitalDeptIdList);
                    criteriaDept.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
                    List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
                    if (A.isNotEmpty(tDeptList)){
                        tDeptVo.setTSonDeptVoList(TDeptVo.assemblyDataList(tDeptList));
                    }
                }
                tDeptVoList.add(tDeptVo);
            }
            tHospitalVo.setTParentDeptVoList(tDeptVoList);
        }
        return tHospitalVo;
    }

    public List<THospitalVo> assemblyDataList(List<THospital> tHospitalList){
        if (U.isBlank(tHospitalList)){
            return null;
        }
        List<THospitalVo> tHospitalVoList = new ArrayList<>();
        for (THospital tHospital : tHospitalList) {
            THospitalVo tHospitalVo = assemblyData(tHospital);
            if (U.isNotBlank(tHospitalVo)){
                tHospitalVoList.add(tHospitalVo);
            }
        }
        return tHospitalVoList;
    }
}
