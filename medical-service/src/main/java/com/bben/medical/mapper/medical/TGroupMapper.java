package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TGroup;
import com.bben.medical.model.medical.TGroupExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TGroupMapper {
    long countByExample(TGroupExample example);

    int deleteByExample(TGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGroup record);

    int insertSelective(TGroup record);

    List<TGroup> selectByExample(TGroupExample example);

    TGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGroup record, @Param("example") TGroupExample example);

    int updateByExample(@Param("record") TGroup record, @Param("example") TGroupExample example);

    int updateByPrimaryKeySelective(TGroup record);

    int updateByPrimaryKey(TGroup record);
}