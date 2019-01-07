package com.bben.samiservice.mapper.samiservice;

import com.bben.samiservice.model.samiservice.TDept;
import com.bben.samiservice.model.samiservice.TDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeptMapper {
    long countByExample(TDeptExample example);

    int deleteByExample(TDeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDept record);

    int insertSelective(TDept record);

    List<TDept> selectByExample(TDeptExample example);

    TDept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDept record, @Param("example") TDeptExample example);

    int updateByExample(@Param("record") TDept record, @Param("example") TDeptExample example);

    int updateByPrimaryKeySelective(TDept record);

    int updateByPrimaryKey(TDept record);
}