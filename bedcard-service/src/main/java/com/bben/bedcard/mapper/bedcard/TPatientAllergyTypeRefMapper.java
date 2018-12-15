package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TPatientAllergyTypeRef;
import com.bben.bedcard.model.bedcard.TPatientAllergyTypeRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientAllergyTypeRefMapper {
    long countByExample(TPatientAllergyTypeRefExample example);

    int deleteByExample(TPatientAllergyTypeRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientAllergyTypeRef record);

    int insertSelective(TPatientAllergyTypeRef record);

    List<TPatientAllergyTypeRef> selectByExample(TPatientAllergyTypeRefExample example);

    TPatientAllergyTypeRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientAllergyTypeRef record, @Param("example") TPatientAllergyTypeRefExample example);

    int updateByExample(@Param("record") TPatientAllergyTypeRef record, @Param("example") TPatientAllergyTypeRefExample example);

    int updateByPrimaryKeySelective(TPatientAllergyTypeRef record);

    int updateByPrimaryKey(TPatientAllergyTypeRef record);
}