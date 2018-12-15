package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TUserRoleRef;
import com.bben.medical.model.medical.TUserRoleRefExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserRoleRefMapper {
    long countByExample(TUserRoleRefExample example);

    int deleteByExample(TUserRoleRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserRoleRef record);

    int insertSelective(TUserRoleRef record);

    List<TUserRoleRef> selectByExample(TUserRoleRefExample example);

    TUserRoleRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserRoleRef record, @Param("example") TUserRoleRefExample example);

    int updateByExample(@Param("record") TUserRoleRef record, @Param("example") TUserRoleRefExample example);

    int updateByPrimaryKeySelective(TUserRoleRef record);

    int updateByPrimaryKey(TUserRoleRef record);
}