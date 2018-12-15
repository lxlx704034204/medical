package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.TNurseDto;
import com.bben.bedcard.model.bedcard.TNurse;
import com.bben.bedcard.service.TNurseService;
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

@Api(tags = "萨米医院护士接口 --->  李振伟")
@RestController
@RequestMapping("/saMiNurse")
public class SaMiNurseController extends BaseController {

    @Autowired
    private TNurseService tNurseService;

    public Result saMiNurseError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiNurse.do")
    @ApiOperation("萨米新增/更新/删除病人信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiNurseError")
    public Result saMiNurse(String jsonInfo) {
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

            TNurseDto tNurseDto = (TNurseDto) JSONObject.toBean(obj, TNurseDto.class);
            if (U.isBlank(tNurseDto) || U.isBlank(tNurseDto.getOperationType()) || U.isBlank(tNurseDto.getDataId()) || U.isBlank(tNurseDto.getMessageId())) {
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            if (tNurseDto.getOperationType().equals(OperationType.ADD_OR_UPDATE)){
                if (U.isBlank(tNurseDto.getHospitalDeptDataId())){
                    return Result.fail(ReturnMessage.DATA_ERROR);
                }
            }
            TNurse tNurse = new TNurse();
            tNurse.setDataId(tNurseDto.getDataId());
            tNurse.setMessageId(tNurseDto.getMessageId());
            List<TNurse> tNurseList = tNurseService.selectListByCondition(tNurse);
            switch (tNurseDto.getOperationType()) {
                case OperationType.ADD_OR_UPDATE:
                    if (A.isNotEmpty(tNurseList)) {
                        TNurse updateOk = tNurseService.updateByPrimarykey(tNurseDto);
                        if (U.isBlank(updateOk)) {
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        TNurse addOk = tNurseService.insertSelective(tNurseDto);
                        if (U.isBlank(addOk)) {
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }

                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tNurseList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tNurseService.deleteByCondition(A.first(tNurseList));
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
