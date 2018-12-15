package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TUserLog;
import com.bben.medical.model.medical.TUserLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserLogMapper {
    long countByExample(TUserLogExample example);

    int deleteByExample(TUserLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUserLog record);

    int insertSelective(TUserLog record);

    List<TUserLog> selectByExample(TUserLogExample example);

    TUserLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TUserLog record, @Param("example") TUserLogExample example);

    int updateByExample(@Param("record") TUserLog record, @Param("example") TUserLogExample example);

    int updateByPrimaryKeySelective(TUserLog record);

    int updateByPrimaryKey(TUserLog record);
}