package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TPatientNurseRef;
import com.bben.bedcard.model.bedcard.TPatientNurseRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientNurseRefMapper {
    long countByExample(TPatientNurseRefExample example);

    int deleteByExample(TPatientNurseRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientNurseRef record);

    int insertSelective(TPatientNurseRef record);

    List<TPatientNurseRef> selectByExample(TPatientNurseRefExample example);

    TPatientNurseRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientNurseRef record, @Param("example") TPatientNurseRefExample example);

    int updateByExample(@Param("record") TPatientNurseRef record, @Param("example") TPatientNurseRefExample example);

    int updateByPrimaryKeySelective(TPatientNurseRef record);

    int updateByPrimaryKey(TPatientNurseRef record);
}