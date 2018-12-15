package com.bben.bedcard.mapper.bedcard;

import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.bedcard.model.bedcard.TVideoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TVideoMapper {
    long countByExample(TVideoExample example);

    int deleteByExample(TVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TVideo record);

    int insertSelective(TVideo record);

    List<TVideo> selectByExample(TVideoExample example);

    TVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TVideo record, @Param("example") TVideoExample example);

    int updateByExample(@Param("record") TVideo record, @Param("example") TVideoExample example);

    int updateByPrimaryKeySelective(TVideo record);

    int updateByPrimaryKey(TVideo record);
}