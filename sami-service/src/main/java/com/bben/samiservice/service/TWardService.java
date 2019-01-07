package com.bben.samiservice.service;

import com.bben.samiservice.model.samiservice.TWard;

import java.util.List;

public interface TWardService {

    /**
     * 根据Code查询病区信息
     * @param code
     * @return
     */
    List<TWard> selectByCode(String code);
}
