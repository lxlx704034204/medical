package com.bben.bedcard.controller;

import com.bben.bedcard.dto.THospitalizationExpensesDetailDto;
import com.bben.bedcard.model.bedcard.THospitalizationExpensesDetail;
import com.bben.bedcard.service.THospitalizationExpensesDetailService;
import com.bben.bedcard.vo.THospitalizationExpensesDetailVo;
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

@Api(tags = "收费详情接口")
@RestController
@RequestMapping("/hospitalizationExpensesDetail")
public class HospitalizationExpensesDetailController extends BaseController {
    @Autowired
    private THospitalizationExpensesDetailService tHospitalizationExpensesDetailService;

    public Result addTHospitalizationExpensesDetailError(THospitalizationExpensesDetailDto tHospitalizationExpensesDetailDto){
        return Result.fail("添加收费详情失败");
    }

    public Result updateTHospitalizationExpensesDetailError(THospitalizationExpensesDetail tHospitalizationExpensesDetail){
        return Result.fail("更新收费详情失败");
    }

    @GetMapping("/selectByHospitalizationExpensesDetailId")
    @ApiOperation("根据Id查询收费详情信息 -> 李振伟")
    public Result<THospitalizationExpensesDetailVo> selectByHospitalizationExpensesDetailId(@ApiParam("收费详情Id") @RequestParam Integer hospitalizationExpensesDetailId){
        if (U.isBlank(hospitalizationExpensesDetailId)){
            return Result.fail("参数不能为空");
        }
        THospitalizationExpensesDetailVo tHospitalizationExpensesDetailVo = tHospitalizationExpensesDetailService.selectByPrimaryKey(hospitalizationExpensesDetailId);
        return  Result.success("查询数据成功",tHospitalizationExpensesDetailVo);
    }

    @PostMapping("/addTHospitalizationExpensesDetail")
    @ApiOperation("添加收费详情信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTHospitalizationExpensesDetailError")
    public Result addTHospitalizationExpensesDetail(THospitalizationExpensesDetailDto tHospitalizationExpensesDetailDto){
        if (U.isBlank(tHospitalizationExpensesDetailDto)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpensesDetail ok = tHospitalizationExpensesDetailService.insertSelective(THospitalizationExpensesDetailDto.assemblyData(tHospitalizationExpensesDetailDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TRoleId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTHospitalizationExpensesDetail")
    @ApiOperation("更新收费详情信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTHospitalizationExpensesDetailError")
    public Result updateTHospitalizationExpensesDetail(THospitalizationExpensesDetail tHospitalizationExpensesDetail){
        if (U.isBlank(tHospitalizationExpensesDetail)){
            return Result.fail("对象不能为空");
        }
        THospitalizationExpensesDetail ok = tHospitalizationExpensesDetailService.updateByPrimarykey(tHospitalizationExpensesDetail);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByHospitalizationExpensesDetailId")
    @ApiOperation("删除收费详情信息 -> 李振伟")
    public Result deleteByHospitalizationExpensesDetailId(@ApiParam("收费详情id") @RequestParam Integer hospitalizationExpensesDetailId){
        if (U.isBlank(hospitalizationExpensesDetailId)){
            return Result.fail("参数不能为空");
        }
        int ok = tHospitalizationExpensesDetailService.deleteByPrimarykey(hospitalizationExpensesDetailId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTHospitalizationExpensesDetailVoAllByCondition")
    @ApiOperation("根据条件查询所有收费详情 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesDetailVo>> getTHospitalizationExpensesDetailVoAllByCondition(THospitalizationExpensesDetailDto tHospitalizationExpensesDetailDto){
        List<THospitalizationExpensesDetailVo> tHospitalizationExpensesDetailVoList = tHospitalizationExpensesDetailService.selectByCondition(THospitalizationExpensesDetailDto.assemblyData(tHospitalizationExpensesDetailDto));
        return Result.success("查询收费详情信息成功",tHospitalizationExpensesDetailVoList);
    }

    @PostMapping("/getTHospitalizationExpensesDetailVoByCondition")
    @ApiOperation("根据条件查询收费详情信息 -> 李振伟")
    public  Result<PageInfo<THospitalizationExpensesDetailVo>> getTHospitalizationExpensesDetailVoByCondition(THospitalizationExpensesDetailDto tHospitalizationExpensesDetailDto,
                                                                      @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<THospitalizationExpensesDetailVo> tHospitalizationExpensesDetailVoList = tHospitalizationExpensesDetailService.selectByCondition(THospitalizationExpensesDetailDto.assemblyData(tHospitalizationExpensesDetailDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<THospitalizationExpensesDetailVo> tHospitalizationExpensesDetailVoPageInfo = new PageInfo<>(tHospitalizationExpensesDetailVoList);
        return Result.success("查询收费详情信息成功",tHospitalizationExpensesDetailVoPageInfo);
    }
}
