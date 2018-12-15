package com.bben.infusion.service;

import com.bben.infusion.model.infusion.TGatherData;

import java.util.List;

public interface TGatherDataService {
    int insert(TGatherData record);

    int insertSelective(TGatherData record);

    TGatherData selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TGatherData record);
}
