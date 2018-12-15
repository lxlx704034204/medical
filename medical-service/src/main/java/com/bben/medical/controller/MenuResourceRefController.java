package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.medical.dto.TMenuResourceRefDto;
import com.bben.medical.model.medical.TMenuResourceRef;
import com.bben.medical.model.medical.TResource;
import com.bben.medical.service.TMenuResourceRefService;
import com.bben.medical.service.TResourceService;
import com.bben.medical.vo.TMenuResourceRefVo;
import com.bben.medical.vo.TResourceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/6 17:52
 */
@Api(tags = "菜单资源接口")
@RestController
@RequestMapping(value = "/menuResourceRef")
public class MenuResourceRefController extends BaseController {

    @Autowired
    private TMenuResourceRefService tMenuResourceRefService;

    @Autowired
    private TResourceService tResourceService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/selectAll")
    @ApiOperation("查询所有菜单资源 -> 李振伟")
    public Result selectAll(){
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefService.findAllTRole();
        List<TMenuResourceRefVo> tMenuResourceRefVoList = new ArrayList<>();
        for (TMenuResourceRef tMenuResourceRef : tMenuResourceRefList) {
            TMenuResourceRefVo tMenuResourceRefVo = new TMenuResourceRefVo();
            tMenuResourceRefVo = TMenuResourceRefVo.assemblyData(tMenuResourceRef);
            if (U.isNotBlank(tMenuResourceRef)){
                TResource tResources = tResourceService.selectByPrimaryKey(tMenuResourceRef.getResourceId());
                if (U.isNotBlank(tResources)){
                    tMenuResourceRefVo.setTResourceVo(TResourceVo.assemblyData(tResources));
                }
                tMenuResourceRefVoList.add(tMenuResourceRefVo);
            }

        }

        if (A.isEmpty(tMenuResourceRefList)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询数据成功",tMenuResourceRefVoList);
    }

    @GetMapping("/selectById")
    @ApiOperation("根据Id查询菜单资源")
    public Result selectById(@ApiParam("菜单资源表Id") @RequestParam Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        TMenuResourceRefVo tMenuResourceRefVo = new TMenuResourceRefVo();
        TMenuResourceRef tMenuResourceRef = tMenuResourceRefService.selectByPrimaryKey(refId);
        if (U.isNotBlank(tMenuResourceRef)){
            tMenuResourceRefVo = TMenuResourceRefVo.assemblyData(tMenuResourceRef);
            if (U.isNotBlank(tMenuResourceRefVo.getResourceId())){
                TResource tResource = tResourceService.selectByPrimaryKey(tMenuResourceRefVo.getResourceId());
                tMenuResourceRefVo.setTResourceVo(TResourceVo.assemblyData(tResource));
            }
        }
        return Result.success("查询数据成功",tMenuResourceRefVo);
    }

    @PostMapping("/addTMenuResourceRef")
    @ApiOperation("添加菜单资源 -> 李振伟")
    public Result addTMenuResourceRef(TMenuResourceRefDto tMenuResourceRefDto){
        try {
            TMenuResourceRef ok = tMenuResourceRefService.insertSelective(TMenuResourceRefDto.assemblyData(tMenuResourceRefDto));
            if (U.isBlank(ok)){
                return Result.fail("添加数据失败");
            }
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("添加数据异常");
        }

        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTMenuResourceRef")
    @ApiOperation("更新菜单资源 -> 李振伟")
    public Result updateTMenuResourceRef(TMenuResourceRef tMenuResourceRef){
        TMenuResourceRef ok = tMenuResourceRefService.updateByPrimarykey(tMenuResourceRef);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteTMenuResourceRef")
    @ApiOperation("删除菜单资源 -> 李振伟")
    public Result deleteTMenuResourceRef(@ApiParam("菜单资源Id") @RequestParam Integer refId){
        if (U.isBlank(refId)){
            return Result.fail("参数不能为空");
        }
        int ok = tMenuResourceRefService.deleteByPrimarykey(refId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @GetMapping("/findByPage")
    @ApiOperation("分页查询菜单资源 -> 李振伟")
    public Result findByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                             @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo = tMenuResourceRefService.selectByPage(pageNum,pageSize);
        PageInfo<TMenuResourceRefVo> tMenuResourceRefVoPageInfo = assemblyFindData(tMenuResourceRefPageInfo);
        return Result.success("查询数据成功",tMenuResourceRefVoPageInfo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("条件查询菜单资源 -> 李振伟")
    public Result findByCondition(TMenuResourceRefDto tMenuResourceRefDto,
                                  @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo = tMenuResourceRefService.selectByCondition(TMenuResourceRefDto.assemblyData(tMenuResourceRefDto),pageNum,pageSize);
        PageInfo<TMenuResourceRefVo> tMenuResourceRefVoPageInfo = assemblyFindData(tMenuResourceRefPageInfo);
        return Result.success("查询数据成功", tMenuResourceRefVoPageInfo);
    }

    /**
     * 组装菜单资源返回数据
     * @param tMenuResourceRefPageInfo
     * @return
     */
    private PageInfo<TMenuResourceRefVo> assemblyFindData(PageInfo<TMenuResourceRef> tMenuResourceRefPageInfo){
        List<TMenuResourceRefVo> tMenuResourceRefVoList = new ArrayList<>();
        List<TMenuResourceRef> tMenuResourceRefList = tMenuResourceRefPageInfo.getList();
        PageInfo<TMenuResourceRefVo> tMenuResourceRefVoPageInfo;
        if (A.isEmpty(tMenuResourceRefList)){
            tMenuResourceRefVoPageInfo = new PageInfo<>(tMenuResourceRefVoList);
            return tMenuResourceRefVoPageInfo;
        }
        for (TMenuResourceRef tMenuResourceRef : tMenuResourceRefList) {
            TMenuResourceRefVo tMenuResourceRefVo = new TMenuResourceRefVo();
            tMenuResourceRefVo = TMenuResourceRefVo.assemblyData(tMenuResourceRef);
            if (U.isNotBlank(tMenuResourceRef.getResourceId())){
                TResource tResource = tResourceService.selectByPrimaryKey(tMenuResourceRef.getResourceId());
                tMenuResourceRefVo.setTResourceVo(TResourceVo.assemblyData(tResource));
            }
            tMenuResourceRefVoList.add(tMenuResourceRefVo);
        }
        tMenuResourceRefVoPageInfo = new PageInfo<>(tMenuResourceRefVoList);
        return tMenuResourceRefVoPageInfo;
    }

}
