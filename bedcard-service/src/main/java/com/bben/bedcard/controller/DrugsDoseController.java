package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TDrugsDoseDto;
import com.bben.bedcard.model.bedcard.TDrugsDose;
import com.bben.bedcard.service.TDrugsDoseService;
import com.bben.bedcard.vo.TDrugsDoseVo;
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

@Api(tags = "药品剂量表接口")
@RestController
@RequestMapping("/drugsDose")
public class DrugsDoseController extends BaseController {
    @Autowired
    private TDrugsDoseService tDrugsDoseService;

    public Result addTDrugsDoseError(TDrugsDoseDto tDrugsDoseDto){
        return Result.fail("添加药品剂量失败");
    }

    public Result updateTDrugsDoseError(TDrugsDose tDrugsDose){
        return Result.fail("更新药品剂量失败");
    }

    @GetMapping("/selectByDrugsDoseId")
    @ApiOperation("根据Id查询药品剂量信息 -> 李振伟")
    public Result<TDrugsDoseVo> selectByDrugsDoseId(@ApiParam("药品剂量Id") @RequestParam Integer drugsDoseId){
        if (U.isBlank(drugsDoseId)){
            return Result.fail("参数不能为空");
        }
        TDrugsDoseVo tDrugsDoseVo = tDrugsDoseService.selectByPrimaryKey(drugsDoseId);
        return  Result.success("查询数据成功",tDrugsDoseVo);
    }

    @PostMapping("/addTDrugsDose")
    @ApiOperation("添加药品剂量信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTDrugsDoseError")
    public Result addTDrugsDose(TDrugsDoseDto tDrugsDoseDto){
        if (U.isBlank(tDrugsDoseDto)){
            return Result.fail("对象不能为空");
        }
        TDrugsDose ok = tDrugsDoseService.insertSelective(TDrugsDoseDto.assemblyData(tDrugsDoseDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TRoleId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTDrugsDose")
    @ApiOperation("更新药品剂量信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTDrugsDoseError")
    public Result updateTDrugsDose(TDrugsDose tDrugsDose){
        if (U.isBlank(tDrugsDose)){
            return Result.fail("对象不能为空");
        }
        TDrugsDose ok = tDrugsDoseService.updateByPrimarykey(tDrugsDose);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByDrugsDoseId")
    @ApiOperation("删除药品剂量信息 -> 李振伟")
    public Result deleteByDrugsDoseId(@ApiParam("药品剂量id") @RequestParam Integer drugsDoseId){
        if (U.isBlank(drugsDoseId)){
            return Result.fail("参数不能为空");
        }
        int ok = tDrugsDoseService.deleteByPrimarykey(drugsDoseId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTDrugsDoseVoAllByCondition")
    @ApiOperation("根据条件查询所有药品剂量 -> 李振伟")
    public  Result<PageInfo<TDrugsDoseVo>> getTDrugsDoseVoAllByCondition(TDrugsDoseDto tDrugsDoseDto){
        List<TDrugsDoseVo> tDrugsDoseVoList = tDrugsDoseService.selectByCondition(TDrugsDoseDto.assemblyData(tDrugsDoseDto));
        return Result.success("查询药品剂量信息成功",tDrugsDoseVoList);
    }

    @PostMapping("/getTDrugsDoseVoByCondition")
    @ApiOperation("根据条件查询药品剂量信息 -> 李振伟")
    public  Result<PageInfo<TDrugsDoseVo>> getTDrugsDoseVoByCondition(TDrugsDoseDto tDrugsDoseDto,
                                                                                    @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                                    @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<TDrugsDoseVo> tDrugsDoseVoList = tDrugsDoseService.selectByCondition(TDrugsDoseDto.assemblyData(tDrugsDoseDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TDrugsDoseVo> tDrugsDoseVoPageInfo = new PageInfo<>(tDrugsDoseVoList);
        return Result.success("查询药品剂量信息成功",tDrugsDoseVoPageInfo);
    }
}
