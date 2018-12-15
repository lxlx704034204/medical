package com.bben.bedcard.controller;

import com.bben.bedcard.dto.THospitalizationExpensesDto;
import com.bben.bedcard.model.bedcard.THospitalizationExpenses;
import com.bben.bedcard.service.THospitalizationExpensesService;
import com.bben.bedcard.vo.THospitalizationExpensesVo;
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

@Api(tags = "住院费用接口")
@RestController
@RequestMapping("/hospitalizationExpenses")
public class HospitalizationExpensesController extends BaseController {

    @Autowired
    private THospitalizationExpensesService tHospitalizationExpensesService;

    public Result addTHospitalizationExpensesError(THospitalizationExpensesDto tHospitalizationExpensesDto){
        return Result.fail("添加住院费用失败");
    }

    public Result updateTHospitalizationExpensesError(THospitalizationExpenses tHospitalizationExpenses){
        return Result.fail("更新住院费用失败");
    }

    @GetMapping("/selectByHospitalizationExpensesId")
    @ApiOperation("根据Id查询住院费用信息 -> 李振伟")
    public Result<THospitalizationExpensesVo> selectByHospitalizationExpensesId(@ApiParam("住院费用Id") @RequestParam Integer hospitalizationExpensesId){
        if (U.isBlank(hospitalizationExpensesId)){
            return Result.fail("参数不能为空");
        }
        THospitalizationExpensesVo tHospitalizationExpensesVo = tHospitalizationExpensesService.selectByPrimaryKey(hospitalizationExpensesId);
        return  Result.success("查询数据成功",tHospitalizationExpensesVo);
    }

    @PostMapping("/addTHospitalizationExpenses")
    @ApiOperation("添加住院费用信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTHospitalizationExpensesError")
    public Result addTHospitalizationExpenses(THospitalizationExpensesDto tHospitalizationExpensesDto){
        if (U.isBlank(tHospitalizationExpensesDto)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpenses ok = tHospitalizationExpensesService.insertSelective(THospitalizationExpensesDto.assemblyData(tHospitalizationExpensesDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("HospitalizationExpensesId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTHospitalizationExpenses")
    @ApiOperation("更新住院费用信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTHospitalizationExpensesError")
    public Result updateTHospitalizationExpenses(THospitalizationExpenses tHospitalizationExpenses){
        if (U.isBlank(tHospitalizationExpenses)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpenses ok = tHospitalizationExpensesService.updateByPrimarykey(tHospitalizationExpenses);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByHospitalizationExpensesId")
    @ApiOperation("删除住院费用信息 -> 李振伟")
    public Result deleteByHospitalizationExpensesId(@ApiParam("住院费用id") @RequestParam Integer hospitalizationExpensesId){
        if (U.isBlank(hospitalizationExpensesId)){
            return Result.fail("参数不能为空");
        }
        int ok = tHospitalizationExpensesService.deleteByPrimarykey(hospitalizationExpensesId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTHospitalizationExpensesVoAllByCondition")
    @ApiOperation("根据条件查询所有住院费用 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesVo>> getTHospitalizationExpensesVoAllByCondition(THospitalizationExpensesDto tHospitalizationExpensesDto){
        List<THospitalizationExpensesVo> tHospitalizationExpensesVoList = tHospitalizationExpensesService.selectByCondition(THospitalizationExpensesDto.assemblyData(tHospitalizationExpensesDto));
        return Result.success("查询住院费用信息成功",tHospitalizationExpensesVoList);
    }

    @PostMapping("/getTHospitalizationExpensesVoByCondition")
    @ApiOperation("根据条件查询住院费用信息 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesVo>> getTHospitalizationExpensesVoByCondition(THospitalizationExpensesDto tHospitalizationExpensesDto,
                                                                      @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<THospitalizationExpensesVo> tHospitalizationExpensesVoList = tHospitalizationExpensesService.selectByCondition(THospitalizationExpensesDto.assemblyData(tHospitalizationExpensesDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<THospitalizationExpensesVo> tHospitalizationExpensesVoPageInfo = new PageInfo<>(tHospitalizationExpensesVoList);
        return Result.success("查询住院费用信息成功",tHospitalizationExpensesVoPageInfo);
    }

    @GetMapping("/selectThisAndDetailById")
    @ApiOperation("根据Id查询住院费用及详情信息 ------> 李振伟")
    public Result<THospitalizationExpensesVo> selectThisAndDetailById(@ApiParam("住院费用Id") @RequestParam Integer hospitalizationExpensesId){
        if (U.isBlank(hospitalizationExpensesId)){
            return Result.fail("参数不能为空");
        }
        THospitalizationExpensesVo tHospitalizationExpensesVo = tHospitalizationExpensesService.selectByPrimaryKeyAndDetail(hospitalizationExpensesId);
        return  Result.success("查询数据成功",tHospitalizationExpensesVo);
    }

    @PostMapping("/getThisAndDetailAllByCondition")
    @ApiOperation("根据条件查询所有住院费用及详情信息 ------> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesVo>> getTHospitalizationExpensesVoAndDetailAllByCondition(THospitalizationExpensesDto tHospitalizationExpensesDto){
        List<THospitalizationExpensesVo> tHospitalizationExpensesVoList = tHospitalizationExpensesService.selectByConditionAndDetail(THospitalizationExpensesDto.assemblyData(tHospitalizationExpensesDto));
        return Result.success("查询住院费用信息成功",tHospitalizationExpensesVoList);
    }


}
