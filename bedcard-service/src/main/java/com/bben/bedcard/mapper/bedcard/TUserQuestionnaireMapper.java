package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.bedcard.model.bedcard.TUserQuestionnaireExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserQuestionnaireMapper {
    long countByExample(TUserQuestionnaireExample example);

    int deleteByExample(TUserQuestionnaireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserQuestionnaire record);

    int insertSelective(TUserQuestionnaire record);

    List<TUserQuestionnaire> selectByExample(TUserQuestionnaireExample example);

    TUserQuestionnaire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserQuestionnaire record, @Param("example") TUserQuestionnaireExample example);

    int updateByExample(@Param("record") TUserQuestionnaire record, @Param("example") TUserQuestionnaireExample example);

    int updateByPrimaryKeySelective(TUserQuestionnaire record);

    int updateByPrimaryKey(TUserQuestionnaire record);
}