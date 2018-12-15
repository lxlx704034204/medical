package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TWard;
import com.bben.bedcard.vo.TWardVo;

import java.util.List;

public interface TWardService {

    /**
     * 查询所有病区
     * @return
     */
    List<TWardVo> findAll();

    /**
     * 根据病区Id查询角色信息
     * @param wardId
     * @return
     */
    TWardVo selectByPrimaryKey(Integer wardId);

    /**
     * 添加病区信息
     * @param record
     * @return
     */
    TWard insertSelective(TWard record);

    /**
     * 更新病区信息
     * @param record
     * @return
     */
    TWard updateByPrimarykey(TWard record);

    /**
     * 删除病区信息
     * @param wardId
     * @return
     */
    int deleteByPrimarykey(Integer wardId);


    /**
     * 根据条件查询病区
     * @param record
     * @return
     */
    List<TWardVo> selectByCondition(TWard record);

    /**
     * 根据条件查询病区
     * @param record
     * @return
     */
    List<TWard> selectListByCondition(TWard record);

    /**
     * 删除病区信息
     * @param record
     * @return
     */
    int deleteByRecord(TWard record);

}
