package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TRoleResourceRef;
import com.bben.medical.model.medical.TRoleResourceRefExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRoleResourceRefMapper {
    long countByExample(TRoleResourceRefExample example);

    int deleteByExample(TRoleResourceRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleResourceRef record);

    int insertSelective(TRoleResourceRef record);

    List<TRoleResourceRef> selectByExample(TRoleResourceRefExample example);

    TRoleResourceRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleResourceRef record, @Param("example") TRoleResourceRefExample example);

    int updateByExample(@Param("record") TRoleResourceRef record, @Param("example") TRoleResourceRefExample example);

    int updateByPrimaryKeySelective(TRoleResourceRef record);

    int updateByPrimaryKey(TRoleResourceRef record);
}