package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.TDoctorDto;
import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.bedcard.service.TDoctorService;
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

@Api(tags = "萨米医生接口 ---> 李振伟")
@RestController
@RequestMapping("/saMiDoctor")
public class SaMiDoctorController extends BaseController {


    @Autowired
    private TDoctorService tDoctorService;

    public Result saMiDoctorError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiDoctor.do")
    @ApiOperation("萨米新增/更新/删除科室信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiDoctorError")
    public Result saMiDoctor(String jsonInfo){
        if (U.isBlank(jsonInfo)){
            return Result.fail(ReturnMessage.PARAMETER_IS_NULL);
        }
        try {

            /**
             * 先将json字符串转换为json对象
             */
            JSONObject obj = JSONObject.fromObject(jsonInfo);
            /**
             * 再将json对象转换为java对象
             */
            TDoctorDto tDoctorDto = (TDoctorDto)JSONObject.toBean(obj,TDoctorDto.class);
            if (U.isBlank(tDoctorDto) || U.isBlank(tDoctorDto.getOperationType()) || U.isBlank(tDoctorDto.getDataId()) || U.isBlank(tDoctorDto.getMessageId())){
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            TDoctor tDoctor = new TDoctor();
            tDoctor.setMessageId(tDoctorDto.getMessageId());
            tDoctor.setDataId(tDoctorDto.getDataId());
            List<TDoctor> tDoctorList = tDoctorService.selectListByCondition(tDoctor);
            switch (tDoctorDto.getOperationType()){
                case OperationType.ADD_OR_UPDATE:
                    if (A.isNotEmpty(tDoctorList)){
                        TDoctor updateOk = tDoctorService.updateByPrimarykey(tDoctorDto);
                        if (U.isBlank(updateOk)){
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        TDoctor addOk = tDoctorService.insertSelective(tDoctorDto);
                        if (U.isBlank(addOk)){
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }
                    return Result.success(ReturnMessage.ADD_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tDoctorList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tDoctorService.deleteByCondition(A.first(tDoctorList));
                    if (0 == deleteOk){
                        return Result.fail(ReturnMessage.DELETE_ERROR);
                    }
                    return Result.success(ReturnMessage.DELETE_SUCCESS);
                default:return Result.fail(ReturnMessage.OPERATIONTYPE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(ReturnMessage.EXCEPTION);
        }
    }
}
