package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TQuestionType;
import com.bben.bedcard.model.bedcard.TQuestionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TQuestionTypeMapper {
    long countByExample(TQuestionTypeExample example);

    int deleteByExample(TQuestionTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TQuestionType record);

    int insertSelective(TQuestionType record);

    List<TQuestionType> selectByExample(TQuestionTypeExample example);

    TQuestionType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestionType record, @Param("example") TQuestionTypeExample example);

    int updateByExample(@Param("record") TQuestionType record, @Param("example") TQuestionTypeExample example);

    int updateByPrimaryKeySelective(TQuestionType record);

    int updateByPrimaryKey(TQuestionType record);
}