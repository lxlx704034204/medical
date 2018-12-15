package com.bben.bedcard.controller;

import com.bben.bedcard.dto.THospitalizationExpensesDayDto;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDay;
import com.bben.bedcard.service.THospitalizationExpensesDayService;
import com.bben.bedcard.vo.THospitalizationExpensesDayVo;
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

@Api(tags = "日住院费用接口")
@RestController
@RequestMapping("/hospitalizationExpensesDay")
public class HospitalizationExpensesDayController extends BaseController {
    @Autowired
    private THospitalizationExpensesDayService tHospitalizationExpensesDayService;

    public Result addTHospitalizationExpensesDayError(THospitalizationExpensesDayDto tHospitalizationExpensesDayDto){
        return Result.fail("添加日住院费用失败");
    }

    public Result updateTHospitalizationExpensesDayError(THospitalizationExpensesDay tHospitalizationExpensesDay){
        return Result.fail("更新日住院费用失败");
    }

    @GetMapping("/selectByHospitalizationExpensesDayId")
    @ApiOperation("根据Id查询日住院费用信息 -> 李振伟")
    public Result<THospitalizationExpensesDayVo> selectByHospitalizationExpensesDayId(@ApiParam("日住院费用Id") @RequestParam Integer hospitalizationExpensesDayId){
        if (U.isBlank(hospitalizationExpensesDayId)){
            return Result.fail("参数不能为空");
        }
        THospitalizationExpensesDayVo tHospitalizationExpensesDayVo = tHospitalizationExpensesDayService.selectByPrimaryKey(hospitalizationExpensesDayId);
        return  Result.success("查询数据成功",tHospitalizationExpensesDayVo);
    }

    @PostMapping("/addTHospitalizationExpensesDay")
    @ApiOperation("添加日住院费用信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTHospitalizationExpensesDayError")
    public Result addTHospitalizationExpensesDay(THospitalizationExpensesDayDto tHospitalizationExpensesDayDto){
        if (U.isBlank(tHospitalizationExpensesDayDto)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpensesDay ok = tHospitalizationExpensesDayService.insertSelective(THospitalizationExpensesDayDto.assemblyData(tHospitalizationExpensesDayDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("HospitalizationExpensesDay : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTHospitalizationExpensesDay")
    @ApiOperation("更新日住院费用信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTHospitalizationExpensesDayError")
    public Result updateTHospitalizationExpensesDay(THospitalizationExpensesDay tHospitalizationExpensesDay){
        if (U.isBlank(tHospitalizationExpensesDay)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpensesDay ok = tHospitalizationExpensesDayService.updateByPrimarykey(tHospitalizationExpensesDay);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByHospitalizationExpensesDayId")
    @ApiOperation("删除日住院费用信息 -> 李振伟")
    public Result deleteByHospitalizationExpensesDayId(@ApiParam("日住院费用id") @RequestParam Integer hospitalizationExpensesDayId){
        if (U.isBlank(hospitalizationExpensesDayId)){
            return Result.fail("参数不能为空");
        }
        int ok = tHospitalizationExpensesDayService.deleteByPrimarykey(hospitalizationExpensesDayId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTHospitalizationExpensesDayVoAllByCondition")
    @ApiOperation("根据条件查询所有日住院费用 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesDayVo>> getTHospitalizationExpensesDayVoAllByCondition(THospitalizationExpensesDayDto tHospitalizationExpensesDayDto){
        List<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoList = tHospitalizationExpensesDayService.selectByCondition(THospitalizationExpensesDayDto.assemblyData(tHospitalizationExpensesDayDto));
        return Result.success("查询日住院费用信息成功",tHospitalizationExpensesDayVoList);
    }

    @PostMapping("/getTHospitalizationExpensesDayVoByCondition")
    @ApiOperation("根据条件查询日住院费用信息 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesDayVo>> getTHospitalizationExpensesDayVoByCondition(THospitalizationExpensesDayDto tHospitalizationExpensesDayDto,
                                                                      @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoList = tHospitalizationExpensesDayService.selectByCondition(THospitalizationExpensesDayDto.assemblyData(tHospitalizationExpensesDayDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<THospitalizationExpensesDayVo> tHospitalizationExpensesDayVoPageInfo = new PageInfo<>(tHospitalizationExpensesDayVoList);
        return Result.success("查询日住院费用信息成功",tHospitalizationExpensesDayVoPageInfo);
    }
}
