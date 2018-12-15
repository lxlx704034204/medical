package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TAllergyType;
import com.bben.bedcard.model.bedcard.TAllergyTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAllergyTypeMapper {
    long countByExample(TAllergyTypeExample example);

    int deleteByExample(TAllergyTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAllergyType record);

    int insertSelective(TAllergyType record);

    List<TAllergyType> selectByExampleWithBLOBs(TAllergyTypeExample example);

    List<TAllergyType> selectByExample(TAllergyTypeExample example);

    TAllergyType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAllergyType record, @Param("example") TAllergyTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") TAllergyType record, @Param("example") TAllergyTypeExample example);

    int updateByExample(@Param("record") TAllergyType record, @Param("example") TAllergyTypeExample example);

    int updateByPrimaryKeySelective(TAllergyType record);

    int updateByPrimaryKeyWithBLOBs(TAllergyType record);

    int updateByPrimaryKey(TAllergyType record);
}