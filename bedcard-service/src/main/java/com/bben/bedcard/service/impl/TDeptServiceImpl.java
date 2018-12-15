package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TDeptMapper;
import com.bben.bedcard.model.bedcard.TDept;
import com.bben.bedcard.model.bedcard.TDeptExample;
import com.bben.bedcard.service.TDeptService;
import com.bben.bedcard.vo.TDeptVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 13:49
 */
@Service(value = "TDeptService")
public class TDeptServiceImpl implements TDeptService {

    @Autowired
    private TDeptMapper tDeptMapper;

    @Override
    public List<TDeptVo> findAll() {
        List<TDept> tDeptList = tDeptMapper.selectByExample(null);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return TDeptVo.assemblyDataList(tDeptList);
    }

    @Override
    public TDeptVo selectByPrimaryKey(Integer deptId) {
        if (U.isBlank(deptId)){
            return null;
        }
        TDept tDept = tDeptMapper.selectByPrimaryKey(deptId);
        if (U.isBlank(tDept)){
            return null;
        }
        return TDeptVo.assemblyData(tDept);
    }

    @Override
    public TDept insertSelective(TDept record) {
        if (U.isBlank(record) || U.isBlank(record.getMessageId()) || U.isBlank(record.getDataId())){
            return null;
        }
        TDept tDept = selectByMessageId(record.getMessageId());
        if (U.isNotBlank(tDept)){
            return null;
        }
        int count = tDeptMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TDept updateByPrimarykey(TDept record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId()) || U.isBlank(record.getMessageId())){
            return null;
        }
        TDept tDept = selectByDateId(record.getDataId());
        if (U.isBlank(tDept)){
            return null;
        }
        record.setId(tDept.getId());
        int count = tDeptMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer deptId) {
        if (U.isBlank(deptId)){
            return 0;
        }
        return tDeptMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public List<TDeptVo> selectByCondition(TDept record) {
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike(record.getName());
        }
        if (U.isNotBlank(record.getIntro())){
            criteria.andIntroLike(record.getIntro());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionEqualTo(record.getDescription());
        }
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return TDeptVo.assemblyDataList(tDeptList);
    }

    @Override
    public List<TDept> selectListByCondition(TDept record) {
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike(record.getName());
        }
        if (U.isNotBlank(record.getIntro())){
            criteria.andIntroLike(record.getIntro());
        }
        if (U.isNotBlank(record.getDescription())){
            criteria.andDescriptionEqualTo(record.getDescription());
        }
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return tDeptList;
    }

    @Override
    public int deleteByCondition(TDept record) {
        if (U.isBlank(record)){
            return 0;
        }
        record.setStatus((byte) Status.INVALID.getStatus().intValue());
        return tDeptMapper.updateByPrimaryKeySelective(record);
    }

    private TDept selectByMessageId(String messageId){
        if (U.isBlank(messageId)){
            return null;
        }
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        criteria.andMessageIdEqualTo(messageId);
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return A.first(tDeptList);
    }

    private TDept selectByDateId(String dateId){
        if (U.isBlank(dateId)){
            return null;
        }
        TDeptExample tDeptExample = new TDeptExample();
        TDeptExample.Criteria criteria = tDeptExample.createCriteria();
        criteria.andDataIdEqualTo(dateId);
        List<TDept> tDeptList = tDeptMapper.selectByExample(tDeptExample);
        if (A.isEmpty(tDeptList)){
            return null;
        }
        return A.first(tDeptList);
    }
}
