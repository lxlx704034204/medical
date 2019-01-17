package com.bben.nurseboardservice.service.impl;

import com.bben.common.constants.Status;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.nurseboardservice.mapper.nurseboardservice.*;
import com.bben.nurseboardservice.model.nurseboardservice.*;
import com.bben.nurseboardservice.service.NurseBoardService;
import com.bben.nurseboardservice.vo.NurseBoardPatientVo;
import com.bben.nurseboardservice.vo.PatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "NurseBoardService")
public class NurseBoardServiceImpl implements NurseBoardService {

    @Autowired
    private TWardMapper tWardMapper;

    @Autowired
    private TBedMapper tBedMapper;

    @Autowired
    private TPatientMapper tPatientMapper;

    @Autowired
    private TNurseLevelMapper tNurseLevelMapper;

    @Autowired
    private TPatientNurseRefMapper tPatientNurseRefMapper;

    @Autowired
    private TNurseMapper tNurseMapper;

    @Autowired
    private TNoticeMapper tNoticeMapper;

    @Override
    public NurseBoardPatientVo selectByWardId(Integer wardId) {
        if (U.isBlank(wardId)){
            return null;
        }
        TWard tWard = tWardMapper.selectByPrimaryKey(wardId);
        if (U.isBlank(tWard)){
            return null;
        }
        NurseBoardPatientVo nurseBoardPatientVo = new NurseBoardPatientVo();
        nurseBoardPatientVo.setWardName(tWard.getName());
        TBedExample tBedExample = new TBedExample();
        TBedExample.Criteria criteria = tBedExample.createCriteria();
        criteria.andSickroomIdEqualTo(wardId);
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TBed> tBeds = tBedMapper.selectByExample(tBedExample);
        if (A.isEmpty(tBeds)){
            return null;
        }
        /*TNotice tNotice = */
        List<PatientVo> patientVos = new ArrayList<>();
        int patientCount =0;
        int freeLocationCount = 0;
        for (TBed tBed : tBeds) {
            TPatientExample tPatientExample = new TPatientExample();
            TPatientExample.Criteria criteria1 = tPatientExample.createCriteria();
            criteria1.andWardIdEqualTo(wardId.toString());
            criteria1.andBedNoEqualTo(tBed.getId().toString());
            criteria1.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
            PatientVo patientVo = new PatientVo();
            List<TPatient> tPatients = tPatientMapper.selectByExample(tPatientExample);
            if (A.isEmpty(tPatients)){
                patientVo.setHasMore(false);
                freeLocationCount ++;
            }else {
                TPatient tPatient = A.first(tPatients);
                patientVo.setHasMore(true);
                patientVo.setBedId(tBed.getId());
                patientVo.setId(tPatient.getId());
                patientVo.setName(tPatient.getName());
                patientVo.setSex(tPatient.getSex());
                patientVo.setBirthday(tPatient.getBirthday());
                patientVo.setCureNo(tPatient.getCureNo());
                if (U.isNotBlank(tPatient.getNurseLevel())){
                    TNurseLevel tNurseLevel = selectById(Integer.valueOf(tPatient.getNurseLevel()));
                    if (U.isNotBlank(tNurseLevel)){
                        patientVo.setNurseLevel(tNurseLevel.getLevelName());
                        patientVo.setNurseLevelColor(tNurseLevel.getLevelColor());
                    }
                }
                String nurseName = nurseName(tPatient.getId());
                if (U.isNotBlank(nurseName)){
                    patientVo.setNurseName(nurseName);
                }
            }
            patientVos.add(patientVo);
            patientCount ++;
        }
        nurseBoardPatientVo.setPatientVos(patientVos);
        nurseBoardPatientVo.setBedCount(tBeds.size());
        nurseBoardPatientVo.setPatientCount(patientCount);
        nurseBoardPatientVo.setFreeLocationCount(freeLocationCount);
        return nurseBoardPatientVo;
    }

    private TNurseLevel selectById(Integer nurseLevelId){
        if (U.isBlank(nurseLevelId)){
            return null;
        }
        TNurseLevel tNurseLevel = tNurseLevelMapper.selectByPrimaryKey(nurseLevelId);
        if (U.isBlank(tNurseLevel)){
            return null;
        }
        return tNurseLevel;
    }

    private String nurseName(Integer patientId){
        String nurseName = "";
        if (U.isBlank(patientId)){
            return nurseName;
        }
        TPatientNurseRefExample tPatientNurseRefExample = new TPatientNurseRefExample();
        TPatientNurseRefExample.Criteria criteria = tPatientNurseRefExample.createCriteria();
        criteria.andPatientIdEqualTo(patientId);
        criteria.andStatusEqualTo((byte) Status.EFFECTIVE.getStatus().intValue());
        List<TPatientNurseRef> tPatientNurseRefs = tPatientNurseRefMapper.selectByExample(tPatientNurseRefExample);
        if (A.isEmpty(tPatientNurseRefs)){
            return nurseName;
        }
        TNurse tNurse = tNurseMapper.selectByPrimaryKey(tPatientNurseRefs.get(0).getId());
        if (U.isBlank(tNurse)){
            return nurseName;
        }
        nurseName = tNurse.getName();
        return nurseName;
    }
}



