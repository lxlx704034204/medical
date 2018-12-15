package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TBedDto;
import com.bben.bedcard.model.bedcard.TBed;
import com.bben.bedcard.service.TBedService;
import com.bben.bedcard.vo.TBedVo;
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

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 16:06
 */
@Api(tags = "床位接口")
@RestController
@RequestMapping("/bed")
public class BedController extends BaseController {

    @Autowired
    private TBedService tBedService;

    public Result addTBedError(TBedDto tBedDto){
        return Result.fail("添加床位失败");
    }

    public Result updateTBedError(TBed tBed){
        return Result.fail("更新床位失败");
    }

    @GetMapping("/selectByBedId")
    @ApiOperation("根据Id查询床位信息 -> 李振伟")
    public Result<TBedVo> selectByBedId(@ApiParam("床位Id") @RequestParam Integer bedId){
        if (U.isBlank(bedId)){
            return Result.fail("参数不能为空");
        }
        TBedVo tBedVo = tBedService.selectByPrimaryKey(bedId);
        return  Result.success("查询数据成功",tBedVo);
    }

    @PostMapping("/addTBed")
    @ApiOperation("添加床位信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTBedError")
    public Result addTBed(TBedDto tBedDto){
        if (U.isBlank(tBedDto)){
            return Result.fail("对象不能为空");
        }
        TBed ok = tBedService.insertSelective(TBedDto.assemblyData(tBedDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TBedId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTBed")
    @ApiOperation("更新床位信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTBedError")
    public Result updateTBed(TBed tHospitalDept){
        if (U.isBlank(tHospitalDept)){
            return Result.fail("对象不能为空");
        }
        TBed ok = tBedService.updateByPrimarykey(tHospitalDept);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByBedId")
    @ApiOperation("删除床位信息 -> 李振伟")
    public Result deleteByBedId(@ApiParam("床位id") @RequestParam Integer bedId){
        if (U.isBlank(bedId)){
            return Result.fail("参数不能为空");
        }
        int ok = tBedService.deleteByPrimarykey(bedId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTBedVoByCondition")
    @ApiOperation("根据条件查询床位信息 -> 李振伟")
    public  Result<List<TBedVo>> getTBedVoByCondition(TBedDto tBedDto,
                                                      @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<TBedVo> tBedVoList = tBedService.selectByCondition(TBedDto.assemblyData(tBedDto));
        if (A.isEmpty(tBedVoList)){
            return Result.success("查询床位信息成功");
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TBedVo> tBedVoPageInfo = new PageInfo<>(tBedVoList);
        return Result.success("查询床位信息成功",tBedVoPageInfo);
    }
}
