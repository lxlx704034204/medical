package com.bben.samiservice.service;

import com.bben.samiservice.model.samiservice.TDoctor;

public interface TDoctorService {

    /**
     * 操作科室数据
     * @param record
     * @return
     */
    TDoctor operationDoctor(TDoctor record);
}
