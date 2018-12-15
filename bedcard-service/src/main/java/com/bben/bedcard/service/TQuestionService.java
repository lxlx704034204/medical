package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TQuestion;
import com.bben.bedcard.vo.TQuestionVo;
import com.bben.common.PageInfo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:36
 */
public interface TQuestionService {

    /**
     * 查询所有问题
     * @param userId
     * @return
     */
    List<TQuestionVo> findAll(Integer userId);

    /**
     * 根据问题Id查询角色信息
     * @param questionId
     * @param userId
     * @return
     */
    TQuestionVo selectByPrimaryKey(Integer questionId,Integer userId);

    /**
     * 添加问题信息
     * @param record
     * @return
     */
    TQuestion insertSelective(TQuestion record);

    /**
     * 更新问题信息
     * @param record
     * @return
     */
    TQuestion updateByPrimarykey(TQuestion record);

    /**
     * 删除问题信息
     * @param questionId
     * @return
     */
    int deleteByPrimarykey(Integer questionId);

    /**
     * 根据分页查询问题信息
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TQuestionVo> selectByPage(Integer userId,int pageNum, int pageSize);

    /**
     * 根据条件查询问题
     * @param userId
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TQuestionVo> selectByCondition(Integer userId,TQuestion record,int pageNum,int pageSize);
}
