package com.bben.bedcard.controller;

import com.bben.bedcard.dto.THospitalDto;
import com.bben.bedcard.model.bedcard.THospital;
import com.bben.bedcard.service.THospitalService;
import com.bben.bedcard.vo.THospitalVo;
import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/13 17:12
 */
@Api(tags = "医院接口")
@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController {

    @Autowired
    private THospitalService tHospitalService;

    @GetMapping("/selectAll")
    @ApiOperation("查询所有医院接口 -> 李振伟")
    public Result<List<THospitalVo>> selectAll(){
        List<THospitalVo> tHospitalVoList = tHospitalService.findAllTHospital();
        if (A.isEmpty(tHospitalVoList)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tHospitalVoList);
    }

    @GetMapping("/selectByHospitalId")
    @ApiOperation("根据id查询医院信息 -> 李振伟")
    public Result<THospitalVo> selectByHospitalId(@ApiParam("医院主键id") @RequestParam Integer hospitalId){
        if (U.isBlank(hospitalId)){
            return Result.fail("参数不能为空");
        }
        THospitalVo tHospitalVo = tHospitalService.selectByPrimaryKey(hospitalId);
        if (U.isBlank(tHospitalVo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tHospitalVo);
    }

    @PostMapping("/addHospital")
    @ApiOperation("添加医院数据接口 -> 李振伟")
    public Result addHospital(THospitalDto tHospitalDto){
        if (U.isBlank(tHospitalDto)){
            return Result.fail("参数不能为空");
        }
        THospital ok = tHospitalService.insertSelective(THospitalDto.assemblyData(tHospitalDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateHospital")
    @ApiOperation(("更新医院数据接口 -> 李振伟"))
    public Result updateHospital(THospital tHospital){
        if (U.isBlank(tHospital)){
            return Result.fail("参数不能为空");
        }
        THospital ok = tHospitalService.updateByPrimarykey(tHospital);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteByHospitalId")
    @ApiOperation("删除医院数据接口 -> 李振伟")
    public Result deleteByHospitalId(@ApiParam("医院主键id") Integer hospitalId){
        if(U.isBlank(hospitalId)){
            return Result.fail("参数不能为空");
        }
        int ok = tHospitalService.deleteByPrimarykey(hospitalId);
        if (0 == ok){
            return Result.fail("删除医院数据失败");
        }
        return Result.success("删除医院数据成功");
    }



}
