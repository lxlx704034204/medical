package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TQuestionAnswerMapper;
import com.bben.bedcard.mapper.bedcard.TQuestionMapper;
import com.bben.bedcard.mapper.bedcard.TQuestionTypeMapper;
import com.bben.bedcard.mapper.bedcard.TUserQuestionnaireMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TQuestionService;
import com.bben.bedcard.vo.TQuestionAnswerVo;
import com.bben.bedcard.vo.TQuestionTypeVo;
import com.bben.bedcard.vo.TQuestionVo;
import com.bben.common.PageInfo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:41
 */
@Service(value = "TQuestionService")
public class TQuestionServiceImpl implements TQuestionService {

    @Autowired
    private TQuestionMapper tQuestionMapper;

    @Autowired
    private TQuestionTypeMapper tQuestionTypeMapper;

    @Autowired
    private TQuestionAnswerMapper tQuestionAnswerMapper;

    @Autowired
    private TUserQuestionnaireMapper tUserQuestionnaireMapper;

    @Override
    public List<TQuestionVo> findAll(Integer userId) {
        List<TQuestion> tQuestionList = tQuestionMapper.selectByExample(null);
        if (A.isEmpty(tQuestionList)){
            return null;
        }
        return assemblyDataList(tQuestionList,userId);
    }

    @Override
    public TQuestionVo selectByPrimaryKey(Integer questionId,Integer userId) {
        if (U.isBlank(questionId)){
            return null;
        }
        TQuestion tQuestion = tQuestionMapper.selectByPrimaryKey(questionId);
        if (U.isBlank(tQuestion)){
            return null;
        }
        return assemblyData(tQuestion,userId);
    }

    @Override
    public TQuestion insertSelective(TQuestion record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tQuestionMapper.insertSelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public TQuestion updateByPrimarykey(TQuestion record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tQuestionMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer questionId) {
        return tQuestionMapper.deleteByPrimaryKey(questionId);
    }

    @Override
    public PageInfo<TQuestionVo> selectByPage(Integer userId, int pageNum, int pageSize) {
        TQuestionExample tQuestionExample = new TQuestionExample();
        TQuestionExample.Criteria criteria = tQuestionExample.createCriteria();
        criteria.andQuestionTypeIdEqualTo(1);
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TQuestion> tQuestionList = tQuestionMapper.selectByExample(tQuestionExample);
        if (A.isEmpty(tQuestionList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TQuestionVo> tQuestionVoPageInfo = new PageInfo<>(assemblyDataList(tQuestionList,userId));
        return tQuestionVoPageInfo;
    }

    @Override
    public PageInfo<TQuestionVo> selectByCondition(Integer userId,TQuestion record, int pageNum, int pageSize) {
        TQuestionExample tQuestionExample = new TQuestionExample();
        TQuestionExample.Criteria criteria = tQuestionExample.createCriteria();
        if (U.isNotBlank(record.getName())){
            criteria.andNameLike(record.getName());
        }
        if (U.isNotBlank(record.getQuestionTypeId())){
            criteria.andQuestionTypeIdEqualTo(record.getQuestionTypeId());
        }
        if (U.isNotBlank(record.getControlType())){
            criteria.andControlTypeEqualTo(record.getControlType());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        tQuestionExample.setOrderByClause(" sort asc ");
        List<TQuestion> tQuestionList = tQuestionMapper.selectByExample(tQuestionExample);
        if (A.isEmpty(tQuestionList)){
            return null;
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TQuestionVo> tQuestionVoPageInfo = new PageInfo<>(assemblyDataList(tQuestionList,userId));
        return tQuestionVoPageInfo;
    }

    private TQuestionVo assemblyData(TQuestion tQuestion,Integer userId){
        if (U.isBlank(tQuestion)){
            return null;
        }
        TQuestionVo tQuestionVo = TQuestionVo.assemblyData(tQuestion);
        if (U.isNotBlank(tQuestion.getQuestionTypeId())){
            TQuestionType tQuestionType = tQuestionTypeMapper.selectByPrimaryKey(tQuestion.getQuestionTypeId());
            if (U.isNotBlank(tQuestionType)){
                tQuestionVo.setTQuestionTypeVo(TQuestionTypeVo.assemblyData(tQuestionType));
            }
        }
        TUserQuestionnaireExample tUserQuestionnaireExample = new TUserQuestionnaireExample();
        TUserQuestionnaireExample.Criteria criteriaUserQuestionnaire = tUserQuestionnaireExample.createCriteria();
        criteriaUserQuestionnaire.andUserIdEqualTo(userId);
        criteriaUserQuestionnaire.andQuestionIdEqualTo(tQuestion.getId());
        List<TUserQuestionnaire> tUserQuestionnaireList = tUserQuestionnaireMapper.selectByExample(tUserQuestionnaireExample);
        TQuestionAnswerExample tQuestionAnswerExample = new TQuestionAnswerExample();
        TQuestionAnswerExample.Criteria criteria = tQuestionAnswerExample.createCriteria();
        criteria.andQuestionIdEqualTo(tQuestion.getId());
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        tQuestionAnswerExample.setOrderByClause(" sort asc ");
        List<TQuestionAnswer> tQuestionAnswerList = tQuestionAnswerMapper.selectByExample(tQuestionAnswerExample);
        if (A.isNotEmpty(tQuestionAnswerList)){
            List<TQuestionAnswerVo> tQuestionAnswerVos = new ArrayList<>();
            for (TQuestionAnswer tQuestionAnswer : tQuestionAnswerList) {
                TQuestionAnswerVo tQuestionAnswerVo = TQuestionAnswerVo.assemblyData(tQuestionAnswer);
                for (TUserQuestionnaire tUserQuestionnaire : tUserQuestionnaireList) {
                    if (tQuestionAnswer.getId().equals(tUserQuestionnaire.getAnswerId())){
                        tQuestionAnswerVo.setIschoose(true);
                    }
                }
                tQuestionAnswerVos.add(tQuestionAnswerVo);
            }

            tQuestionVo.setTQuestionAnswerVoList(tQuestionAnswerVos);
        }
        return tQuestionVo;
    }

    private List<TQuestionVo> assemblyDataList(List<TQuestion> tQuestionList,Integer userId){
        if (A.isEmpty(tQuestionList)){
            return null;
        }
        List<TQuestionVo> tQuestionVoList = new ArrayList<>();
        for (TQuestion tQuestion : tQuestionList) {
            TQuestionVo tQuestionVo = assemblyData(tQuestion,userId);
            tQuestionVoList.add(tQuestionVo);
        }
        return tQuestionVoList;
    }
}
