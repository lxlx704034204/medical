package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.THospital;
import com.bben.bedcard.model.bedcard.THospitalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THospitalMapper {
    long countByExample(THospitalExample example);

    int deleteByExample(THospitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THospital record);

    int insertSelective(THospital record);

    List<THospital> selectByExample(THospitalExample example);

    THospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THospital record, @Param("example") THospitalExample example);

    int updateByExample(@Param("record") THospital record, @Param("example") THospitalExample example);

    int updateByPrimaryKeySelective(THospital record);

    int updateByPrimaryKey(THospital record);
}