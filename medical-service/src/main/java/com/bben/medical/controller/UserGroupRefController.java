package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TUserGroupRefDto;
import com.bben.medical.model.medical.TUserGroupRef;
import com.bben.medical.service.TUserGroupRefService;
import com.bben.medical.vo.TUserGroupRefVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 14:15
 */
@Api(tags = "用户组关联接口")
@RestController
@RequestMapping(value = "/userGroupRef")
public class UserGroupRefController extends BaseController {

    @Autowired
    private TUserGroupRefService tUserGroupRefService;


    @GetMapping("/selectAllTUserGroupRef")
    @ApiOperation("查询用户组全部数据 -> 李振伟")
    public Result selectAllTUserGroupRef(){
        List<TUserGroupRefVo> tUserGroupRefVoList = tUserGroupRefService.findAll();
        if (A.isEmpty(tUserGroupRefVoList)){
            return Result.fail("数据为空");
        }
        return Result.success("查询数据成功",tUserGroupRefVoList);
    }

    @GetMapping("/selectTUserGroupRefById")
    @ApiOperation("根据id查询用户组全部数据 -> 李振伟")
    public Result selectTUserGroupRefById(@ApiParam("用户组主键Id") Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        TUserGroupRefVo tUserGroupRefVo = tUserGroupRefService.selectByPrimaryKey(refId);
        if (U.isBlank(tUserGroupRefVo)){
            return Result.fail("查询数据为空");
        }
        return Result.success("查询数据成功",tUserGroupRefVo);
    }

    @PostMapping("/addTUserGroupRef")
    @ApiOperation("添加用户组数据 -> 李振伟")
    public Result addTUserGroupRef(TUserGroupRefDto tUserGroupRefDto){
        if (U.isBlank(tUserGroupRefDto)){
            return Result.fail("参数不能为空");
        }
        TUserGroupRef ok = tUserGroupRefService.insertSelective(TUserGroupRefDto.assemblyData(tUserGroupRefDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTUserGroupRef")
    @ApiOperation("更新用户组数据 -> 李振伟")
    public Result updateTUserGroupRef(TUserGroupRef tUserGroupRef){
        if (U.isBlank(tUserGroupRef)){
            return Result.fail("更新数据失败");
        }
        TUserGroupRef ok = tUserGroupRefService.updateByPrimarykey(tUserGroupRef);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteTUserGroupRefById")
    @ApiOperation("删除用户组数据 -> 李振伟")
    public Result deleteTUserGroupRefById(@ApiParam("用户组主键id") @RequestParam Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        int ok = tUserGroupRefService.deleteByPrimarykey(refId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");

    }

    @GetMapping("/selectTUserGroupRefByPage")
    @ApiOperation("根据分页查询用户组数据 -> 李振伟")
    public Result selectTUserGroupRefByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TUserGroupRefVo> tUserGroupRefVoPageInfo= tUserGroupRefService.selectByPage(pageNum,pageSize);
        if (U.isBlank(tUserGroupRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tUserGroupRefVoPageInfo);
    }

    @GetMapping("/selectTUserGroupRefByCondition")
    @ApiOperation("根据条件查询用户组数据 -> 李振伟")
    public Result selectTUserGroupRefByCondition(TUserGroupRef tUserGroupRef,
                                                 @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                 @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TUserGroupRefVo> tUserGroupRefVoPageInfo = tUserGroupRefService.selectByCondition(tUserGroupRef,pageNum,pageSize);
        if (U.isBlank(tUserGroupRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tUserGroupRefVoPageInfo);
    }
}
