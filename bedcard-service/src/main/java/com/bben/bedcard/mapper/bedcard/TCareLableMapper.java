package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TCareLable;
import com.bben.bedcard.model.bedcard.TCareLableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCareLableMapper {
    long countByExample(TCareLableExample example);

    int deleteByExample(TCareLableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCareLable record);

    int insertSelective(TCareLable record);

    List<TCareLable> selectByExample(TCareLableExample example);

    TCareLable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCareLable record, @Param("example") TCareLableExample example);

    int updateByExample(@Param("record") TCareLable record, @Param("example") TCareLableExample example);

    int updateByPrimaryKeySelective(TCareLable record);

    int updateByPrimaryKey(TCareLable record);
}