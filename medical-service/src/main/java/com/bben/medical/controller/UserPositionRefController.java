package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TUserPositionRefDto;
import com.bben.medical.model.medical.TUserPositionRef;
import com.bben.medical.service.TUserPositionRefService;
import com.bben.medical.vo.TUserPositionRefVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 17:17
 */
@Api(tags = "用户岗位关联接口")
@RestController
@RequestMapping(value = "/userPositionRef")
public class UserPositionRefController extends BaseController {
    @Autowired
    private TUserPositionRefService tUserPositionRefService;

    @GetMapping("/selectAllTUserPositionRef")
    @ApiOperation("查询用户岗位全部数据 -> 李振伟")
    public Result selectAllTUserPositionRef(){
        List<TUserPositionRefVo> tUserPositionRefVoList = tUserPositionRefService.findAll();
        if (A.isEmpty(tUserPositionRefVoList)){
            return Result.fail("数据为空");
        }
        return Result.success("查询数据成功",tUserPositionRefVoList);
    }

    @GetMapping("/selectTUserPositionRefById")
    @ApiOperation("根据id查询用户岗位全部数据 -> 李振伟")
    public Result selectTUserPositionRefById(@ApiParam("用户岗位主键Id") Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        TUserPositionRefVo tUserPositionRefVo = tUserPositionRefService.selectByPrimaryKey(refId);
        if (U.isBlank(tUserPositionRefVo)){
            return Result.fail("查询数据为空");
        }
        return Result.success("查询数据成功",tUserPositionRefVo);
    }

    @PostMapping("/addTUserPositionRef")
    @ApiOperation("添加用户岗位数据 -> 李振伟")
    public Result addTUserPositionRef(TUserPositionRefDto tUserPositionRefDto){
        if (U.isBlank(tUserPositionRefDto)){
            return Result.fail("参数不能为空");
        }
        TUserPositionRef ok = tUserPositionRefService.insertSelective(TUserPositionRefDto.assemblyData(tUserPositionRefDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTUserPositionRef")
    @ApiOperation("更新用户岗位数据 -> 李振伟")
    public Result updateTUserPositionRef(TUserPositionRef tUserPositionRef){
        if (U.isBlank(tUserPositionRef)){
            return Result.fail("参数不能为空");
        }
        TUserPositionRef ok = tUserPositionRefService.updateByPrimarykey(tUserPositionRef);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteTUserPositionRefById")
    @ApiOperation("删除用户岗位数据 -> 李振伟")
    public Result deleteTUserPositionRefById(@ApiParam("用户岗位主键id") @RequestParam Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        int ok = tUserPositionRefService.deleteByPrimarykey(refId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");

    }

    @GetMapping("/selectTUserPositionRefByPage")
    @ApiOperation("根据分页查询用户岗位数据 -> 李振伟")
    public Result selectTUserPositionRefByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TUserPositionRefVo> tUserPositionRefVoPageInfo= tUserPositionRefService.selectByPage(pageNum,pageSize);
        if (U.isBlank(tUserPositionRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tUserPositionRefVoPageInfo);
    }

    @GetMapping("/selectTUserPositionRefByCondition")
    @ApiOperation("根据条件查询用户岗位数据 -> 李振伟")
    public Result selectTUserPositionRefByCondition(TUserPositionRef tUserPositionRef,
                                                 @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                 @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TUserPositionRefVo> tUserPositionRefVoPageInfo = tUserPositionRefService.selectByCondition(tUserPositionRef,pageNum,pageSize);
        if (U.isBlank(tUserPositionRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tUserPositionRefVoPageInfo);
    }
}
