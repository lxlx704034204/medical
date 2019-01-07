package com.bben.samiservice.controller;

import com.bben.common.BaseController;
import com.bben.common.constants.Status;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.samiservice.Dto.PatientDto;
import com.bben.samiservice.constants.ReturnMessage;
import com.bben.samiservice.converter.HL7ToXmlConverter;
import com.bben.samiservice.model.samiservice.TBed;
import com.bben.samiservice.model.samiservice.TSickroom;
import com.bben.samiservice.model.samiservice.TWard;
import com.bben.samiservice.service.TBedService;
import com.bben.samiservice.service.TSickroomService;
import com.bben.samiservice.service.TWardService;
import com.bben.samiservice.util.SaMiMethodUtil;
import org.dom4j.Document;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientController extends BaseController {

    @Autowired
    private TSickroomService tSickroomService;

    @Autowired
    private TWardService tWardService;

    @Autowired
    private TBedService tBedService;

    public Result getPatient(String message){
        if (U.isBlank(message)){
            return Result.fail(ReturnMessage.MESSAGE_IS_NULL);
        }
        Document document = HL7ToXmlConverter.ConvertToXmlObject(message);
        String wardCode = SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "PV1/PV1.3/PV1.3.1"));
        String sickroomCode = SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "PV1/PV1.3/PV1.3.2"));
        String bedCode = SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "PV1/PV1.3/PV1.3.3"));
        String wardId = "";
        String sickroomId = "";
        String bedId = "";
        if (U.isNotBlank(wardCode)){
            List<TWard> tWards = tWardService.selectByCode(wardCode);
            if (A.isEmpty(tWards)){
                log.info("没有病区信息......");
            }else {
                wardId = tWards.get(0).getId().toString();
            }

        }
        if(U.isNotBlank(sickroomCode)){
            List<TSickroom> tSickrooms = tSickroomService.selectByCode(sickroomCode);
            if (A.isEmpty(tSickrooms)){
                log.info("没有病房数据......");
            }else {
                sickroomId = tSickrooms.get(0).getId().toString();
            }
        }
        if (U.isNotBlank(bedCode)){
            List<TBed> tBeds = tBedService.selectByCode(bedCode);
            if (A.isEmpty(tBeds)){
                log.info("没有病床数据");
            }else {
                bedId = tBeds.get(0).getId().toString();
            }
        }

        List<Node> pidlist = HL7ToXmlConverter.GetTexts(document, "PID/PID.3");
        /*List<Node> pv1list = HL7ToXmlConverter.GetTexts(document, "PV1/PV1.3");
        String wardCode = pv1list.get(0).getText();*/
        for(Node node : pidlist) {
            System.out.println(":"+node.getText());
        }
        PatientDto patientDto = new PatientDto();
        patientDto.setCode(SaMiMethodUtil.strVal(pidlist.get(0).getText()));
        patientDto.setName(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "PID/PID.5")));
        patientDto.setDeptId(SaMiMethodUtil.strVal(HL7ToXmlConverter.GetText(document, "PID/PID.5")));
        patientDto.setSickroomNo("1");
        patientDto.setCureNo(pidlist.get(1).getText());
        patientDto.setWardId(wardId);
        patientDto.setSickroomNo(sickroomId);
        patientDto.setBedNo(bedId);
        patientDto.setSex(SaMiMethodUtil.chooseSex(HL7ToXmlConverter.GetText(document, "PID/PID.8")));
        patientDto.setMarriage(SaMiMethodUtil.chooseMaritalStatus(HL7ToXmlConverter.GetText(document, "PID/PID.16")));
        patientDto.setBirthday(SaMiMethodUtil.dateFormat(HL7ToXmlConverter.GetText(document, "PID/PID.7")));
        patientDto.setMobile(HL7ToXmlConverter.GetText(document, "PID/PID.13"));
        patientDto.setAdmissionTime(SaMiMethodUtil.dateFormat(HL7ToXmlConverter.GetText(document, "PV1/PV1.44")));
        patientDto.setStatus((byte) Status.EFFECTIVE.getStatus().intValue());
        /*TPatient tPatient = socketServer.tNurseService.operationNurse(NurseDto.assemblyData(nurseDto));
        if (U.isBlank(tNurse)){
            return Result.fail(ReturnMessage.ERROR);
        }*/
        return Result.success(ReturnMessage.SUCCECSS);
    }
}
