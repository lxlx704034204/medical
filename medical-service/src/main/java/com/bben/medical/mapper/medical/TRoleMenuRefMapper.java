package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TRoleMenuRef;
import com.bben.medical.model.medical.TRoleMenuRefExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRoleMenuRefMapper {
    long countByExample(TRoleMenuRefExample example);

    int deleteByExample(TRoleMenuRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRoleMenuRef record);

    int insertSelective(TRoleMenuRef record);

    List<TRoleMenuRef> selectByExample(TRoleMenuRefExample example);

    TRoleMenuRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRoleMenuRef record, @Param("example") TRoleMenuRefExample example);

    int updateByExample(@Param("record") TRoleMenuRef record, @Param("example") TRoleMenuRefExample example);

    int updateByPrimaryKeySelective(TRoleMenuRef record);

    int updateByPrimaryKey(TRoleMenuRef record);
}