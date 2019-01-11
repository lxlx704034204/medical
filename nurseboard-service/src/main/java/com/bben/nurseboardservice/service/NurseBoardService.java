package com.bben.nurseboardservice.service;

import com.bben.nurseboardservice.vo.NurseBoardPatientVo;

public interface NurseBoardService {

    /**
     * 根据病区Id查询护理看板信息
     * @param wardId
     * @return
     */
    NurseBoardPatientVo selectByWardId(Integer wardId);


}
