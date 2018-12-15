package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TInfusionEquipType;
import com.bben.infusion.model.infusion.TInfusionEquipTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInfusionEquipTypeMapper {
    long countByExample(TInfusionEquipTypeExample example);

    int deleteByExample(TInfusionEquipTypeExample example);

    int deleteByPrimaryKey(String infusionEquipType);

    int insert(TInfusionEquipType record);

    int insertSelective(TInfusionEquipType record);

    List<TInfusionEquipType> selectByExample(TInfusionEquipTypeExample example);

    TInfusionEquipType selectByPrimaryKey(String infusionEquipType);

    int updateByExampleSelective(@Param("record") TInfusionEquipType record, @Param("example") TInfusionEquipTypeExample example);

    int updateByExample(@Param("record") TInfusionEquipType record, @Param("example") TInfusionEquipTypeExample example);

    int updateByPrimaryKeySelective(TInfusionEquipType record);

    int updateByPrimaryKey(TInfusionEquipType record);
}