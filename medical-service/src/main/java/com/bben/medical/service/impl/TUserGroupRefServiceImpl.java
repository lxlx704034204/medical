package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TGroupMapper;
import com.bben.medical.mapper.medical.TUserGroupRefMapper;
import com.bben.medical.model.medical.TGroup;
import com.bben.medical.model.medical.TUserGroupRef;
import com.bben.medical.model.medical.TUserGroupRefExample;
import com.bben.medical.service.TUserGroupRefService;
import com.bben.medical.vo.TGroupVo;
import com.bben.medical.vo.TUserGroupRefVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 11:50
 */
@Service("TUserGroupRefService")
public class TUserGroupRefServiceImpl implements TUserGroupRefService {

    @Autowired
    private TUserGroupRefMapper tUserGroupRefMapper;

    @Autowired
    private TGroupMapper tGroupMapper;

    @Override
    public List<TUserGroupRefVo> findAll() {
        List<TUserGroupRef> tUserGroupRefList = tUserGroupRefMapper.selectByExample(null);
        if (A.isEmpty(tUserGroupRefList)){
            return null;
        }
        return assemblyDataList(tUserGroupRefList);
    }

    @Override
    public TUserGroupRefVo selectByPrimaryKey(Integer refId) {
        if (U.isBlank(refId)){
            return null;
        }
        TUserGroupRef tUserGroupRef = tUserGroupRefMapper.selectByPrimaryKey(refId);
        return assemblyData(tUserGroupRef);
    }

    @Override
    public TUserGroupRef insertSelective(TUserGroupRef record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tUserGroupRefMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TUserGroupRef updateByPrimarykey(TUserGroupRef record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tUserGroupRefMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer refId) {
        if (U.isBlank(refId)){
            return 0;
        }
        return tUserGroupRefMapper.deleteByPrimaryKey(refId);
    }

    @Override
    public PageInfo<TUserGroupRefVo> selectByPage(int pageNum, int pageSize) {
        List<TUserGroupRef> tUserGroupRefList = tUserGroupRefMapper.selectByExample(null);
        if (A.isEmpty(tUserGroupRefList)){
            return null;
        }
        List<TUserGroupRefVo> tUserGroupRefVoList = assemblyDataList(tUserGroupRefList);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TUserGroupRefVo> tUserGroupRefVoPageInfo = new PageInfo<>(tUserGroupRefVoList);
        return tUserGroupRefVoPageInfo;
    }

    @Override
    public PageInfo<TUserGroupRefVo> selectByCondition(TUserGroupRef record, int pageNum, int pageSize) {
        TUserGroupRefExample tUserGroupRefExample = new TUserGroupRefExample();
        TUserGroupRefExample.Criteria criteria = tUserGroupRefExample.createCriteria();
        if (U.isNotBlank(record.getGroupId())){
            criteria.andGroupIdEqualTo(record.getGroupId());
        }
        if (U.isNotBlank(record.getUserId())){
            criteria.andUserIdEqualTo(record.getUserId());
        }
        List<TUserGroupRef> tUserGroupRefList = tUserGroupRefMapper.selectByExample(tUserGroupRefExample);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TUserGroupRefVo> tUserGroupRefVoPageInfo = new PageInfo<>(assemblyDataList(tUserGroupRefList));
        return tUserGroupRefVoPageInfo;
    }

    /**
     * 数据转换
     * @param tUserGroupRef
     * @return
     */
    private TUserGroupRefVo assemblyData(TUserGroupRef tUserGroupRef){
        if (U.isBlank(tUserGroupRef)){
            return null;
        }
        TUserGroupRefVo tUserGroupRefVo = TUserGroupRefVo.assemblyData(tUserGroupRef);
        if (U.isNotBlank(tUserGroupRef.getGroupId())){
            TGroup tGroup = tGroupMapper.selectByPrimaryKey(tUserGroupRef.getGroupId());
            tUserGroupRefVo.setTGroupVo(TGroupVo.assemblyData(tGroup));
        }
        return tUserGroupRefVo;
    }

    /**
     * List数据转换
     * @param tUserGroupRefList
     * @return
     */
    private List<TUserGroupRefVo> assemblyDataList(List<TUserGroupRef> tUserGroupRefList){
        List<TUserGroupRefVo> tUserGroupRefVoList = new ArrayList<>();
        if (A.isEmpty(tUserGroupRefList)){
            return tUserGroupRefVoList;
        }
        for (TUserGroupRef tUserGroupRef : tUserGroupRefList) {
            TUserGroupRefVo tUserGroupRefVo = assemblyData(tUserGroupRef);
            tUserGroupRefVoList.add(tUserGroupRefVo);
        }
        return tUserGroupRefVoList;
    }
}
