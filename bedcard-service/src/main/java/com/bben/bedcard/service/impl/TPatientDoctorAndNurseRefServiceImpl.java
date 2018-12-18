package com.bben.bedcard.service.impl;

import com.bben.bedcard.mapper.bedcard.TDoctorMapper;
import com.bben.bedcard.mapper.bedcard.TPatientDoctorRefMapper;
import com.bben.bedcard.mapper.bedcard.TPatientMapper;
import com.bben.bedcard.mapper.bedcard.TPatientNurseRefMapper;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.TPatientDoctorAndNurseRefService;
import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 病人医生和护士接口实现
 */
@Service(value = "TPatientDoctorAndNurseRefService")
public class TPatientDoctorAndNurseRefServiceImpl implements TPatientDoctorAndNurseRefService {

    @Autowired
    private TPatientMapper tPatientMapper;

    @Autowired
    private TDoctorMapper tDoctorMapper;

    @Autowired
    private TPatientDoctorRefMapper tPatientDoctorRefMapper;

    @Autowired
    private TPatientNurseRefMapper  tPatientNurseRefMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertSelective(TPatient tPatient, TDoctor tDoctor, TNurse tNurse) {
        if (U.isBlank(tPatient)){
            return 0;
        }
        try {
            if (U.isNotBlank(tDoctor)){
                TPatientDoctorRef record = new TPatientDoctorRef();
                record.setPatientId(tPatient.getId());
                record.setDoctorId(tDoctor.getId());
                record.setCreateTime(new Date());
                int count = tPatientDoctorRefMapper.insertSelective(record);
                if (0 == count){
                    throw new RuntimeException();
                }
            }
            if (U.isNotBlank(tNurse)){
                TPatientNurseRef record = new TPatientNurseRef();
                record.setPatientId(tPatient.getId());
                record.setNurseId(tNurse.getId());
                record.setCreateTime(new Date());
                int count = tPatientNurseRefMapper.insertSelective(record);
                if (0 == count){
                    throw new RuntimeException();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateByPrimarykey(TPatient tPatient, TDoctor tDoctor, TNurse tNurse) {
        if (U.isBlank(tPatient)){
            return 0;
        }
        return 0;
    }

    @Override
    public int deleteByPrimarykey(TPatient tPatient, TDoctor tDoctor, TNurse tNurse) {
        if (U.isBlank(tPatient)){
            return 0;
        }

        return 0;
    }


    public TPatient selectTPatientByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        TPatientExample tPatientExample = new TPatientExample();
        TPatientExample.Criteria criteria = tPatientExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        List<TPatient> tPatientList = tPatientMapper.selectByExample(tPatientExample);
        if (A.isEmpty(tPatientList)){
            return null;
        }
        return A.first(tPatientList);
    }

    public TDoctor selectTDoctorByDataId(String dataId){
        if (U.isBlank(dataId)){
            return null;
        }
        TDoctorExample tDoctorExample = new TDoctorExample();
        TDoctorExample.Criteria criteria = tDoctorExample.createCriteria();
        criteria.andDataIdEqualTo(dataId);
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TDoctor> tDoctorList = tDoctorMapper.selectByExample(tDoctorExample);
        if (A.isEmpty(tDoctorList)){
            return null;
        }
        return A.first(tDoctorList);
    }

}
