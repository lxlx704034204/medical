package com.bben.medical.service.impl;

import com.bben.common.PageInfo;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.mapper.medical.TMenuMapper;
import com.bben.medical.mapper.medical.TRoleMenuRefMapper;
import com.bben.medical.model.medical.*;
import com.bben.medical.service.TRoleMenuRefService;
import com.bben.medical.vo.TMenuVo;
import com.bben.medical.vo.TRoleMenuRefVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 17:53
 */
@Service(value = "TRoleMenuRefService")
public class TRoleMenuRefServiceImpl implements TRoleMenuRefService {

    @Autowired
    private TRoleMenuRefMapper tRoleMenuRefMapper;

    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public List<TRoleMenuRefVo> findAllTRoleMenuRef() {
        List<TRoleMenuRefVo> tRoleMenuRefVoList = new ArrayList<>();
        List<TRoleMenuRef> tRoleMenuRefList = tRoleMenuRefMapper.selectByExample(null);
        if (A.isEmpty(tRoleMenuRefList)){
            return null;
        }
        for (TRoleMenuRef tRoleMenuRef : tRoleMenuRefList) {
            TRoleMenuRefVo tRoleMenuRefVo = TRoleMenuRefVo.assemblyData(tRoleMenuRef);
            if (U.isNotBlank(tRoleMenuRef.getMenuId())){
                TMenu tMenu = tMenuMapper.selectByPrimaryKey(tRoleMenuRef.getMenuId());
                if (U.isNotBlank(tMenu)){
                    tRoleMenuRefVo.setTMenuVo(TMenuVo.assemblyData(tMenu));
                }
            }
            tRoleMenuRefVoList.add(tRoleMenuRefVo);
        }
        return tRoleMenuRefVoList;
    }

    @Override
    public TRoleMenuRefVo selectByPrimaryKey(Integer refId) {
        if (U.isBlank(refId)){
            return null;
        }
        TRoleMenuRef tRoleMenuRef = tRoleMenuRefMapper.selectByPrimaryKey(refId);
        if (U.isBlank(tRoleMenuRef)){
            return null;
        }
        TRoleMenuRefVo tRoleMenuRefVo = TRoleMenuRefVo.assemblyData(tRoleMenuRef);
        if (U.isNotBlank(tRoleMenuRef.getMenuId())){
            TMenu tMenu = tMenuMapper.selectByPrimaryKey(tRoleMenuRef.getMenuId());
            if (U.isNotBlank(tMenu)){
                tRoleMenuRefVo.setTMenuVo(TMenuVo.assemblyData(tMenu));
            }
        }
        return tRoleMenuRefVo;
    }

    @Override
    public TRoleMenuRef insertSelective(TRoleMenuRef record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setCreateTime(new Date());
        int count = tRoleMenuRefMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TRoleMenuRef updateByPrimarykey(TRoleMenuRef record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setUpdateTime(new Date());
        int count = tRoleMenuRefMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer refId) {
        return tRoleMenuRefMapper.deleteByPrimaryKey(refId);
    }

    @Override
    public PageInfo<TRoleMenuRefVo> selectByPage(int pageNum, int pageSize) {
        List<TRoleMenuRef> tRoleMenuRefList = tRoleMenuRefMapper.selectByExample(null);
        if (A.isEmpty(tRoleMenuRefList)){
            return null;
        }
        List<TRoleMenuRefVo> tRoleMenuRefVoList = assemblyData(tRoleMenuRefList);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TRoleMenuRefVo> tRoleMenuRefVoPageInfo = new PageInfo<>(tRoleMenuRefVoList);
        return tRoleMenuRefVoPageInfo;
    }

    @Override
    public PageInfo<TRoleMenuRefVo> selectByCondition(TRoleMenuRef record, int pageNum, int pageSize) {
        TRoleMenuRefExample tRoleMenuRefExample = new TRoleMenuRefExample();
        TRoleMenuRefExample.Criteria criteria = tRoleMenuRefExample.createCriteria();
        if (U.isNotBlank(record.getRoleId())){
            criteria.andRoleIdEqualTo(record.getRoleId());
        }
        if (U.isNotBlank(record.getMenuId())){
            criteria.andMenuIdEqualTo(record.getMenuId());
        }
        List<TRoleMenuRef> tRoleMenuRefList = tRoleMenuRefMapper.selectByExample(tRoleMenuRefExample);
        if (A.isEmpty(tRoleMenuRefList)){
            return null;
        }
        List<TRoleMenuRefVo> tRoleMenuRefVoList = assemblyData(tRoleMenuRefList);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TRoleMenuRefVo> tRoleMenuRefVoPageInfo = new PageInfo<>(tRoleMenuRefVoList);
        return tRoleMenuRefVoPageInfo;
    }

    /**
     * 数据转换
     * @param tRoleMenuRefList
     * @return
     */
    private List<TRoleMenuRefVo> assemblyData(List<TRoleMenuRef> tRoleMenuRefList){
        List<TRoleMenuRefVo> tRoleMenuRefVoList = new ArrayList<>();
        if (A.isEmpty(tRoleMenuRefList)){
            return tRoleMenuRefVoList;
        }
        for (TRoleMenuRef tRoleMenuRef : tRoleMenuRefList) {
            TRoleMenuRefVo tRoleMenuRefVo = TRoleMenuRefVo.assemblyData(tRoleMenuRef);
            if (U.isNotBlank(tRoleMenuRef.getMenuId())){
                TMenu tMenu = tMenuMapper.selectByPrimaryKey(tRoleMenuRef.getMenuId());
                tRoleMenuRefVo.setTMenuVo(TMenuVo.assemblyData(tMenu));
            }
            tRoleMenuRefVoList.add(tRoleMenuRefVo);
        }
        return tRoleMenuRefVoList;
    }
}
