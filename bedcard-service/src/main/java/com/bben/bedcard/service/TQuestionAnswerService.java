package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.bedcard.vo.TQuestionAnswerVo;
import com.bben.common.PageInfo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 14:37
 */
public interface TQuestionAnswerService {

    /**
     * 查询所有答案
     * @return
     */
    List<TQuestionAnswerVo> findAll();

    /**
     * 根据答案Id查询角色信息
     * @param questionAnswerId
     * @return
     */
    TQuestionAnswerVo selectByPrimaryKey(Integer questionAnswerId);

    /**
     * 添加答案信息
     * @param record
     * @return
     */
    TQuestionAnswer insertSelective(TQuestionAnswer record);

    /**
     * 更新答案信息
     * @param record
     * @return
     */
    TQuestionAnswer updateByPrimarykey(TQuestionAnswer record);

    /**
     * 删除答案信息
     * @param questionAnswerId
     * @return
     */
    int deleteByPrimarykey(Integer questionAnswerId);

    /**
     * 根据分页查询答案信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TQuestionAnswerVo> selectByPage(int pageNum, int pageSize);

    /**
     * 根据条件查询答案
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TQuestionAnswerVo> selectByCondition(TQuestionAnswer record,int pageNum,int pageSize);
}
