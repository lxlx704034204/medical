package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TBedCard;
import com.bben.bedcard.vo.TBedCardVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/9 15:10
 */
public interface TBedCardService {

    /**
     * 查询所有床头卡
     * @return
     */
    List<TBedCardVo> findAll();

    /**
     * 根据主键查询床头卡
     * @param bedCardId
     * @return
     */
    TBedCardVo selectByPrimaryKey(Integer bedCardId);

    /**
     * 新增床头卡信息
     * @param record
     * @return
     */
    TBedCard insertSelective(TBedCard record);

    /**
     * 更新床头卡信息
     * @param record
     * @return
     */
    TBedCard updateByPrimarykey(TBedCard record);

    /**
     * 删除床头卡信息
     * @param bedCardId
     * @return
     */
    int deleteByPrimarykey(Integer bedCardId);

    /**
     *  根据讲条件查询床头卡信息
     * @param record
     * @return
     */
    List<TBedCardVo> selectByCondition(TBedCard record);

}
