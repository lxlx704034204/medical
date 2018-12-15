package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TMenuResourceRef;
import com.bben.medical.model.medical.TMenuResourceRefExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMenuResourceRefMapper {
    long countByExample(TMenuResourceRefExample example);

    int deleteByExample(TMenuResourceRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMenuResourceRef record);

    int insertSelective(TMenuResourceRef record);

    List<TMenuResourceRef> selectByExample(TMenuResourceRefExample example);

    TMenuResourceRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMenuResourceRef record, @Param("example") TMenuResourceRefExample example);

    int updateByExample(@Param("record") TMenuResourceRef record, @Param("example") TMenuResourceRefExample example);

    int updateByPrimaryKeySelective(TMenuResourceRef record);

    int updateByPrimaryKey(TMenuResourceRef record);
}