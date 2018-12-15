package com.bben.bedcard.controller.sami;


import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.THospitalDeptDto;
import com.bben.bedcard.model.bedcard.THospitalDept;
import com.bben.bedcard.service.THospitalDeptService;
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
@Api(tags = "萨米医院科室接口 --->  李振伟")
@RestController
@RequestMapping("/saMiHospitalDept")
public class SaMiHospitalDeptController extends BaseController {

    @Autowired
    private THospitalDeptService tHospitalDeptService;

    public Result saMiHospitalDeptError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiHospitalDept.do")
    @ApiOperation("萨米新增/更新/删除医院信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiHospitalDeptError")
    public Result saMiHospitalDept(String jsonInfo){
        try {
            if (U.isBlank(jsonInfo)){
                return Result.fail(ReturnMessage.PARAMETER_IS_NULL);
            }
            /**
             * 先将json字符串转换为json对象
             */
            JSONObject obj = JSONObject.fromObject(jsonInfo);
            /**
             * 再将json对象转换为java对象
             */

            THospitalDeptDto tHospitalDeptDto = (THospitalDeptDto)JSONObject.toBean(obj,THospitalDeptDto.class);


            if (U.isBlank(tHospitalDeptDto) || U.isBlank(tHospitalDeptDto.getOperationType()) || U.isBlank(tHospitalDeptDto.getDataId()) || U.isBlank(tHospitalDeptDto.getMessageId())){
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            THospitalDept tHospitalDept = new THospitalDept();
            tHospitalDept.setMessageId(tHospitalDeptDto.getMessageId());
            List<THospitalDept> tHospitalDeptList = tHospitalDeptService.selectListByCondition(tHospitalDept);
            switch (tHospitalDeptDto.getOperationType()){
                case OperationType.ADD_OR_UPDATE:
                    if (A.isNotEmpty(tHospitalDeptList)){
                        THospitalDept updateOk = tHospitalDeptService.updateByPrimarykey(tHospitalDeptDto);
                        if (U.isBlank(updateOk)){
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        THospitalDept addOk = tHospitalDeptService.insertSelectiveDto(tHospitalDeptDto);
                        if (U.isBlank(addOk)){
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }
                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tHospitalDeptList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tHospitalDeptService.deleteByCondition(A.first(tHospitalDeptList));
                    if (0 == deleteOk){
                        return Result.fail(ReturnMessage.DELETE_ERROR);
                    }
                    return Result.success(ReturnMessage.DELETE_SUCCESS);
                default:return Result.fail(ReturnMessage.OPERATIONTYPE_ERROR);
            }

        } catch (Exception e){
            e.printStackTrace();
            return Result.fail(ReturnMessage.EXCEPTION);
        }
    }

}
