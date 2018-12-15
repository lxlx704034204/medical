package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TSickroomMapper;
import com.bben.bedcard.model.bedcard.TSickroom;
import com.bben.bedcard.model.bedcard.TSickroomExample;
import com.bben.bedcard.service.TSickroomService;
import com.bben.bedcard.vo.TSickroomVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "TSickroomService")
public class TSickroomServiceImpl implements TSickroomService {

    @Autowired
    private TSickroomMapper tSickroomMapper;

    @Override
    public List<TSickroomVo> findAll() {
        List<TSickroom> tSickroomList = tSickroomMapper.selectByExample(null);
        if (A.isEmpty(tSickroomList)){
            return null;
        }
        return TSickroomVo.assemblyDataList(tSickroomList);
    }

    @Override
    public TSickroomVo selectByPrimaryKey(Integer sickroomId) {
        if (U.isBlank(sickroomId)){
            return null;
        }
        TSickroom tSickroom = tSickroomMapper.selectByPrimaryKey(sickroomId);
        if (U.isBlank(tSickroom)){
            return null;
        }
        return TSickroomVo.assemblyData(tSickroom);
    }

    @Override
    public TSickroom insertSelective(TSickroom record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tSickroomMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TSickroom updateByPrimarykey(TSickroom record) {
        if (U.isBlank(record) || U.isBlank(record.getDataId())){
            return null;
        }
        TSickroom tSickroom = selectSickroomByDataId(record.getDataId());
        if (U.isBlank(tSickroom)){
            return null;
        }
        record.setId(tSickroom.getId());
        record.setUpdateTime(new Date());
        int count = tSickroomMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer sickroomId) {
        if(U.isBlank(sickroomId)){
            return 0;
        }
        return tSickroomMapper.deleteByPrimaryKey(sickroomId);
    }

    @Override
    public List<TSickroomVo> selectByCondition(TSickroom record) {
        TSickroomExample tSickroomExample = new TSickroomExample();
        TSickroomExample.Criteria criteria = tSickroomExample.createCriteria();
        if (U.isNotBlank(record.getMessageId())){
            criteria.andMessageIdEqualTo(record.getMessageId());
        }
        if (U.isNotBlank(record.getDataId())){
            criteria.andDataIdEqualTo(record.getDataId());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TSickroom> tSickroomList = tSickroomMapper.selectByExample(tSickroomExample);
        if (A.isEmpty(tSickroomList)){
            return null;
        }
        return TSickroomVo.assemblyDataList(tSickroomList);
    }

    @Override
    public int deleteByRecord(TSickroom record) {
        if (U.isBlank(record)){
            return 0;
        }
        TSickroomExample tSickroomExample = new TSickroomExample();
        TSickroomExample.Criteria criteria = tSickroomExample.createCriteria();
        criteria.andDataIdEqualTo(record.getDataId());
        return tSickroomMapper.deleteByExample(tSickroomExample);
    }

    private TSickroom selectSickroomByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        TSickroomExample tSickroomExample = new TSickroomExample();
        TSickroomExample.Criteria criteria = tSickroomExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<TSickroom> tSickroomList = tSickroomMapper.selectByExample(tSickroomExample);
        if (A.isEmpty(tSickroomList)){
            return null;
        }
        return A.first(tSickroomList);
    }
}
