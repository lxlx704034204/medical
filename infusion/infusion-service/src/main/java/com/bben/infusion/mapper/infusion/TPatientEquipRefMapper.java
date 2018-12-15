package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TPatientEquipRef;
import com.bben.infusion.model.infusion.TPatientEquipRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientEquipRefMapper {
    long countByExample(TPatientEquipRefExample example);

    int deleteByExample(TPatientEquipRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPatientEquipRef record);

    int insertSelective(TPatientEquipRef record);

    List<TPatientEquipRef> selectByExample(TPatientEquipRefExample example);

    TPatientEquipRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPatientEquipRef record, @Param("example") TPatientEquipRefExample example);

    int updateByExample(@Param("record") TPatientEquipRef record, @Param("example") TPatientEquipRefExample example);

    int updateByPrimaryKeySelective(TPatientEquipRef record);

    int updateByPrimaryKey(TPatientEquipRef record);
}