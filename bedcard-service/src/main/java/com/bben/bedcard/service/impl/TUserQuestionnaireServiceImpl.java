package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TQuestionAnswerMapper;
import com.bben.bedcard.mapper.bedcard.TUserQuestionnaireMapper;
import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.bedcard.model.bedcard.TQuestionAnswerExample;
import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.bedcard.model.bedcard.TUserQuestionnaireExample;
import com.bben.bedcard.service.TUserQuestionnaireService;
import com.bben.bedcard.vo.TUserQuestionnaireVo;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/15 11:17
 */
@Service(value = "TUserQuestionnaireService")
public class TUserQuestionnaireServiceImpl implements TUserQuestionnaireService {

    @Autowired
    private TUserQuestionnaireMapper tUserQuestionnaireMapper;

    @Autowired
    private TQuestionAnswerMapper tQuestionAnswerMapper;

    private static final Logger log = LoggerFactory.getLogger(TUserQuestionnaireServiceImpl.class);

    @Override
    public List<TUserQuestionnaireVo> findAll() {
        List<TUserQuestionnaire> tUserQuestionnaireList = tUserQuestionnaireMapper.selectByExample(null);
        if (A.isEmpty(tUserQuestionnaireList)){
            return null;
        }
        return TUserQuestionnaireVo.assemblyDataList(tUserQuestionnaireList);
    }

    @Override
    public TUserQuestionnaireVo selectByPrimaryKey(Integer userQuestionnaireId) {
        if (U.isBlank(userQuestionnaireId)){
            return null;
        }
        TUserQuestionnaire tUserQuestionnaire = tUserQuestionnaireMapper.selectByPrimaryKey(userQuestionnaireId);
        if (U.isBlank(tUserQuestionnaire)){
            return null;
        }

        return TUserQuestionnaireVo.assemblyData(tUserQuestionnaire);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertSelective(String questionAnswerIds,Integer userId) {
        if (U.isBlank(questionAnswerIds) || U.isBlank(userId)){
            return 0;
        }
        try {
            List<Integer> answerIdInts = new ArrayList<>();
            List<TQuestionAnswer> tQuestionAnswerList = new ArrayList<>();
            String [] answerIdStr = questionAnswerIds.split(",");
            if (U.isNotBlank(answerIdStr)){
                for (String s : answerIdStr) {
                    answerIdInts.add(Integer.valueOf(s));
                }
            }
            TQuestionAnswerExample tQuestionAnswerExample = new TQuestionAnswerExample();
            TQuestionAnswerExample.Criteria criteria = tQuestionAnswerExample.createCriteria();
            if (A.isNotEmpty(answerIdInts)){
                criteria.andIdIn(answerIdInts);
                tQuestionAnswerList = tQuestionAnswerMapper.selectByExample(tQuestionAnswerExample);
            }
            if (A.isEmpty(tQuestionAnswerList)){
                return 0;
            }
            TUserQuestionnaireExample tUserQuestionnaireExample = new TUserQuestionnaireExample();
            TUserQuestionnaireExample.Criteria criteriaUserQuestionnaire = tUserQuestionnaireExample.createCriteria();
            criteriaUserQuestionnaire.andUserIdEqualTo(userId);
            int deleteUserQuestion = tUserQuestionnaireMapper.deleteByExample(tUserQuestionnaireExample);
            log.info("删除用户调查问卷"+deleteUserQuestion+"条");
            for (TQuestionAnswer tQuestionAnswer : tQuestionAnswerList) {
                TUserQuestionnaire tUserQuestionnaire = new TUserQuestionnaire();
                tUserQuestionnaire.setQuestionId(tQuestionAnswer.getQuestionId());
                tUserQuestionnaire.setAnswerId(tQuestionAnswer.getId());
                tUserQuestionnaire.setUserId(userId);
                tUserQuestionnaire.setCreateTime(new Date());
                int count = tUserQuestionnaireMapper.insertSelective(tUserQuestionnaire);
                if (0 == count){
                    throw new RuntimeException();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public TUserQuestionnaire updateByPrimarykey(TUserQuestionnaire record) {
        if (U.isBlank(record)){
            return null;
        }
        int count = tUserQuestionnaireMapper.updateByPrimaryKeySelective(record);
        if (0 == count){
            return null;
        }
        return record;
    }

    @Override
    public int deleteByPrimarykey(Integer userQuestionnaireId) {
        if (U.isBlank(userQuestionnaireId)){
            return 0;
        }
        return tUserQuestionnaireMapper.deleteByPrimaryKey(userQuestionnaireId);
    }

    @Override
    public List<TUserQuestionnaireVo> selectByCondition(TUserQuestionnaire record) {
        TUserQuestionnaireExample tUserQuestionnaireExample = new TUserQuestionnaireExample();
        TUserQuestionnaireExample.Criteria criteria = tUserQuestionnaireExample.createCriteria();
        if (U.isNotBlank(record.getQuestionId())){
            criteria.andQuestionIdEqualTo(record.getQuestionId());
        }
        if (U.isNotBlank(record.getAnswerId())){
            criteria.andAnswerIdEqualTo(record.getAnswerId());
        }
        if (U.isNotBlank(record.getUserId())){
            criteria.andUserIdEqualTo(record.getUserId());
        }
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TUserQuestionnaire> tUserQuestionnaireList = tUserQuestionnaireMapper.selectByExample(tUserQuestionnaireExample);
        return TUserQuestionnaireVo.assemblyDataList(tUserQuestionnaireList);
    }
}
