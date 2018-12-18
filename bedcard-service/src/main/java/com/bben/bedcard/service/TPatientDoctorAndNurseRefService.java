package com.bben.bedcard.service;

import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.bedcard.model.bedcard.TNurse;
import com.bben.bedcard.model.bedcard.TPatient;

public interface TPatientDoctorAndNurseRefService {

    /**
     * 添加病人医生和护士信息
     * @param tPatient
     * @param tDoctor
     * @param tNurse
     * @return
     */
    int insertSelective(TPatient tPatient, TDoctor tDoctor, TNurse tNurse);

    /**
     * 更新病人医生和护士信息
     * @param tPatient
     * @param tDoctor
     * @param tNurse
     * @return
     */
    int updateByPrimarykey(TPatient tPatient, TDoctor tDoctor, TNurse tNurse);

    /**
     * 删除病人医生和护士信息
     * @param tPatient
     * @param tDoctor
     * @param tNurse
     * @return
     */
    int deleteByPrimarykey(TPatient tPatient, TDoctor tDoctor, TNurse tNurse);


}
