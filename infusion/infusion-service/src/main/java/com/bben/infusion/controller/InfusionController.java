package com.bben.infusion.controller;

import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.infusion.config.RedisTemplateUtil;
import com.bben.infusion.model.infusion.TPatient;
import com.bben.infusion.model.infusion.TWard;
import com.bben.infusion.service.TPatientService;
import com.bben.infusion.service.TWardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "输液看板接口")
@RestController
@RequestMapping(value = "/infusion")
public class InfusionController extends BaseController {

    @Autowired
    private TPatientService tPatientService;
    @Autowired
    private TWardService tWardService;

    @GetMapping("/infusionInfo")
    @ApiOperation("获取病区输液看板信息 -> lsq")
    public Result<JSONObject> selectTHospital(@ApiParam("twid") @RequestParam Integer twid) {
        JSONObject jsonObject = new JSONObject();
        //查找病区的信息
        TWard tWard = tWardService.selectByPrimaryKey(twid);
        if (U.isBlank(tWard)) return Result.success("无病区数据");

        jsonObject.put("wId",twid);
        jsonObject.put("name",tWard.getName());
        jsonObject.put("currentTime", System.currentTimeMillis());

        //查找病区正在输液的病人信息
        TPatient tPatient = new TPatient();
        tPatient.setWardId(String.valueOf(twid));
        //接口相当于第一次请求不推送语音 false
        JSONArray jsonArray = tPatientService.findPatientInfusionByCondition(true,tPatient);
        jsonObject.put("info",jsonArray);

        return Result.success("获取病区输液看板信息成功", jsonObject);
    }

    @GetMapping("/infusionPatient")
    @ApiOperation("获取病区输液看板病人信息 -> lsq")
    public Result<JSONObject> selectTPatient(@ApiParam("pid") @RequestParam Integer pid) {
        TPatient tPatient = tPatientService.selectByPrimaryKey(pid);
        if (U.isBlank(tPatient)) return Result.success("无病人数据");

        return Result.success("获取病区输液看板病人信息成功", tPatient);
    }

}
