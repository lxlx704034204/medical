package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TGroupDto;
import com.bben.medical.model.medical.TGroup;
import com.bben.medical.service.TGroupService;
import com.bben.medical.vo.TGroupVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 15:53
 */
@Api(tags = "用户组接口")
@RestController
@RequestMapping(value = "/group")
public class GroupController extends BaseController {


    @Autowired
    private TGroupService tGroupService;

    @Autowired
    RestTemplate restTemplate;

    public Result addTGroupError(TGroupDto tGroupDto){
        return Result.fail("添加用户组数据失败");
    }

    public Result updateTGroupError(TGroup tGroup   ){
        return Result.fail("更新用户组数据失败");
    }

    @GetMapping("/selectAllGroup")
    @ApiOperation("获取岗位信息 -> 李振伟")
    public Result selectAllGroup(){
        List<TGroup> tGroupList = tGroupService.findAllTGroup();
        if (A.isEmpty(tGroupList)){
            return Result.fail("无用户组数据");
        }
        return Result.success("数据获取成功", TGroupVo.assemblyDataList(tGroupList));
    }

    @GetMapping("/selectGroupById")
    @ApiOperation("根据主键获取岗位信息 -> 李振伟")
    public Result selectGroupById(@ApiParam("岗位Id") @RequestParam Integer groupId){
        TGroup tGroup = tGroupService.selectByPrimaryKey(groupId);
        if (U.isBlank(tGroup)){
            return Result.fail("获取用户组信息失败");
        }
        return Result.success("获取用户组信息成功",TGroupVo.assemblyData(tGroup));
    }

    @PostMapping("/addTGroup")
    @ApiParam("添加用户组信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTGroupError")
    public Result addTGroup(TGroupDto tGroupDto){
        TGroup ok = tGroupService.insertSelective(TGroupDto.assemblyData(tGroupDto));
        if (U.isBlank(ok)){
            return Result.fail("添加用户组信息失败");
        }
        log.info("Return positionId :"+ok.getId());
        return Result.success("添加用户组信息成功");
    }

    @PostMapping("/updateTGroup")
    @ApiParam("更新用户组信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTGroupError")
    public Result updateTGroup(TGroup tGroup){
        TGroup ok = tGroupService.updateByPrimaryKey(tGroup);
        if (U.isBlank(ok)){
            return Result.fail("更新用户组信息失败");
        }
        return Result.success("更新用户组信息成功");
    }

    @DeleteMapping("/deleteBygroupId")
    @ApiParam("删除用户组信息 -> 李振伟")
    public Result deleteByGroupId(@ApiParam("岗位Id") @RequestParam Integer groupId){
        if (U.isBlank(groupId)){
            return Result.fail("参数不能为空");
        }
        int ok = tGroupService.deleteByPrimaryKey(groupId);
        if (0 == ok){
            return Result.fail("删除用户组信息失败");
        }
        return Result.success("删除用户组信息成功");
    }

    @PostMapping("/findByCondition")
    @ApiParam("根据条件查找岗位信息 -> 李振伟")
    public Result<PageInfo<TGroupVo>> findByCondition(TGroupDto tGroupDto,
                                                         @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                         @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TGroup> tGroupPageInfo = tGroupService.findByPage(TGroupDto.assemblyData(tGroupDto),pageNum,pageSize);
        if (U.isBlank(tGroupPageInfo)){
            return Result.fail("查询用户组信息失败");
        }
        return Result.success("查询用户组信息成功",TGroupVo.assemblyDataListPage(tGroupPageInfo));
    }

    @GetMapping("/getTGroupVoByPage")
    @ApiParam("分页信息")
    public Result<PageInfo<TGroupVo>> getTGroupVoByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize
    ){
        PageInfo<TGroup> tGroupPageInfo = tGroupService.findByPage(null,pageNum,pageSize);
        if (U.isBlank(tGroupPageInfo)){
            return Result.fail("查询用户组信息失败");
        }
        return Result.success("查找用户组信息成功",TGroupVo.assemblyDataListPage(tGroupPageInfo));
    }



}
