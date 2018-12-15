package com.bben.medical.mapper.medical;

import com.bben.medical.model.medical.TControlParam;
import com.bben.medical.model.medical.TControlParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TControlParamMapper {
    long countByExample(TControlParamExample example);

    int deleteByExample(TControlParamExample example);

    int deleteByPrimaryKey(String code);

    int insert(TControlParam record);

    int insertSelective(TControlParam record);

    List<TControlParam> selectByExample(TControlParamExample example);

    TControlParam selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") TControlParam record, @Param("example") TControlParamExample example);

    int updateByExample(@Param("record") TControlParam record, @Param("example") TControlParamExample example);

    int updateByPrimaryKeySelective(TControlParam record);

    int updateByPrimaryKey(TControlParam record);
}