package com.bben.infusion.service;

import com.bben.infusion.model.infusion.TInfusionEquip;

public interface TInfusionEquipService {
    TInfusionEquip selectByPrimaryKey(String equipmentSn);

    int insertSelective(TInfusionEquip record);

    int updateByPrimaryKey(TInfusionEquip record);

}
