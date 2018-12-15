package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TRoleResourceRefDto;
import com.bben.medical.model.medical.TResource;
import com.bben.medical.model.medical.TRoleResourceRef;
import com.bben.medical.service.TResourceService;
import com.bben.medical.service.TRoleResourceRefService;
import com.bben.medical.vo.TResourceVo;
import com.bben.medical.vo.TRoleResourceRefVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/7 14:16
 */
@Api(tags = "角色资源接口")
@RestController
@RequestMapping(value = "/roleResourceRef")
public class RoleResourceRefController extends BaseController {

    @Autowired
    private TRoleResourceRefService tRoleResourceRefService;

    @Autowired
    private TResourceService tResourceService;

    @GetMapping("/selectTRoleResourceRefAll")
    @ApiOperation("查询所有角色资源 -> 李振伟")
    public Result selectTRoleResourceRefAll(){
        List<TRoleResourceRef> tRoleResourceRefList =tRoleResourceRefService.findAllTRoleResource();
        if (U.isBlank(tRoleResourceRefList)){
            return Result.fail("查询数据失败");
        }
        return Result.success("查询数据成功",tRoleResourceRefList);
    }

    @GetMapping("/selectTRoleResourceRefById")
    @ApiOperation("根据Id查询角色资源 -> 李振伟")
    public Result selectTRoleResourceRefById(@ApiParam("角色资源表Id") @RequestParam Integer refId){
        TRoleResourceRef tRoleResourceRef = tRoleResourceRefService.selectByPrimaryKey(refId);
        TRoleResourceRefVo tRoleResourceRefVo = new TRoleResourceRefVo();
        if (U.isNotBlank(tRoleResourceRef)){
            tRoleResourceRefVo = TRoleResourceRefVo.assemblyData(tRoleResourceRef);
            if (U.isNotBlank(tRoleResourceRef.getResourceId())){
                TResource tResource = tResourceService.selectByPrimaryKey(tRoleResourceRef.getResourceId());
                TResourceVo tResourceVo = TResourceVo.assemblyData(tResource);
                tRoleResourceRefVo.setTResourceVo(tResourceVo);
            }
        }
        return Result.success("查询数据成功",tRoleResourceRefVo);
    }

    @PostMapping("/addTRoleResourceRef")
    @ApiOperation("添加角色资源 -> 李振伟")
    public Result addTRoleResourceRef(TRoleResourceRefDto tRoleResourceRefDto){
        TRoleResourceRef ok = tRoleResourceRefService.insertSelective(TRoleResourceRefDto.assemblyData(tRoleResourceRefDto));
        if (U.isBlank(ok)){
            return Result.fail("添加失败");
        }
        return Result.success("添加成功");
    }

    @PostMapping("/updateTRoleResourceRef")
    @ApiOperation("更新角色资源 -> 李振伟")
    public Result updateTRoleResourceRef(TRoleResourceRef tRoleResourceRef){
        TRoleResourceRef ok = tRoleResourceRefService.updateByPrimarykey(tRoleResourceRef);
        if (U.isBlank(ok)){
            return Result.fail("更新角色资源信息失败");
        }
        return Result.success("更新角色资源信息成功");
    }

    @DeleteMapping("/deleteTRoleResourceRef")
    @ApiOperation("删除角色资源信息 -> 李振伟")
    public Result deleteTRoleResourceRef(@ApiParam("角色资源表Id") @RequestParam Integer refId){
        int ok = tRoleResourceRefService.deleteByPrimarykey(refId);
        if (0 == ok){
            return Result.fail("删除信息失败");
        }
        return Result.success("删除信息成功");
    }

    @GetMapping("/findTRoleResourceRefByPage")
    @ApiOperation("根据分页查询角色资源信息 -> 李振伟")
    public Result findTRoleResourceRefByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                             @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRoleResourceRef> tRoleResourceRefPageInfo = tRoleResourceRefService.selectByPage(pageNum,pageSize);
        if (U.isBlank(tRoleResourceRefPageInfo)){
            return Result.fail("数据为空");
        }
        List<TRoleResourceRef> tRoleResourceRefList = tRoleResourceRefPageInfo.getList();
        List<TRoleResourceRefVo> tRoleResourceRefVoList = assemblyData(tRoleResourceRefList);
        PageInfo<TRoleResourceRefVo> tRoleResourceRefVoPageInfo = new PageInfo<>(tRoleResourceRefVoList);
        return Result.success("查询数据成功",tRoleResourceRefVoPageInfo);

    }

    @PostMapping("/findTRoleResourceRefByCondition")
    @ApiOperation("根据条件查询角色资源信息 -> 李振伟")
    public Result findTRoleResourceRefByCondition(TRoleResourceRef tRoleResourceRef,
                                  @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRoleResourceRef> tRoleResourceRefPageInfo = tRoleResourceRefService.selectByCondition(tRoleResourceRef,pageNum,pageSize);
            if (U.isBlank(tRoleResourceRefPageInfo)){
                return Result.fail("数据为空");
            }
        List<TRoleResourceRef> tRoleResourceRefList = tRoleResourceRefPageInfo.getList();
        PageInfo<TRoleResourceRefVo> tRoleResourceRefVoPageInfo = new PageInfo<>(assemblyData(tRoleResourceRefList));
        return Result.success("查询数据成功",tRoleResourceRefVoPageInfo);
    }

    /**
     * 数据转换
     * @param tRoleResourceRefList
     * @return
     */
    private List<TRoleResourceRefVo> assemblyData(List<TRoleResourceRef> tRoleResourceRefList){
        List<TRoleResourceRefVo> tRoleResourceRefVoList = new ArrayList<>();
        if (A.isEmpty(tRoleResourceRefList)){
            return tRoleResourceRefVoList;
        }
        for (TRoleResourceRef tRoleResourceRef : tRoleResourceRefList) {
            TRoleResourceRefVo tRoleResourceRefVo = TRoleResourceRefVo.assemblyData(tRoleResourceRef);
            if (U.isNotBlank(tRoleResourceRef.getResourceId())){
                TResource tResource = tResourceService.selectByPrimaryKey(tRoleResourceRef.getResourceId());
                tRoleResourceRefVo.setTResourceVo(TResourceVo.assemblyData(tResource));
            }
            tRoleResourceRefVoList.add(tRoleResourceRefVo);
        }
        return tRoleResourceRefVoList;
    }



}
