package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TRoleMenuRefDto;
import com.bben.medical.model.medical.TRoleMenuRef;
import com.bben.medical.service.TRoleMenuRefService;
import com.bben.medical.vo.TRoleMenuRefVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/8 9:51
 */
@Api(tags = "角色菜单接口")
@RestController
@RequestMapping(value = "/roleMenuRef")
public class RoleMenuRefController extends BaseController {

    @Autowired
    private TRoleMenuRefService tRoleMenuRefService;

    @GetMapping("/selectAll")
    @ApiOperation("查询全部角色菜单信息 -> 李振伟")
    public Result selectAll(){
        List<TRoleMenuRefVo> tRoleMenuRefVoList = tRoleMenuRefService.findAllTRoleMenuRef();
        if (A.isEmpty(tRoleMenuRefVoList)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tRoleMenuRefVoList);
    }

    @GetMapping("/selectById")
    @ApiOperation("根据Id查询角色菜单信息 -> 李振伟")
    public Result selectById(@ApiParam("角色菜单Id") @RequestParam Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        TRoleMenuRefVo tRoleMenuRefVo = tRoleMenuRefService.selectByPrimaryKey(refId);
        if (U.isBlank(tRoleMenuRefVo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tRoleMenuRefVo);
    }

    @PostMapping("/addTRoleMenuRef")
    @ApiOperation("添加角色菜单信息 -> 李振伟")
    public Result addTRoleMenuRef(TRoleMenuRefDto tRoleMenuRefDto){
        TRoleMenuRef ok = tRoleMenuRefService.insertSelective(TRoleMenuRefDto.assemblyData(tRoleMenuRefDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTRoleMenuRef")
    @ApiOperation("更新角色菜单信息 -> 李振伟")
    public Result updateTRoleMenuRef(TRoleMenuRef tRoleMenuRef){
        TRoleMenuRef ok = tRoleMenuRefService.updateByPrimarykey(tRoleMenuRef);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteTRoleMenuRef")
    @ApiOperation("删除角色菜单信息 -> 李振伟")
    public Result deleteTRoleMenuRef(@ApiParam("角色菜单id") @RequestParam Integer refId){
        int ok = tRoleMenuRefService.deleteByPrimarykey(refId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @GetMapping("/findTRoleMenuRefByPage")
    @ApiOperation("根据分页查询角色菜单信息 -> 李振伟")
    public Result findTRoleMenuRefByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                         @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRoleMenuRefVo> tRoleMenuRefVoPageInfo = tRoleMenuRefService.selectByPage(pageNum,pageSize);
        if (U.isBlank(tRoleMenuRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tRoleMenuRefVoPageInfo);

    }

    @PostMapping("/findTRoleMenuRefByCondition")
    @ApiOperation("根据条件查询角色菜单信息 -> 李振伟")
    public Result findTRoleMenuRefByCondition(TRoleMenuRefDto tRoleMenuRefDto,
                                              @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRoleMenuRefVo> tRoleMenuRefVoPageInfo = tRoleMenuRefService.selectByCondition(TRoleMenuRefDto.assemblyData(tRoleMenuRefDto),pageNum,pageSize);
        if (U.isBlank(tRoleMenuRefVoPageInfo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tRoleMenuRefVoPageInfo);
     }


}
