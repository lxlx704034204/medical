package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TBedCardMapper;
import com.bben.bedcard.model.bedcard.TBedCard;
import com.bben.bedcard.model.bedcard.TBedCardExample;
import com.bben.bedcard.service.TBedCardService;
import com.bben.bedcard.vo.TBedCardVo;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/9 15:11
 */
@Service(value = "TBedCardService")
public class TBedCardServiceImpl implements TBedCardService {

    @Autowired
    private TBedCardMapper tBedCardMapper;


    @Override
    public List<TBedCardVo> findAll() {
        List<TBedCard> tBedCardList = tBedCardMapper.selectByExample(null);
        if (A.isEmpty(tBedCardList)){
            return null;
        }
        return TBedCardVo.assemblyDataList(tBedCardList);
    }

    @Override
    public TBedCardVo selectByPrimaryKey(Integer bedCardId) {
        if (U.isBlank(bedCardId)){
            return null;
        }
        TBedCard tBedCard = tBedCardMapper.selectByPrimaryKey(bedCardId);
        if (U.isBlank(tBedCard)){
            return null;
        }
        return TBedCardVo.assemblyData(tBedCard);
    }

    @Override
    public TBedCard insertSelective(TBedCard record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setCreateTime(new Date());
        int count = tBedCardMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TBedCard updateByPrimarykey(TBedCard record) {
        if (U.isBlank(record)){
            return null;
        }
        record.setUpdateTime(new Date());
        int count = tBedCardMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer bedCardId) {
        return tBedCardMapper.deleteByPrimaryKey(bedCardId);
    }

    @Override
    public List<TBedCardVo> selectByCondition(TBedCard record) {
        TBedCardExample tBedCardExample = new TBedCardExample();
        TBedCardExample.Criteria criteria = tBedCardExample.createCriteria();
        if (U.isNotBlank(record.getCode())){
            criteria.andCodeEqualTo(record.getCode());
        }
        if (U.isNotBlank(record.getName())){
            criteria.andNameEqualTo(record.getName());
        }
        if (U.isNotBlank(record.getType())){
            criteria.andTypeEqualTo(record.getType());
        }
        if (U.isNotBlank(record.getIp())){
            criteria.andIpEqualTo(record.getIp());
        }
        if (U.isNotBlank(record.getIsUsed())){
            criteria.andIsUsedEqualTo(record.getIsUsed());
        }
        if (U.isNotBlank(record.getSoftVersion())){
            criteria.andSoftVersionEqualTo(record.getSoftVersion());
        }
        if (U.isNotBlank(record.getStatus())){
            criteria.andStatusEqualTo(record.getStatus());
        }
        List<TBedCard> tBedCardList = tBedCardMapper.selectByExample(tBedCardExample);
        if (A.isEmpty(tBedCardList)){
            return null;
        }
        return TBedCardVo.assemblyDataList(tBedCardList);
    }
}
