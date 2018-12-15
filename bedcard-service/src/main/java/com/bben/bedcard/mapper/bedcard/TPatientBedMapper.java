package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TPatientBed;
import com.bben.bedcard.model.bedcard.TPatientBedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientBedMapper {
    long countByExample(TPatientBedExample example);

    int deleteByExample(TPatientBedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientBed record);

    int insertSelective(TPatientBed record);

    List<TPatientBed> selectByExample(TPatientBedExample example);

    TPatientBed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientBed record, @Param("example") TPatientBedExample example);

    int updateByExample(@Param("record") TPatientBed record, @Param("example") TPatientBedExample example);

    int updateByPrimaryKeySelective(TPatientBed record);

    int updateByPrimaryKey(TPatientBed record);
}