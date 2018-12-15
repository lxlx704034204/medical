package com.bben.bedcard.controller.sami;

import com.bben.bedcard.constants.ReturnMessage;
import com.bben.bedcard.dto.TDeptDto;
import com.bben.bedcard.model.bedcard.TDept;
import com.bben.bedcard.service.TDeptService;
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

@Api(tags = "萨米科室接口 --->  李振伟")
@RestController
@RequestMapping("/saMiDept")
public class SaMiDeptController extends BaseController {

    @Autowired
    private TDeptService tDeptService;

    public Result saMiDeptError(String jsonInfo) {
        return Result.fail(ReturnMessage.EXCEPTION);
    }

    @PostMapping("/saMiDept.do")
    @ApiOperation("萨米新增/更新/删除科室信息接口 -> 李振伟")
    @HystrixCommand(fallbackMethod = "saMiDeptError")
    public Result saMiDept(String jsonInfo){
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
            TDeptDto tDeptDto = (TDeptDto)JSONObject.toBean(obj,TDeptDto.class);
            if (U.isBlank(tDeptDto) || U.isBlank(tDeptDto.getOperationType()) || U.isBlank(tDeptDto.getDataId()) || U.isBlank(tDeptDto.getMessageId())){
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            TDept tDept = new TDept();
            tDept.setMessageId(tDeptDto.getMessageId());
            tDept.setDataId(tDeptDto.getDataId());
            List<TDept> tDeptList = tDeptService.selectListByCondition(tDept);
            switch (tDeptDto.getOperationType()){
                case OperationType.ADD_OR_UPDATE:
                    if (A.isNotEmpty(tDeptList)){
                        TDept updateOk = tDeptService.updateByPrimarykey(TDeptDto.assemblyData(tDeptDto));
                        if (U.isBlank(updateOk)){
                            return Result.fail(ReturnMessage.UPDATE_ERROR);
                        }
                    }else {
                        TDept addOk = tDeptService.insertSelective(TDeptDto.assemblyData(tDeptDto));
                        if (U.isBlank(addOk)){
                            return Result.fail(ReturnMessage.ADD_ERROR);
                        }
                    }
                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    if (A.isEmpty(tDeptList)){
                        return Result.fail(ReturnMessage.DATA_NOT_EXISTS);
                    }
                    int deleteOk = tDeptService.deleteByCondition(A.first(tDeptList));
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
