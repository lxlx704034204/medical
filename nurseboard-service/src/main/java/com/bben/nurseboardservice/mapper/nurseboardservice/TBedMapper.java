package com.bben.nurseboardservice.mapper.nurseboardservice;

import com.bben.nurseboardservice.model.nurseboardservice.TBed;
import com.bben.nurseboardservice.model.nurseboardservice.TBedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBedMapper {
    long countByExample(TBedExample example);

    int deleteByExample(TBedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBed record);

    int insertSelective(TBed record);

    List<TBed> selectByExample(TBedExample example);

    TBed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBed record, @Param("example") TBedExample example);

    int updateByExample(@Param("record") TBed record, @Param("example") TBedExample example);

    int updateByPrimaryKeySelective(TBed record);

    int updateByPrimaryKey(TBed record);
}