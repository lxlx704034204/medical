package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TWardMapper;
import com.bben.bedcard.model.bedcard.TWard;
import com.bben.bedcard.model.bedcard.TWardExample;
import com.bben.bedcard.service.TWardService;
import com.bben.bedcard.vo.TWardVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "TWardService")
public class TWardServiceImpl implements TWardService {

    @Autowired
    private TWardMapper tWardMapper;

    @Override
    public List<TWardVo> findAll() {
        List<TWard> tWardList = tWardMapper.selectByExample(null);
        if (A.isEmpty(tWardList)){
            return null;
        }
        return TWardVo.assemblyDataList(tWardList);
    }

    @Override
    public TWardVo selectByPrimaryKey(Integer wardId) {
        if (U.isBlank(wardId)){
            return null;
        }
        TWard tWard = tWardMapper.selectByPrimaryKey(wardId);
        if (U.isBlank(tWard)){
            return null;
        }
        return TWardVo.assemblyData(tWard);
    }

    @Override
    public TWard insertSelective(TWard record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tWardMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TWard updateByPrimarykey(TWard record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId())){
            return null;
        }
        TWard tWard = selectWardByDataId(record.getDataId());
        if (U.isBlank(tWard)){
            return null;
        }
        record.setId(tWard.getId());
        record.setUpdateTime(new Date());
        int count = tWardMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer wardId) {
        if(U.isBlank(wardId)){
            return 0;
        }
        return tWardMapper.deleteByPrimaryKey(wardId);
    }

    @Override
    public List<TWardVo> selectByCondition(TWard record) {
        TWardExample tWardExample = new TWardExample();
        TWardExample.Criteria criteria = tWardExample.createCriteria();
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike("%"+record.getName()+"%");
        }
        if (U.isNotBlank(record.getPosition())){
            criteria.andPositionLike("%"+record.getPosition()+"%");
        }
        if (U.isNotBlank(record.getDutyBy())){
            criteria.andDutyByEqualTo(record.getDutyBy());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TWard> tWardList = tWardMapper.selectByExample(tWardExample);
        if (A.isEmpty(tWardList)){
            return null;
        }
        return TWardVo.assemblyDataList(tWardList);
    }

    @Override
    public List<TWard> selectListByCondition(TWard record) {
        TWardExample tWardExample = new TWardExample();
        TWardExample.Criteria criteria = tWardExample.createCriteria();
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike("%"+record.getName()+"%");
        }
        if (U.isNotBlank(record.getPosition())){
            criteria.andPositionLike("%"+record.getPosition()+"%");
        }
        if (U.isNotBlank(record.getDutyBy())){
            criteria.andDutyByEqualTo(record.getDutyBy());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TWard> tWardList = tWardMapper.selectByExample(tWardExample);
        if (A.isEmpty(tWardList)){
            return null;
        }
        return tWardList;
    }

    @Override
    public int deleteByRecord(TWard record) {
        record.setStatus((byte) Status.INVALID.getStatus().intValue());
        record.setUpdateTime(new Date());
        int count = tWardMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return 0;
        }
        return 1;

    }

    private TWard selectWardByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        TWardExample tWardExample = new TWardExample();
        TWardExample.Criteria criteria = tWardExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<TWard> tWardList = tWardMapper.selectByExample(tWardExample);
        if (A.isEmpty(tWardList)){
            return null;
        }
        return A.first(tWardList);
    }
}
