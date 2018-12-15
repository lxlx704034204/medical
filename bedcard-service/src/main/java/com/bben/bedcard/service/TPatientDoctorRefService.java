package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.THospital;

public interface TPatientDoctorRefService {

    /**
     * 添加医院信息
     * @param record
     * @return
     */
    THospital insertSelective(THospital record);

    /**
     * 更新医院信息
     * @param record
     * @return
     */
    THospital updateByPrimarykey(THospital record);

    /**
     * 删除医院信息
     * @param hospitalId
     * @return
     */
    int deleteByPrimarykey(Integer hospitalId);


}
