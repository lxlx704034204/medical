package com.bben.bedcard.service.impl;

import com.bben.bedcard.dto.THospitalDeptDto;
import com.bben.bedcard.mapper.bedcard.TDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalDeptMapper;
import com.bben.bedcard.mapper.bedcard.THospitalMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.THospitalDeptService;
import com.bben.bedcard.vo.THospitalDeptVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 14:43
 */
@Service(value = "THospitalDeptService")
public class THospitalDeptServiceImpl implements THospitalDeptService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private THospitalDeptMapper tHospitalDeptMapper;

    @Autowired
    private TDeptMapper tDeptMapper;

    @Autowired
    private THospitalMapper tHospitalMapper;

    @Override
    public List<THospitalDeptVo> findAll() {
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(null);
        if (A.isEmpty(tHospitalDeptList)){
            return null;
        }
        return THospitalDeptVo.assemblyDataList(tHospitalDeptList);
    }

    @Override
    public THospitalDeptVo selectByPrimaryKey(Integer hospitalDeptId) {
        if (U.isBlank(hospitalDeptId)){
            return null;
        }
        THospitalDept tHospitalDept = tHospitalDeptMapper.selectByPrimaryKey(hospitalDeptId);
        if (U.isBlank(tHospitalDept)){
            return null;
        }
        return THospitalDeptVo.assemblyData(tHospitalDept);
    }

    @Override
    public THospitalDept insertSelective(THospitalDept record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tHospitalDeptMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public THospitalDept updateByPrimarykey(THospitalDeptDto record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId())){
            return null;
        }
        THospitalDept tHospitalDept = selectHospitalDeptByDataId(record.getDataId());
        if (U.isBlank(tHospitalDept)){
            return null;
        }
        THospitalDept tHospitalDept1 = THospitalDeptDto.assemblyData(record);
        if (U.isNotBlank(record.getDeptDataId())){
            TDept tDept = selectDeptByDataId(record.getDeptDataId());
            if (U.isBlank(tDept)){
                log.info("没有科室数据");
                return null;
            }
            tHospitalDept1.setDeptId(tDept.getId());
            if (U.isNotBlank(record.getParentDeptIDataid())){
                TDept tParentDept = selectDeptByDataId(record.getParentDeptIDataid());
                if (U.isBlank(tParentDept)){
                    tHospitalDept1.setParentDeptId(tDept.getId());
                }else {
                    tHospitalDept1.setParentDeptId(tParentDept.getId());
                }
            }
        }

        tHospitalDept1.setId(tHospitalDept.getId());
        int count = tHospitalDeptMapper.updateByPrimaryKeySelective(tHospitalDept1);
        if (0 == count){
            return null;
        }
        return tHospitalDept1;
    }

    @Override
    public int deleteByPrimarykey(Integer hospitalDeptId) {
        if (U.isBlank(hospitalDeptId)){
            return 0;
        }
        return tHospitalDeptMapper.deleteByPrimaryKey(hospitalDeptId);
    }

    @Override
    public List<THospitalDeptVo> selectByCondition(THospitalDept record) {
        THospitalDeptExample tHospitalDeptExample = new THospitalDeptExample();
        THospitalDeptExample.Criteria criteria = tHospitalDeptExample.createCriteria();
        if (U.isNotBlank(record.getDeptId())){
            criteria.andDeptIdEqualTo(record.getDeptId());
        }
        if (U.isNotBlank(record.getHospitalId())){
            criteria.andHospitalIdEqualTo(record.getHospitalId());
        }
        if (U.isNotBlank(record.getParentDeptId())){
            criteria.andParentDeptIdEqualTo(record.getParentDeptId());
        }
        if (U.isNotBlank(record.getDeptAddress())){
            criteria.andDeptAddressLike(record.getDeptAddress());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionEqualTo(record.getDescription());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(tHospitalDeptExample);
        if (A.isEmpty(tHospitalDeptList)){
            return null;
        }
        return THospitalDeptVo.assemblyDataList(tHospitalDeptList);
    }

    @Override
    public List<THospitalDept> selectListByCondition(THospitalDept record) {
        THospitalDeptExample tHospitalDeptExample = new THospitalDeptExample();
        THospitalDeptExample.Criteria criteria = tHospitalDeptExample.createCriteria();
        if (U.isNotBlank(record.getDeptId())){
            criteria.andDeptIdEqualTo(record.getDeptId());
        }
        if (U.isNotBlank(record.getHospitalId())){
            criteria.andHospitalIdEqualTo(record.getHospitalId());
        }
        if (U.isNotBlank(record.getParentDeptId())){
            criteria.andParentDeptIdEqualTo(record.getParentDeptId());
        }
        if (U.isNotBlank(record.getDeptAddress())){
            criteria.andDeptAddressLike(record.getDeptAddress());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionEqualTo(record.getDescription());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(tHospitalDeptExample);
        if (A.isEmpty(tHospitalDeptList)){
            return null;
        }
        return tHospitalDeptList;
    }

    @Override
    public THospitalDept insertSelectiveDto(THospitalDeptDto record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId()) || U.isBlank(record.getMessageId()) || U.isBlank(record.getHospitalDataId()) || U.isBlank(record.getDeptDataId()) || U.isBlank(record.getParentDeptIDataid())){
            return null;
        }
        TDept tDept = selectDeptByDataId(record.getDeptDataId());
        if (U.isBlank(tDept)){
            log.info("没有科室数据");
            return null;
        }
        record.setDeptId(tDept.getId());
        TDept tParentDept = selectDeptByDataId(record.getParentDeptIDataid());
        if (U.isBlank(tParentDept)){
            log.info("没有医院数据，默认1");
            record.setParentDeptId(tDept.getId());
        }else {
            record.setParentDeptId(tParentDept.getId());
        }
        THospitalExample tHospitalExample = new THospitalExample();
        THospitalExample.Criteria criteria = tHospitalExample.createCriteria();
        criteria.andDataIdEqualTo(record.getHospitalDataId());
        List<THospital> tHospitalList = tHospitalMapper.selectByExample(tHospitalExample);
        if (A.isEmpty(tHospitalList)){
            record.setHospitalId(1);
        }else {
            record.setHospitalId(tHospitalList.get(0).getId());
        }
        THospitalDept tHospitalDept = THospitalDeptDto.assemblyData(record);
        int count = tHospitalDeptMapper.insertSelective(tHospitalDept);
        if (0 == count){
            log.info("添加数据失败");
            return null;
        }
        return tHospitalDept;
    }

    @Override
    public int deleteByCondition(THospitalDept record) {
        if (U.isBlank(record)){
            return 0;
        }
        record.setStatus((byte) Status.INVALID.getStatus().intValue());
        return tHospitalDeptMapper.updateByPrimaryKeySelective(record);
    }

    private TDept selectDeptByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return A.first(tDeptList);
    }

    private THospitalDept selectHospitalDeptByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        THospitalDeptExample tHospitalDeptExample = new THospitalDeptExample();
        THospitalDeptExample.Criteria criteria = tHospitalDeptExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<THospitalDept> tHospitalDeptList = tHospitalDeptMapper.selectByExample(tHospitalDeptExample);
        if (A.isEmpty(tHospitalDeptList)){
            return null;
        }
        return A.first(tHospitalDeptList);
    }
}
