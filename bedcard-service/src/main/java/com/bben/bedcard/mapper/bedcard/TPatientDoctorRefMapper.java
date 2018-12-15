package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TPatientDoctorRef;
import com.bben.bedcard.model.bedcard.TPatientDoctorRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientDoctorRefMapper {
    long countByExample(TPatientDoctorRefExample example);

    int deleteByExample(TPatientDoctorRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientDoctorRef record);

    int insertSelective(TPatientDoctorRef record);

    List<TPatientDoctorRef> selectByExample(TPatientDoctorRefExample example);

    TPatientDoctorRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientDoctorRef record, @Param("example") TPatientDoctorRefExample example);

    int updateByExample(@Param("record") TPatientDoctorRef record, @Param("example") TPatientDoctorRefExample example);

    int updateByPrimaryKeySelective(TPatientDoctorRef record);

    int updateByPrimaryKey(TPatientDoctorRef record);
}