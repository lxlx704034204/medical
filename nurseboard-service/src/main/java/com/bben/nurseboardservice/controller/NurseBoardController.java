package com.bben.nurseboardservice.controller;

import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.bben.nurseboardservice.constants.ReturnMessage;
import com.bben.nurseboardservice.service.NurseBoardService;
import com.bben.nurseboardservice.vo.NurseBoardPatientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BBEN_LI
 */
@Api(tags = "护理看板接口")
@RestController
@RequestMapping("/nurseBoard")
public class NurseBoardController extends BaseController {

    @Autowired
    private NurseBoardService nurseBoardService;

    @GetMapping("/selectAllPatientByWard")
    @ApiOperation("根据病区id查询病区所在病人的信息")
    public Result selectAllPatientByWard(@ApiParam("病区id") @RequestParam Integer wardId){
        if (U.isBlank(wardId)){
            return Result.fail(ReturnMessage.PARAM_IS_NULL);
        }
        NurseBoardPatientVo nurseBoardPatientVo = nurseBoardService.selectByWardId(wardId);
        if (U.isBlank(nurseBoardPatientVo)){
            return Result.fail(ReturnMessage.WARD_DATE_IS_NULL);
        }
        return Result.success(ReturnMessage.SUCCECSS,nurseBoardPatientVo);
    }
}
