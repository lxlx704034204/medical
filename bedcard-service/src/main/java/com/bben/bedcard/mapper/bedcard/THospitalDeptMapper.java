package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.THospitalDept;
import com.bben.bedcard.model.bedcard.THospitalDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalDeptMapper {
    long countByExample(THospitalDeptExample example);

    int deleteByExample(THospitalDeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THospitalDept record);

    int insertSelective(THospitalDept record);

    List<THospitalDept> selectByExample(THospitalDeptExample example);

    THospitalDept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THospitalDept record, @Param("example") THospitalDeptExample example);

    int updateByExample(@Param("record") THospitalDept record, @Param("example") THospitalDeptExample example);

    int updateByPrimaryKeySelective(THospitalDept record);

    int updateByPrimaryKey(THospitalDept record);
}