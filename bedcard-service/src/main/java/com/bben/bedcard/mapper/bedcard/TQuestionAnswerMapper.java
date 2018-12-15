package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.bedcard.model.bedcard.TQuestionAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TQuestionAnswerMapper {
    long countByExample(TQuestionAnswerExample example);

    int deleteByExample(TQuestionAnswerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TQuestionAnswer record);

    int insertSelective(TQuestionAnswer record);

    List<TQuestionAnswer> selectByExample(TQuestionAnswerExample example);

    TQuestionAnswer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestionAnswer record, @Param("example") TQuestionAnswerExample example);

    int updateByExample(@Param("record") TQuestionAnswer record, @Param("example") TQuestionAnswerExample example);

    int updateByPrimaryKeySelective(TQuestionAnswer record);

    int updateByPrimaryKey(TQuestionAnswer record);
}