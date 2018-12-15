package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.bben.medical.dto.TRoleDto;
import com.bben.medical.model.medical.TRole;
import com.bben.medical.service.TRoleService;
import com.bben.medical.vo.TRoleVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/2 16:10
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    @Autowired
    private TRoleService tRoleService;

    @Autowired
    RestTemplate restTemplate;

    public Result addTRoleError(TRoleDto tRoleDto){
        return Result.fail("添加角色信息失败");
    }

    public Result updateTRoleError(TRole tRole){
        return Result.fail("更新角色信息失败");
    }

    @GetMapping("/selectByRoleId")
    @ApiOperation("根据Id查询角色信息 -> 李振伟")
    public Result selectByRoleId(@ApiParam("角色Id") @RequestParam Integer roleId){
        if (U.isBlank(roleId)){
            return Result.fail("角色Id不能为空");
        }
        TRole tRole = tRoleService.selectByPrimaryKey(roleId);
        if (U.isBlank(tRole)){
            return Result.fail("查询角色信息失败");
        }
        return  Result.success("查询角色信息成功",TRoleVo.assemblyData(tRole));
    }

    @PostMapping("/addTRole")
    @ApiOperation("添加角色信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTRoleError")
    public Result addTRole(TRoleDto tRoleDto){
        if (U.isBlank(tRoleDto)){
            return Result.fail("对象不能为空");
        }
        TRole ok = tRoleService.insertSelective(TRoleDto.assemblyData(tRoleDto));
        if (U.isBlank(ok)){
            return Result.fail("添加角色信息失败");
        }
        log.info("TRoleId : "+ok.getId());
        return Result.success("添加角色信息成功");

    }

    @PostMapping("/updateTRole")
    @ApiOperation("更新角色信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTRoleError")
    public Result updateTRole(TRole tRole){
        TRole ok = tRoleService.updateByPrimarykey(tRole);
        if (U.isBlank(ok)){
            return Result.fail("更新角色信息失败");
        }
        return Result.success("更新角色信息成功");
    }

    @DeleteMapping("/deleteByRoleId")
    @ApiOperation("删除角色信息 -> 李振伟")
    public Result deleteByRoleId(@ApiParam("角色Id") @RequestParam Integer roleId){
        if (U.isBlank(roleId)){
            return Result.fail("参数不能为空");
        }
        int ok = tRoleService.deleteByPrimarykey(roleId);
        if (0 == ok){
            return Result.fail("删除角色信息失败");
        }
        return Result.success("删除角色信息成功");
    }

    @GetMapping("/getTRoleVoByPage")
    @ApiOperation("按照分页查询角色信息 -> 李振伟")
    public Result<PageInfo<TRoleVo>> getTRoleVoByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRole> tRolePageInfo = tRoleService.selectByPage(pageNum,pageSize);
        return Result.success("查询角色信息成功",TRoleVo.assemblyDataListPage(tRolePageInfo));
    }

    @PostMapping("/getTRoleVoByCondition")
    @ApiOperation("根据条件查询角色信息 -> 李振伟")
    public  Result<PageInfo<TRoleVo>> getTRoleVoByCondition(TRoleDto tRoleDto,
                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TRole> tRolePageInfo = tRoleService.selectByCondition(TRoleDto.assemblyData(tRoleDto),pageNum,pageSize);
        return Result.success("查询角色信息成功",TRoleVo.assemblyDataListPage(tRolePageInfo));
    }
}
