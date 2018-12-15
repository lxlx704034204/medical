package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TPatientDto;
import com.bben.bedcard.model.bedcard.TPatient;
import com.bben.bedcard.service.TPatientService;
import com.bben.bedcard.vo.TPatientVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 17:40
 */
@Api(tags = "病人接口")
@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController {

    @Autowired
    private TPatientService tPatientService;

    public Result addTPatientError(TPatientDto tPatientDto){
        return Result.fail("添加病人失败");
    }

    public Result updateTPatientError(TPatient tDept){
        return Result.fail("更新病人失败");
    }

    @GetMapping("/selectByPatientId")
    @ApiOperation("根据Id查询病人信息 -> 李振伟")
    public Result<TPatientVo> selectByPatientId(@ApiParam("病人Id") @RequestParam Integer patientId){
        if (U.isBlank(patientId)){
            return Result.fail("参数不能为空");
        }
        TPatientVo tPatientVo = tPatientService.selectByPrimaryKey(patientId);
        return  Result.success("查询数据成功",tPatientVo);
    }

    @PostMapping("/addTPatient")
    @ApiOperation("添加病人信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTPatientError")
    public Result addTPatient(TPatientDto tPatientDto){
        if (U.isBlank(tPatientDto)){
            return Result.fail("对象不能为空");
        }
        TPatient ok = tPatientService.insertSelective(TPatientDto.assemblyData(tPatientDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TPatientId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTPatient")
    @ApiOperation("更新病人信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTPatientError")
    public Result updateTPatient(TPatient tPatient){
        if (U.isBlank(tPatient)){
            return Result.fail("对象不能为空");
        }
        TPatient ok = tPatientService.updateByPrimarykey(tPatient);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByPatientId")
    @ApiOperation("删除病人信息 -> 李振伟")
    public Result deleteByPatientId(@ApiParam("病人id") @RequestParam Integer patientId){
        if (U.isBlank(patientId)){
            return Result.fail("参数不能为空");
        }
        int ok = tPatientService.deleteByPrimarykey(patientId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTPatientVoByCondition")
    @ApiOperation("根据条件查询病人信息 -> 李振伟")
    public  Result<PageInfo<TPatientVo>> getTPatientVoByCondition(TPatientDto tPatientDto,
                                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){

        List<TPatientVo> tPatientVoList = tPatientService.selectByCondition(TPatientDto.assemblyData(tPatientDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TPatientVo> tPatientVoPageInfo = new PageInfo<>(tPatientVoList);
        return Result.success("查询病人信息成功",tPatientVoPageInfo);
    }
}
