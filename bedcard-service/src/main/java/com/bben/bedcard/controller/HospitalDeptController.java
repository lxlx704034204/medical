package com.bben.bedcard.controller;

import com.bben.bedcard.dto.THospitalDeptDto;
import com.bben.bedcard.model.bedcard.THospitalDept;
import com.bben.bedcard.service.THospitalDeptService;
import com.bben.bedcard.vo.THospitalDeptVo;
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
 * @Date: 2018/11/16 14:54
 */
@Api(tags = "医院医院科室接口")
@RestController
@RequestMapping("/hospitalDept")
public class HospitalDeptController extends BaseController {
    
    @Autowired
    private THospitalDeptService tHospitalDeptService;

    public Result addTHospitalDeptError(THospitalDeptDto tHospitalDeptDto){
        return Result.fail("添加医院科室失败");
    }

    public Result updateTHospitalDeptError(THospitalDept tDept){
        return Result.fail("更新医院科室失败");
    }

    @GetMapping("/selectByHospitalDeptId")
    @ApiOperation("根据Id查询医院科室信息 -> 李振伟")
    public Result<THospitalDeptVo> selectByHospitalDeptId(@ApiParam("医院科室Id") @RequestParam Integer hospitalDeptId){
        if (U.isBlank(hospitalDeptId)){
            return Result.fail("参数不能为空");
        }
        THospitalDeptVo tHospitalDeptVo = tHospitalDeptService.selectByPrimaryKey(hospitalDeptId);
        return  Result.success("查询数据成功",tHospitalDeptVo);
    }

    @PostMapping("/addTHospitalDept")
    @ApiOperation("添加医院科室信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTHospitalDeptError")
    public Result addTHospitalDept(THospitalDeptDto tHospitalDeptDto){
        if (U.isBlank(tHospitalDeptDto)){
            return Result.fail("对象不能为空");
        }
        THospitalDept ok = tHospitalDeptService.insertSelective(THospitalDeptDto.assemblyData(tHospitalDeptDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("THospitalDeptId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTHospitalDept")
    @ApiOperation("更新医院科室信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTHospitalDeptError")
    public Result updateTHospitalDept(THospitalDept tHospitalDept){
        if (U.isBlank(tHospitalDept)){
            return Result.fail("对象不能为空");
        }
        //THospitalDept ok = tHospitalDeptService.updateByPrimarykey(THospitalDepttHospitalDept);
        THospitalDept ok = null;
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByHospitalDeptId")
    @ApiOperation("删除医院科室信息 -> 李振伟")
    public Result deleteByHospitalDeptId(@ApiParam("医院科室id") @RequestParam Integer hospitalDeptId){
        if (U.isBlank(hospitalDeptId)){
            return Result.fail("参数不能为空");
        }
        int ok = tHospitalDeptService.deleteByPrimarykey(hospitalDeptId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTHospitalDeptVoByCondition")
    @ApiOperation("根据条件查询医院科室信息 -> 李振伟")
    public  Result<PageInfo<THospitalDeptVo>> getTHospitalDeptVoByCondition(THospitalDeptDto tHospitalDeptDto,
                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<THospitalDeptVo> tHospitalDeptVoList = tHospitalDeptService.selectByCondition(THospitalDeptDto.assemblyData(tHospitalDeptDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<THospitalDeptVo> tHospitalDeptVoPageInfo = new PageInfo<>(tHospitalDeptVoList);
        return Result.success("查询医院科室信息成功",tHospitalDeptVoPageInfo);
    }
}
