package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.bedcard.vo.TUserQuestionnaireVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/15 10:54
 */
public interface TUserQuestionnaireService {

    /**
     *  查询所有问题
     */
    List<TUserQuestionnaireVo> findAll();

    /**
     * 根据问题Id查询角色信息
     * @param questionId
     * @return
     */
    TUserQuestionnaireVo selectByPrimaryKey(Integer questionId);

    /**
     * 添加问题信息
     * @param questionAnswerIds
     * @return
     */
    int insertSelective(String questionAnswerIds,Integer userId);

    /**
     * 更新问题信息
     * @param record
     * @return
     */
    TUserQuestionnaire updateByPrimarykey(TUserQuestionnaire record);

    /**
     * 删除问题信息
     * @param userQuestionnaireId
     * @return
     */
    int deleteByPrimarykey(Integer userQuestionnaireId);

    /**
     * 根据条件查询问题
     * @param record
     * @return
     */
    List<TUserQuestionnaireVo> selectByCondition(TUserQuestionnaire record);

}
