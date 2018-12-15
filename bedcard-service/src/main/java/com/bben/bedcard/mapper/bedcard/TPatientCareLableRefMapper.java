package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TPatientCareLableRef;
import com.bben.bedcard.model.bedcard.TPatientCareLableRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientCareLableRefMapper {
    long countByExample(TPatientCareLableRefExample example);

    int deleteByExample(TPatientCareLableRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientCareLableRef record);

    int insertSelective(TPatientCareLableRef record);

    List<TPatientCareLableRef> selectByExample(TPatientCareLableRefExample example);

    TPatientCareLableRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientCareLableRef record, @Param("example") TPatientCareLableRefExample example);

    int updateByExample(@Param("record") TPatientCareLableRef record, @Param("example") TPatientCareLableRefExample example);

    int updateByPrimaryKeySelective(TPatientCareLableRef record);

    int updateByPrimaryKey(TPatientCareLableRef record);
}