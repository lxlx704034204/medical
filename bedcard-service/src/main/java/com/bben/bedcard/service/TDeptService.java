package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TDept;
import com.bben.bedcard.vo.TDeptVo;

import java.util.List;

/**
 * 科室接口
 * @Author: Lizhenwei
 * @Date: 2018/11/16 13:44
 */
public interface TDeptService {

    /**
     * 查询所有信息
     * @return
     */
    List<TDeptVo> findAll();

    /**
     * 根据主键查询信息
     * @param deptId
     * @return
     */
    TDeptVo selectByPrimaryKey(Integer deptId);

    /**
     * 添加信息
     * @param record
     * @return
     */
    TDept insertSelective(TDept record);

    /**
     * 更新信息
     * @param record
     * @return
     */
    TDept updateByPrimarykey(TDept record);

    /**
     * 删除信息
     * @param deptId
     * @return
     */
    int deleteByPrimarykey(Integer deptId);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<TDeptVo> selectByCondition(TDept record);

    /**
     * 根据条件查询分页信息
     * @param record
     * @return
     */
    List<TDept> selectListByCondition(TDept record);

    /**
     * 根据条件删除信息
     * @param record
     * @return
     */
    int deleteByCondition(TDept record);
}
