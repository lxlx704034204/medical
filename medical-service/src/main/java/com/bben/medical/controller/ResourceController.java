package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TResourceDto;
import com.bben.medical.model.medical.TResource;
import com.bben.medical.service.TResourceService;
import com.bben.medical.vo.TResourceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/3 10:28
 */
@Api(tags = "用户资源接口")
@RestController
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController {

    @Autowired
    private TResourceService tResourceService;

    @Autowired
    RestTemplate restTemplate;

    public Result addTResourceError(TResourceDto tResourceDto){
        return Result.fail("添加资源信息失败");
    }

    public Result updateTResourceError(TResource tResource){
        return Result.fail("更新资源信息失败");
    }

    @GetMapping("/selectAllTResource")
    @ApiOperation(value = "查询所有资源信息 -> 李振伟")
    public Result selectAllTResource(){
        List<TResource> resourceList = tResourceService.findAllTRsource();
        if (A.isEmpty(resourceList)){
            return Result.fail("无资源数据");
        }
        return Result.success("查询资源数据成功",resourceList);
    }

    @GetMapping("/seleResourceById")
    public Result seleResourceById(@ApiParam("资源Id") @RequestParam Integer resourceId){
        if (U.isBlank(resourceId)){
            return Result.fail("资源Id不能为空");
        }
        TResource tResource = tResourceService.selectByPrimaryKey(resourceId);
        return Result.success("查询资源数据成功",TResourceVo.assemblyData(tResource));
    }

    @PostMapping("/addTResource")
    @ApiOperation(value = "添加用户资源信息 -> 李振伟")
    public Result addTResource(TResourceDto tResourceDto){
        if (U.isBlank(tResourceDto)){
            return Result.fail("添加用户资源数据失败");
        }
        TResource ok = tResourceService.insertSelective(TResourceDto.assemblyData(tResourceDto));
        if (U.isBlank(ok)){
            return Result.fail("添加用户资源信息失败");
        }
        return Result.success("添加用户资源信息成功");
    }

    @PostMapping("/updateTResource")
    @ApiOperation(value = "更新用户资源信息 -> 李振伟")
    public Result updateTResource(TResource tResource){
        TResource ok = tResourceService.updateByPrimaryKey(tResource);
        if (U.isBlank(ok)){
            return Result.fail("更新用户资源信息失败");
        }
        return Result.success("更新用户资源信息成功");
    }

    @DeleteMapping("/deleteTResource")
    @ApiOperation(value = "删除用户资源信息 -> 李振伟")
    public Result deleteTResource(@ApiParam("资源Id") @RequestParam Integer resourceId){
        if (U.isBlank(resourceId)){
            return Result.fail("参数不能为空");
        }
        int ok = tResourceService.deleteByPrimaryKey(resourceId);
        if (0 == ok){
            return Result.fail("删除用户资源信息失败");
        }
        return Result.success("删除用户资源信息成功");
    }

    @PostMapping("/findByCondition")
    public Result findByCondition(TResource tResource,
                                  @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TResource> tResourcePageInfo = tResourceService.findByPage(tResource,pageNum,pageSize);
        if (U.isBlank(tResourcePageInfo)){
            return Result.fail("查询用户资源信息失败");
        }
        return Result.success("查询用户资源信息成功",tResourcePageInfo);
    }

}
