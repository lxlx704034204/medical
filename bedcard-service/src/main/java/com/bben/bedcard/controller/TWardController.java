package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TWardDto;
import com.bben.bedcard.model.bedcard.TWard;
import com.bben.bedcard.service.TWardService;
import com.bben.bedcard.vo.TWardVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "病区接口 --->  萨米国际")
@RestController
@RequestMapping("/ward")
public class TWardController extends BaseController {

    @Autowired
    private TWardService tWardService;

    public Result addTWardError(String wardInfo){
        return Result.fail("添加病区失败");
    }

    public Result updateTWardError(TWard tWard){
        return Result.fail("更新病区失败");
    }

    @GetMapping("/selectByWardId")
    @ApiOperation("根据Id查询病区信息 -> 李振伟")
    public Result<TWardVo> selectByWardId(@ApiParam("病区Id") @RequestParam Integer wardId){
        if (U.isBlank(wardId)){
            return Result.fail("参数不能为空");
        }
        TWardVo tWardVo = tWardService.selectByPrimaryKey(wardId);
        return  Result.success("查询数据成功",tWardVo);
    }

   /* @GetMapping("/saMiWard.do")
    @ApiOperation("萨米新增/更新/删除病区信息接口 -> 李振伟")
    public Result saMiWard(String  jsonWardInfo){
        if (U.isBlank(jsonWardInfo)){
            return Result.fail(ReturnMessage.PARAMETER_IS_NULL);
        }
        try {
            *//**
             * 先将json字符串转换为json对象
             *//*
            JSONObject obj = JSONObject.fromObject(jsonWardInfo);
            *//**
             * 再将json对象转换为java对象
             *//*

            TWardDto tWardDto = (TWardDto)JSONObject.toBean(obj,TWardDto.class);
            if (U.isBlank(tWardDto) || U.isBlank(tWardDto.getOperationType()) || U.isBlank(tWardDto.getDataId()) || U.isBlank(tWardDto.getMessageId())){
                return Result.fail(ReturnMessage.DATA_ERROR);
            }
            switch (tWardDto.getOperationType()){
                case OperationType.ADD:
                    TWard tWard = new TWard();
                    tWard.setMessageId(tWardDto.getMessageId());
                    List<TWardVo> tWardList = tWardService.selectByCondition(tWard);
                    if (A.isNotEmpty(tWardList)){
                        return Result.fail(ReturnMessage.DATA_ALREADY_EXISTS);
                    }
                    TWard addOk = tWardService.insertSelective(TWardDto.assemblyData(tWardDto));
                    if (U.isBlank(addOk)){
                        return Result.fail(ReturnMessage.ADD_ERROR);
                    }
                    return Result.success(ReturnMessage.ADD_SUCCESS);
                case OperationType.UPDATE:
                    TWard updateOk = tWardService.updateByPrimarykey(TWardDto.assemblyData(tWardDto));
                    if (U.isBlank(updateOk)){
                        return Result.fail(ReturnMessage.UPDATE_ERROR);
                    }
                    return Result.success(ReturnMessage.UPDATE_SUCCESS);
                case OperationType.DELETE:
                    int deleteOk = tWardService.deleteByRecord(TWardDto.assemblyData(tWardDto));
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
    }*/

    @PostMapping("/updateTWard")
    @ApiOperation("更新病区信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTWardError")
    public Result updateTWard(TWard tWard){
        if (U.isBlank(tWard)){
            return Result.fail("对象不能为空");
        }
        TWard ok = tWardService.updateByPrimarykey(tWard);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByWardId")
    @ApiOperation("删除病区信息 -> 李振伟")
    public Result deleteByWardId(@ApiParam("病区id") @RequestParam Integer wardId){
        if (U.isBlank(wardId)){
            return Result.fail("参数不能为空");
        }
        int ok = tWardService.deleteByPrimarykey(wardId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTWardVoByCondition")
    @ApiOperation("根据条件查询病区信息 -> 李振伟")
    public  Result<PageInfo<TWardVo>> getTWardVoByCondition(TWardDto tWardDto,
                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<TWardVo> tWardVoList = tWardService.selectByCondition(TWardDto.assemblyData(tWardDto));
        if (A.isEmpty(tWardVoList)){
            return Result.success("查询滨区记录成功");
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TWardVo> tWardVoPageInfo = new PageInfo<>(tWardVoList);
        return Result.success("查询病区信息成功",tWardVoPageInfo);
    }


}
