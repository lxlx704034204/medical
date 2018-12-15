package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TInfusionBatteryLife;
import com.bben.infusion.model.infusion.TInfusionBatteryLifeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInfusionBatteryLifeMapper {
    long countByExample(TInfusionBatteryLifeExample example);

    int deleteByExample(TInfusionBatteryLifeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TInfusionBatteryLife record);

    int insertSelective(TInfusionBatteryLife record);

    List<TInfusionBatteryLife> selectByExample(TInfusionBatteryLifeExample example);

    TInfusionBatteryLife selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TInfusionBatteryLife record, @Param("example") TInfusionBatteryLifeExample example);

    int updateByExample(@Param("record") TInfusionBatteryLife record, @Param("example") TInfusionBatteryLifeExample example);

    int updateByPrimaryKeySelective(TInfusionBatteryLife record);

    int updateByPrimaryKey(TInfusionBatteryLife record);
}