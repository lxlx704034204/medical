package com.bben.infusion.service;

import com.bben.infusion.model.infusion.TPatientInfusionInfo;

public interface TPatientInfusionInfoService {
    TPatientInfusionInfo selectByPrimaryKey(Integer id);

    int insertSelective(TPatientInfusionInfo record);

    int updateByPrimaryKey(TPatientInfusionInfo record);

}
