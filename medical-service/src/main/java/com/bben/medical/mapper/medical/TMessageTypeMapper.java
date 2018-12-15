package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TMessageType;
import com.bben.medical.model.medical.TMessageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageTypeMapper {
    long countByExample(TMessageTypeExample example);

    int deleteByExample(TMessageTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMessageType record);

    int insertSelective(TMessageType record);

    List<TMessageType> selectByExample(TMessageTypeExample example);

    TMessageType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMessageType record, @Param("example") TMessageTypeExample example);

    int updateByExample(@Param("record") TMessageType record, @Param("example") TMessageTypeExample example);

    int updateByPrimaryKeySelective(TMessageType record);

    int updateByPrimaryKey(TMessageType record);
}