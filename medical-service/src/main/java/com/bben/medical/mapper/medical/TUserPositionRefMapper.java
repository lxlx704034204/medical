package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TUserPositionRef;
import com.bben.medical.model.medical.TUserPositionRefExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserPositionRefMapper {
    long countByExample(TUserPositionRefExample example);

    int deleteByExample(TUserPositionRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserPositionRef record);

    int insertSelective(TUserPositionRef record);

    List<TUserPositionRef> selectByExample(TUserPositionRefExample example);

    TUserPositionRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserPositionRef record, @Param("example") TUserPositionRefExample example);

    int updateByExample(@Param("record") TUserPositionRef record, @Param("example") TUserPositionRefExample example);

    int updateByPrimaryKeySelective(TUserPositionRef record);

    int updateByPrimaryKey(TUserPositionRef record);
}