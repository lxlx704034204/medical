package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.TWardDto;
import com.bben.bedcard.model.bedcard.TWard;
import com.bben.bedcard.service.TWardService;
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
@Api(tags = "萨米病区接口 --->  李振伟")
@RestController
@RequestMapping("/saMiWard")
public class SaMiWardController extends BaseController {

    @Autowired
    private TWardService tWardService;

    public Result saMiWardError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiWard.do")
    @ApiOperation("萨米新增/更新/删除病区信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiWardError")
    public Result saMiWard(String  jsonInfo){
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

            TWardDto tWardDto = (TWardDto)JSONObject.toBean(obj,TWardDto.class);
            if (U.isBlank(tWardDto) || U.isBlank(tWardDto.getOperationType()) || U.isBlank(tWardDto.getDataId()) || U.isBlank(tWardDto.getMessageId())){
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            TWard tWard = new TWard();
            tWard.setMessageId(tWardDto.getMessageId());
            List<TWard> tWardList = tWardService.selectListByCondition(tWard);
            switch (tWardDto.getOperationType()){
                case OperationType.ADD_OR_UPDATE:
                    if (A.isNotEmpty(tWardList)){
                        TWard updateOk = tWardService.updateByPrimarykey(TWardDto.assemblyData(tWardDto));
                        if (U.isBlank(updateOk)){
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        TWard addOk = tWardService.insertSelective(TWardDto.assemblyData(tWardDto));
                        if (U.isBlank(addOk)){
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }
                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tWardList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tWardService.deleteByRecord(A.first(tWardList));
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
