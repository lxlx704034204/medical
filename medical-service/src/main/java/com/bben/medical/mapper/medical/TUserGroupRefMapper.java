package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TUserGroupRef;
import com.bben.medical.model.medical.TUserGroupRefExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserGroupRefMapper {
    long countByExample(TUserGroupRefExample example);

    int deleteByExample(TUserGroupRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserGroupRef record);

    int insertSelective(TUserGroupRef record);

    List<TUserGroupRef> selectByExample(TUserGroupRefExample example);

    TUserGroupRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserGroupRef record, @Param("example") TUserGroupRefExample example);

    int updateByExample(@Param("record") TUserGroupRef record, @Param("example") TUserGroupRefExample example);

    int updateByPrimaryKeySelective(TUserGroupRef record);

    int updateByPrimaryKey(TUserGroupRef record);
}