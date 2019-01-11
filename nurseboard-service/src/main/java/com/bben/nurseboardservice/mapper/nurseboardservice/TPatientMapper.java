package com.bben.nurseboardservice.mapper.nurseboardservice;

import com.bben.nurseboardservice.model.nurseboardservice.TPatient;
import com.bben.nurseboardservice.model.nurseboardservice.TPatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientMapper {
    long countByExample(TPatientExample example);

    int deleteByExample(TPatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatient record);

    int insertSelective(TPatient record);

    List<TPatient> selectByExample(TPatientExample example);

    TPatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByExample(@Param("record") TPatient record, @Param("example") TPatientExample example);

    int updateByPrimaryKeySelective(TPatient record);

    int updateByPrimaryKey(TPatient record);
}