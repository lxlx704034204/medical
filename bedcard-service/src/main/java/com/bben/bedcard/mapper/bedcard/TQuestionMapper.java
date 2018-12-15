package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TQuestion;
import com.bben.bedcard.model.bedcard.TQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TQuestionMapper {
    long countByExample(TQuestionExample example);

    int deleteByExample(TQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TQuestion record);

    int insertSelective(TQuestion record);

    List<TQuestion> selectByExample(TQuestionExample example);

    TQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExample(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByPrimaryKeySelective(TQuestion record);

    int updateByPrimaryKey(TQuestion record);
}