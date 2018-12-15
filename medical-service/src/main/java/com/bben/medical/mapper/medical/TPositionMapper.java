package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TPosition;
import com.bben.medical.model.medical.TPositionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TPositionMapper {
    long countByExample(TPositionExample example);

    int deleteByExample(TPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPosition record);

    int insertSelective(TPosition record);

    List<TPosition> selectByExample(TPositionExample example);

    TPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPosition record, @Param("example") TPositionExample example);

    int updateByExample(@Param("record") TPosition record, @Param("example") TPositionExample example);

    int updateByPrimaryKeySelective(TPosition record);

    int updateByPrimaryKey(TPosition record);
}