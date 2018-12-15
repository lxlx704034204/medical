package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TInfusionParam;
import com.bben.infusion.model.infusion.TInfusionParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInfusionParamMapper {
    long countByExample(TInfusionParamExample example);

    int deleteByExample(TInfusionParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TInfusionParam record);

    int insertSelective(TInfusionParam record);

    List<TInfusionParam> selectByExample(TInfusionParamExample example);

    TInfusionParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TInfusionParam record, @Param("example") TInfusionParamExample example);

    int updateByExample(@Param("record") TInfusionParam record, @Param("example") TInfusionParamExample example);

    int updateByPrimaryKeySelective(TInfusionParam record);

    int updateByPrimaryKey(TInfusionParam record);
}