package com.bben.samiservice.service;

import com.bben.samiservice.model.samiservice.TBed;

import java.util.List;

public interface TBedService {

    /**
     * 根据Code查询病区信息
     * @param code
     * @return
     */
    List<TBed> selectByCode(String code);
}
