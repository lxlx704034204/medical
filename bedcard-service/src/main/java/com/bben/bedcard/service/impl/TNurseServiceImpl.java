package com.bben.bedcard.service.impl;

import com.bben.bedcard.dto.TNurseDto;
import com.bben.bedcard.mapper.bedcard.TDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalMapper;
import com.bben.bedcard.mapper.bedcard.TNurseMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TNurseService;
import com.bben.bedcard.vo.TDeptVo;
import com.bben.bedcard.vo.TNurseVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 15:51
 */
@Service(value = "TNurseService")
public class TNurseServiceImpl implements TNurseService {

    @Autowired
    private TNurseMapper tNurseMapper;

    @Autowired
    private THospitalDeptMapper tHospitalDeptMapper;

    @Autowired
    private TDeptMapper tDeptMapper;

    @Autowired
    private THospitalMapper tHospitalMapper;

    @Override
    public TNurseVo selectByPrimaryKey(Integer nurseId) {
        if (U.isBlank(nurseId)){
            return null;
        }
        TNurse tNurse = tNurseMapper.selectByPrimaryKey(nurseId);
        return assemblyData(tNurse);
    }

    @Override
    public TNurse insertSelective(TNurseDto record) {
        if (U.isBlank(record) || U.isBlank(record.getHospitalDeptDataId()) || U.isBlank(record.getDataId()) || U.isBlank(record.getMessageId())){
            return null;
        }
        if (U.isBlank(record.getHospitalDataId())){
            record.setHospitalId(1);
        }else {
            THospital tHospital = selectTHospitalByDataId(record.getHospitalDataId());
            if (U.isBlank(tHospital)){
                record.setHospitalId(1);
            }else {
                record.setHospitalId(tHospital.getId());
            }
        }
        if (U.isBlank(record.getHospitalDeptDataId())){
            return null;
        }
        THospitalDept tHospitalDept = selectTHospitalDeptByDataId(record.getHospitalDeptDataId());
        if (U.isBlank(tHospitalDept)){
            return null;
        }
        record.setHospitalDeptId(tHospitalDept.getId());
        TNurse tNurse = TNurseDto.assemblyData(record);
        int count = tNurseMapper.insertSelective(tNurse);
        if (0 == count){
            return null;
        }
        return tNurse;
    }

    @Override
    public TNurse updateByPrimarykey(TNurseDto record) {
        if (U.isBlank(record)){
            return null;
        }
       if (U.isBlank(record.getHospitalId())){
           THospital tHospital = selectTHospitalByDataId(record.getHospitalDataId());
           if (U.isBlank(tHospital)){
               record.setHospitalId(1);
           }else {
               record.setHospitalId(tHospital.getId());
           }
       }

        if (U.isNotBlank(record.getHospitalDeptDataId())){
            THospitalDept tHospitalDept = selectTHospitalDeptByDataId(record.getHospitalDeptDataId());
            if (U.isBlank(tHospitalDept)){
                return null;
            }
            record.setHospitalDeptId(tHospitalDept.getId());
        }
        TNurse tNurse1 = selectTNurseByDataId(record.getDataId());
        TNurse tNurse = TNurseDto.assemblyData(record);
        tNurse.setId(tNurse1.getId());
        int count = tNurseMapper.updateByPrimaryKeySelective(tNurse);
        if (0 == count){
            return null;
        }
        return tNurse;
    }

    @Override
    public int deleteByPrimarykey(Integer nurseId) {
        if (U.isBlank(nurseId)){
            return 0;
        }
        return tNurseMapper.deleteByPrimaryKey(nurseId);
    }

    @Override
    public List<TNurseVo> selectByCondition(TNurse record) {
        TNurseExample tNurseExample = new TNurseExample();
        TNurseExample.Criteria criteria = tNurseExample.createCriteria();
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike("%"+record.getName()+"%");
        }
        List<TNurse> tNurseList = tNurseMapper.selectByExample(tNurseExample);
        if (A.isEmpty(tNurseList)){
            return null;
        }
        return TNurseVo.assemblyDataList(tNurseList);
    }

    @Override
    public List<TNurse> selectListByCondition(TNurse record) {
        TNurseExample tNurseExample = new TNurseExample();
        TNurseExample.Criteria criteria = tNurseExample.createCriteria();
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike("%"+record.getName()+"%");
        }
        List<TNurse> tNurseList = tNurseMapper.selectByExample(tNurseExample);
        if (A.isEmpty(tNurseList)){
            return null;
        }
        return tNurseList;
    }

    @Override
    public int deleteByCondition(TNurse record) {
        if (U.isBlank(record)){
            return 0;
        }
        record.setStatus((byte) Status.INVALID.getStatus().intValue());
        return tNurseMapper.updateByPrimaryKeySelective(record);
    }

    private TNurseVo assemblyData(TNurse tNurse){
        TNurseVo tNurseVo;
        if (U.isBlank(tNurse)){
            return null;
        }
        tNurseVo = TNurseVo.assemblyData(tNurse);
        if (U.isNotBlank(tNurse.getHospitalDeptId())){
            THospitalDept tHospitalDept = tHospitalDeptMapper.selectByPrimaryKey(tNurse.getHospitalDeptId());
            if (U.isNotBlank(tHospitalDept) || U.isNotBlank(tHospitalDept.getDeptId())){
                TDept tDept = tDeptMapper.selectByPrimaryKey(tHospitalDept.getDeptId());
                if (U.isNotBlank(tDept)){
                    tNurseVo.setTDeptVo(TDeptVo.assemblyData(tDept));
                }
            }
        }
        return tNurseVo;
    }

    private List<TNurseVo> assemblyDataList(List<TNurse> tNurseList){
        List<TNurseVo> tNurseVoList = new ArrayList<>();
        if (A.isEmpty(tNurseVoList)){
            return null;
        }
        for (TNurse tNurse : tNurseList) {
            TNurseVo tNurseVo = assemblyData(tNurse);
            tNurseVoList.add(tNurseVo);
        }
        return tNurseVoList;
    }

    private TNurse selectTNurseByDataId(String dataId){
        TNurseExample tNurseExample = new TNurseExample();
        TNurseExample.Criteria criteria = tNurseExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<TNurse> tNurseList = tNurseMapper.selectByExample(tNurseExample);
        if (A.isEmpty(tNurseList)){
            return null;
        }
        return A.first(tNurseList);
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
