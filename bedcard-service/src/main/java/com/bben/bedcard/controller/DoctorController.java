package com.bben.bedcard.controller;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 15:16
 */

import com.bben.bedcard.dto.TDoctorDto;
import com.bben.bedcard.model.bedcard.TDoctor;
import com.bben.bedcard.service.TDoctorService;
import com.bben.bedcard.vo.TDoctorVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医生接口")
@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController {

    @Autowired
    private TDoctorService tDoctorService;

    @GetMapping("/selectAllDoctor")
    @ApiOperation("查询所有医生接口 -> 李振伟")
    public Result<List<TDoctorVo>> selectAllDoctor(){
        List<TDoctorVo> tDoctorVoList = tDoctorService.findAllTDoctor();
        if (A.isEmpty(tDoctorVoList)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tDoctorVoList);
    }

    @GetMapping("/selectByDoctorId")
    @ApiOperation("查询医生详细信息接口 -> 李振伟")
    public Result<TDoctorVo> selectByDoctorId(@ApiParam("医生id") @RequestParam Integer doctorId){
        if (U.isBlank(doctorId)){
            return Result.fail("参数不能为空");
        }
        TDoctorVo tDoctorVo = tDoctorService.selectByPrimaryKey(doctorId);
        if (U.isBlank(tDoctorVo)){
            return Result.fail("查询数据为空");
        }
        return Result.success("查询数据成功",tDoctorVo);
    }

    @PostMapping("/addDoctor")
    @ApiOperation("添加医生信息 -> 李振伟")
    public Result addDoctor(TDoctorDto tDoctorDto){
        if (U.isBlank(tDoctorDto)){
            return Result.fail("参数不能为空");
        }
        TDoctor ok = tDoctorService.insertSelective(tDoctorDto);
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateDoctor")
    @ApiOperation("更新医生信息 -> 李振伟")
    public Result updateDoctor(TDoctor tDoctor){
        if (U.isBlank(tDoctor)){
            return Result.fail("参数不能为空");
        }
        TDoctorDto tDoctorDto = JsonUtil.convert(tDoctor,TDoctorDto.class);
        TDoctor ok = tDoctorService.updateByPrimarykey(tDoctorDto);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteDoctor")
    @ApiOperation("删除医生信息 -> 李振伟")
    public Result deleteDoctor(@ApiParam("医生id") @RequestParam Integer doctorId){
        int ok = tDoctorService.deleteByPrimarykey(doctorId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/findDoctorByCondition")
    @ApiOperation("根据条件查询医生分页信息 -> 李振伟")
    public Result<PageInfo<TDoctorVo>> findDoctorByCondition(TDoctorDto tDoctorDto,
                                                             @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                             @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<TDoctorVo> tDoctorVoList = tDoctorService.selectByCondition(TDoctorDto.assemblyData(tDoctorDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TDoctorVo> tDoctorVoPageInfo = new PageInfo<>(tDoctorVoList);
        if (U.isBlank(tDoctorVoPageInfo)){
            return Result.fail("查询数据为空");
        }
        return Result.success("查询数据成功",tDoctorVoPageInfo);
    }
}
