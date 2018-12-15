package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TMedicationRecord;
import com.bben.bedcard.model.bedcard.TMedicationRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMedicationRecordMapper {
    long countByExample(TMedicationRecordExample example);

    int deleteByExample(TMedicationRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMedicationRecord record);

    int insertSelective(TMedicationRecord record);

    List<TMedicationRecord> selectByExample(TMedicationRecordExample example);

    TMedicationRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMedicationRecord record, @Param("example") TMedicationRecordExample example);

    int updateByExample(@Param("record") TMedicationRecord record, @Param("example") TMedicationRecordExample example);

    int updateByPrimaryKeySelective(TMedicationRecord record);

    int updateByPrimaryKey(TMedicationRecord record);
}