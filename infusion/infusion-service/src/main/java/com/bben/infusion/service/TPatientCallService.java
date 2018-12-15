package com.bben.infusion.service;

import com.bben.infusion.model.infusion.TPatientCall;
import com.bben.infusion.model.infusion.TPatientCallExample;
import org.json.simple.JSONArray;

import java.util.List;

public interface TPatientCallService {

    List<TPatientCall> selectByExample(TPatientCallExample example);

    TPatientCall selectByPrimaryKey(Integer id);

    /**
     * 根据条件查询病人呼叫信息
     * @param record
     * @return
     */
    JSONArray selectByCondition(TPatientCall record);
}
