package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.THospitalDto;
import com.bben.bedcard.dto.TPatientDto;
import com.bben.bedcard.model.bedcard.*;
import com.bben.bedcard.service.*;
import com.bben.bedcard.vo.*;
import com.bben.common.BaseController;
import com.bben.common.constants.OperationType;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BBEN_LI
 */
@Api(tags = "萨米病人接口 ---->李振伟")
@RestController
@RequestMapping("/saMiPatient")
public class SaMiPatientController extends BaseController {

    @Autowired
    private TPatientService tPatientService;

    @Autowired
    private THospitalService tHospitalService;

    @Autowired
    private TDeptService tDeptService;

    @Autowired
    private TWardService tWardService;

    @Autowired
    private TSickroomService tSickroomService;

    @Autowired
    private TBedService tBedService;

    public Result saMiPatientError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiPatient.do")
    @ApiOperation("萨米新增/更新/删除病人信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiPatientError")
    public Result saMiPatient(String jsonInfo) {
        try {
            if (U.isBlank(jsonInfo)) {
                return Result.fail(ReturnMessage.PARAMETER_IS_NULL);
            }
            /**
             * 先将json字符串转换为json对象
             */
            JSONObject obj = JSONObject.fromObject(jsonInfo);
            /**
             * 再将json对象转换为java对象
             */

            TPatientDto tPatientDto = (TPatientDto) JSONObject.toBean(obj, TPatientDto.class);
            if (U.isBlank(tPatientDto) || U.isBlank(tPatientDto.getOperationType()) || U.isBlank(tPatientDto.getDataId()) || U.isBlank(tPatientDto.getMessageId())) {
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            if (U.isNotBlank(tPatientDto.getHospitalDataId())){
                THospitalDto tHospitalDto = new THospitalDto();
                tHospitalDto.setDataId(tPatientDto.getHospitalDataId());
                List<THospitalVo> tHospitalVoList = tHospitalService.findByCondition(tHospitalDto);
                if (A.isEmpty(tHospitalVoList)){
                    tPatientDto.setHospitalId("1");
                }else {
                    tPatientDto.setHospitalId(tHospitalVoList.get(0).getId().toString());
                }
            }else {
                tPatientDto.setHospitalId("1");
            }
            if (U.isNotBlank(tPatientDto.getDeptDataId())){
                TDept tDept = new TDept();
                tDept.setDataId(tPatientDto.getDeptDataId());
                List<TDeptVo> tDeptList = tDeptService.selectByCondition(tDept);
                if (A.isEmpty(tDeptList)){
                    return Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
                }
                tPatientDto.setDeptId(tDeptList.get(0).getId().toString());
            }
            if (U.isNotBlank(tPatientDto.getDeptDataId())){
                TWard tWard = new TWard();
                tWard.setDataId(tPatientDto.getDeptDataId());
                List<TWardVo> tWardVoList = tWardService.selectByCondition(tWard);
                if (A.isEmpty(tWardVoList)){
                    return Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
                }
                tPatientDto.setWardId(tWardVoList.get(0).getId().toString());
            }
            if (U.isNotBlank(tPatientDto.getSickroomDataNo())){
                TSickroom tSickroom = new TSickroom();
                tSickroom.setDataId(tPatientDto.getSickroomDataNo());
                List<TSickroomVo> tSickroomVoList = tSickroomService.selectByCondition(tSickroom);
                if (A.isEmpty(tSickroomVoList)){
                    return Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
                }
                tPatientDto.setSickroomNo(tSickroomVoList.get(0).getId().toString());
            }
            if (U.isNotBlank(tPatientDto.getBedDataNo())){
                TBed tBed = new TBed();
                tBed.setDataId(tPatientDto.getBedDataNo());
                List<TBedVo> tBedList = tBedService.selectByCondition(tBed);
                if (A.isEmpty(tBedList)){
                    return  Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
                }
                tPatientDto.setBedNo(tBedList.get(0).getId().toString());
            }
            TPatient tPatient = new TPatient();
            tPatient.setDataId(tPatientDto.getDataId());
            tPatient.setMessageId(tPatientDto.getMessageId());
            List<TPatient> tPatientList = tPatientService.selectListByCondition(tPatient);
            switch (tPatientDto.getOperationType()) {
                case OperationType.ADD_OR_UPDATE:
                    if (U.isBlank(tPatientDto.getDeptDataId()) || U.isBlank(tPatientDto.getWardDataId()) || U.isBlank(tPatientDto.getSickroomDataNo()) || U.isBlank(tPatientDto.getBedDataNo())){
                        return  Result.fail(ReturnMessage.PARAMETER_IS_ERROR);
                    }
                    if (A.isNotEmpty(tPatientList)) {
                        TPatient updateOk = tPatientService.updateByPrimarykey(TPatientDto.assemblyData(tPatientDto));
                        if (U.isBlank(updateOk)) {
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        TPatient addOk = tPatientService.insertSelective(TPatientDto.assemblyData(tPatientDto));
                        if (U.isBlank(addOk)) {
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }
                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tPatientList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tPatientService.deleteByCondition(A.first(tPatientList));
                    if (0 == deleteOk) {
                        return Result.fail(ReturnMessage.DELETE_ERROR);
                    }
                    return Result.success(ReturnMessage.DELETE_SUCCESS);
                default:
                    return Result.fail(ReturnMessage.OPERATIONTYPE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(ReturnMessage.EXCEPTION);
        }

    }
}
