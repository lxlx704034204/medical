package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TQuestionAnswerMapper;
import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.bedcard.model.bedcard.TQuestionAnswerExample;
import com.bben.bedcard.service.TQuestionAnswerService;
import com.bben.bedcard.vo.TQuestionAnswerVo;
import com.bben.common.PageInfo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 10:46
 */
@Service(value = "TQuestionAnswerService")
public class TQuestionAnswerServiceImpl implements TQuestionAnswerService {

    @Autowired
    private TQuestionAnswerMapper tQuestionAnswerMapper;

    @Override
    public List<TQuestionAnswerVo> findAll() {
        List<TQuestionAnswer> tQuestionAnswerList = tQuestionAnswerMapper.selectByExample(null);
        if (A.isEmpty(tQuestionAnswerList)){
            return null;
        }
        return TQuestionAnswerVo.assemblyDataList(tQuestionAnswerList);
    }

    @Override
    public TQuestionAnswerVo selectByPrimaryKey(Integer questionAnswerId) {
        if (U.isBlank(questionAnswerId)){
            return null;
        }
        TQuestionAnswer tQuestionAnswer = tQuestionAnswerMapper.selectByPrimaryKey(questionAnswerId);
        if (U.isBlank(tQuestionAnswer)){
            return null;
        }
        return TQuestionAnswerVo.assemblyData(tQuestionAnswer);
    }

    @Override
    public TQuestionAnswer insertSelective(TQuestionAnswer record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tQuestionAnswerMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TQuestionAnswer updateByPrimarykey(TQuestionAnswer record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tQuestionAnswerMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer questionAnswerId) {
        if (U.isBlank(questionAnswerId)){
            return 0;
        }
        return tQuestionAnswerMapper.deleteByPrimaryKey(questionAnswerId);
    }

    @Override
    public PageInfo<TQuestionAnswerVo> selectByPage(int pageNum, int pageSize) {
        List<TQuestionAnswer> TQuestionAnswerList  = tQuestionAnswerMapper.selectByExample(null);
        if (A.isEmpty(TQuestionAnswerList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TQuestionAnswerVo> tQuestionAnswerVoPageInfo = new PageInfo<>(TQuestionAnswerVo.assemblyDataList(TQuestionAnswerList));
        return tQuestionAnswerVoPageInfo;
    }

    @Override
    public PageInfo<TQuestionAnswerVo> selectByCondition(TQuestionAnswer record, int pageNum, int pageSize) {
        TQuestionAnswerExample tQuestionAnswerExample = new TQuestionAnswerExample();
        TQuestionAnswerExample.Criteria criteria = tQuestionAnswerExample.createCriteria();
        if (U.isNotBlank(record.getQuestionId())){
            criteria.andQuestionIdEqualTo(record.getQuestionId());
        }
        if (U.isNotBlank(record.getAnswerName())){
            criteria.andAnswerNameEqualTo(record.getAnswerName());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TQuestionAnswer> tQuestionAnswerList = tQuestionAnswerMapper.selectByExample(tQuestionAnswerExample);
        if (A.isEmpty(tQuestionAnswerList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TQuestionAnswerVo> tQuestionAnswerVoPageInfo = new PageInfo<>(TQuestionAnswerVo.assemblyDataList(tQuestionAnswerList));
        return tQuestionAnswerVoPageInfo;
    }

}
