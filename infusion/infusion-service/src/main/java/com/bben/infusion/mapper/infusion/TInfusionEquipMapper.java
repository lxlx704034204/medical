package com.bben.infusion.mapper.infusion;

import com.bben.infusion.model.infusion.TInfusionEquip;
import com.bben.infusion.model.infusion.TInfusionEquipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TInfusionEquipMapper {
    long countByExample(TInfusionEquipExample example);

    int deleteByExample(TInfusionEquipExample example);

    int deleteByPrimaryKey(String equipmentSn);

    int insert(TInfusionEquip record);

    int insertSelective(TInfusionEquip record);

    List<TInfusionEquip> selectByExample(TInfusionEquipExample example);

    TInfusionEquip selectByPrimaryKey(String equipmentSn);

    int updateByExampleSelective(@Param("record") TInfusionEquip record, @Param("example") TInfusionEquipExample example);

    int updateByExample(@Param("record") TInfusionEquip record, @Param("example") TInfusionEquipExample example);

    int updateByPrimaryKeySelective(TInfusionEquip record);

    int updateByPrimaryKey(TInfusionEquip record);
}