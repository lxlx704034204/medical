package com.bben.bedcard.service;

import com.bben.bedcard.dto.TNurseDto;
import com.bben.bedcard.model.bedcard.TNurse;
import com.bben.bedcard.vo.TNurseVo;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 15:42
 */
public interface TNurseService {

    /**
     * 根据主键查询护士信息
     * @param nurseId
     * @return
     */
    TNurseVo selectByPrimaryKey(Integer nurseId);


    /**
     * 添加护士信息
     * @param record
     * @return
     */
    TNurse insertSelective(TNurseDto record);

    /**
     * 更新护士信息
     * @param record
     * @return
     */
    TNurse updateByPrimarykey(TNurseDto record);

    /**
     * 删除护士信息
     * @param nurseId
     * @return
     */
    int deleteByPrimarykey(Integer nurseId);

    /**
     * 根据条件查询护士分页信息
     * @param record
     * @return
     */
    List<TNurseVo> selectByCondition(TNurse record);

    /**
     * 根据条件查询护士分页信息
     * @param record
     * @return
     */
    List<TNurse> selectListByCondition(TNurse record);


    /**
     * 根据条件删除信息
     * @param record
     * @return
     */
    int deleteByCondition(TNurse record);

}
