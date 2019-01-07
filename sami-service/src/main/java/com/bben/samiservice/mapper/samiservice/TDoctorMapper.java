package com.bben.samiservice.mapper.samiservice;

import com.bben.samiservice.model.samiservice.TDoctor;
import com.bben.samiservice.model.samiservice.TDoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDoctorMapper {
    long countByExample(TDoctorExample example);

    int deleteByExample(TDoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDoctor record);

    int insertSelective(TDoctor record);

    List<TDoctor> selectByExample(TDoctorExample example);

    TDoctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDoctor record, @Param("example") TDoctorExample example);

    int updateByExample(@Param("record") TDoctor record, @Param("example") TDoctorExample example);

    int updateByPrimaryKeySelective(TDoctor record);

    int updateByPrimaryKey(TDoctor record);
}