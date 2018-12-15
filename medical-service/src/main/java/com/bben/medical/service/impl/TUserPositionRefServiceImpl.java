package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TPositionMapper;
import com.bben.medical.mapper.medical.TUserPositionRefMapper;
import com.bben.medical.model.medical.TPosition;
import com.bben.medical.model.medical.TUserPositionRef;
import com.bben.medical.model.medical.TUserPositionRefExample;
import com.bben.medical.service.TUserPositionRefService;
import com.bben.medical.vo.TPositionVo;
import com.bben.medical.vo.TUserPositionRefVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 16:58
 */
@Service(value = "TUserPositionRefService")
public class TUserPositionRefServiceImpl implements TUserPositionRefService {

    @Autowired
    private TUserPositionRefMapper tUserPositionRefMapper;

    @Autowired
    private TPositionMapper tPositionMapper;

    @Override
    public List<TUserPositionRefVo> findAll() {
        List<TUserPositionRef> tUserPositionRefList = tUserPositionRefMapper.selectByExample(null);
        if (U.isBlank(tUserPositionRefList)){
            return null;
        }
        return assemblyDataList(tUserPositionRefList);
    }

    @Override
    public TUserPositionRefVo selectByPrimaryKey(Integer refId) {
        if (U.isBlank(refId)){
            return null;
        }
        TUserPositionRef tUserPositionRef = tUserPositionRefMapper.selectByPrimaryKey(refId);
        if (U.isBlank(tUserPositionRef)){
            return null;
        }
        return assemblyData(tUserPositionRef);
    }

    @Override
    public TUserPositionRef insertSelective(TUserPositionRef record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setCreateTime(new Date());
        int count = tUserPositionRefMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TUserPositionRef updateByPrimarykey(TUserPositionRef record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setUpdateTime(new Date());
        int count = tUserPositionRefMapper.updateByPrimaryKeySelective(record);
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
        return tUserPositionRefMapper.deleteByPrimaryKey(refId);
    }

    @Override
    public PageInfo<TUserPositionRefVo> selectByPage(int pageNum, int pageSize) {
        List<TUserPositionRef> tUserPositionRefList = tUserPositionRefMapper.selectByExample(null);
        if (A.isEmpty(tUserPositionRefList)){
            return null;
        }
        PageInfo<TUserPositionRefVo> tUserPositionRefVoPageInfo = new PageInfo<>(assemblyDataList(tUserPositionRefList));
        return tUserPositionRefVoPageInfo;
    }

    @Override
    public PageInfo<TUserPositionRefVo> selectByCondition(TUserPositionRef record, int pageNum, int pageSize) {
        TUserPositionRefExample tUserPositionRefExample = new TUserPositionRefExample();
        TUserPositionRefExample.Criteria criteria = tUserPositionRefExample.createCriteria();
        if (U.isNotBlank(record.getUserId())){
            criteria.andUserIdEqualTo(record.getUserId());
        }
        if (U.isNotBlank(record.getPositionId())){
            criteria.andPositionIdEqualTo(record.getPositionId());
        }
        List<TUserPositionRef> tUserPositionRefList = tUserPositionRefMapper.selectByExample(tUserPositionRefExample);
        if (A.isEmpty(tUserPositionRefList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TUserPositionRefVo> tUserPositionRefVoPageInfo = new PageInfo<>(assemblyDataList(tUserPositionRefList));
        return tUserPositionRefVoPageInfo;
    }

    /**
     * 数据转换
     * @param tUserPositionRef
     * @return
     */
    private TUserPositionRefVo assemblyData(TUserPositionRef tUserPositionRef){
        if (U.isBlank(tUserPositionRef)){
            return null;
        }
        TUserPositionRefVo tUserPositionRefVo = TUserPositionRefVo.assemblyData(tUserPositionRef);
        if (U.isNotBlank(tUserPositionRef.getPositionId())){
            TPosition tPosition = tPositionMapper.selectByPrimaryKey(tUserPositionRef.getPositionId());
            tUserPositionRefVo.setTPositionVo(TPositionVo.assemblyData(tPosition));
        }
        return tUserPositionRefVo;
    }

    /**
     * List数据转换
     * @param tUserPositionRefList
     * @return
     */
    private List<TUserPositionRefVo> assemblyDataList(List<TUserPositionRef> tUserPositionRefList){
        List<TUserPositionRefVo> tUserPositionRefVoList = new ArrayList<>();
        if (A.isEmpty(tUserPositionRefList)){
            return tUserPositionRefVoList;
        }
        for (TUserPositionRef tUserPositionRef : tUserPositionRefList) {
            TUserPositionRefVo tUserPositionRefVo = assemblyData(tUserPositionRef);
            tUserPositionRefVoList.add(tUserPositionRefVo);
        }
        return tUserPositionRefVoList;
    }
}
