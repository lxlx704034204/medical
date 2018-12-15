package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.medical.dto.TMenuDto;
import com.bben.medical.model.medical.TMenu;
import com.bben.medical.service.TMenuService;
import com.bben.medical.vo.TMenuVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lizhenwei
 */
@Api(tags = "菜单接口")
@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

    @Autowired
    private TMenuService tMenuService;

    @Autowired
    RestTemplate restTemplate;

    public Result addMenuError(TMenuDto tMenuDto) {
        return Result.fail("add菜单信息失败！！！");
    }

    public Result updateMenuError(TMenu tMenu){
        return Result.fail("更新菜单信息失败");
    }

    @PostMapping("/add")
    @ApiOperation("添加菜单 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addMenuError")
    public Result add(TMenuDto tMenuDto) {
        //转换成需要显示的类型
        TMenu tMenu = JsonUtil.convert(tMenuDto, TMenu.class);
        TMenu ok = tMenuService.insertSelective(tMenu);
        if (U.isBlank(ok)) {
            return Result.fail("添加菜单失败");
        }
        log.info("Return MenuId:" + ok.getId());
        return Result.success("添加菜单成功");
    }

    @GetMapping("/selectById")
    @ApiOperation("根据Id查询菜单 -> 李振伟")
    public Result<TMenuVo> selectMenuById(@ApiParam("菜单id") @RequestParam Integer menuId) {
        TMenu tMenu = tMenuService.selectByPrimaryKey(menuId);
        if (U.isBlank(tMenu)) {
            return Result.fail("无菜单信息");
        }
        return Result.success("获取菜单信息成功", tMenu);
    }

    @GetMapping("/selectAll")
    @ApiOperation("查询所有菜单 -> 李振伟")
    public Result<List<TMenu>> selectAll() {
        List<TMenu> tMenuList = tMenuService.findAllTMenu();
        if (A.isEmpty(tMenuList)) {
            return Result.fail("查询菜单信息失败");
        }
        return Result.success("查询菜单信息成功", tMenuList
        );
    }

    @PostMapping("/updateTMenu")
    @ApiOperation("更新菜单记录 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateMenuError")
    public Result updateTMenu(TMenu tMenu) {
        TMenu ok = tMenuService.updateByPrimaryKey(tMenu);
        if (U.isBlank(ok)) {
            return Result.fail("修改菜单信息失败");
        }
        return Result.success("修改菜单信息成功", ok);
    }

    @DeleteMapping("/deleteTmenu")
    @ApiOperation("删除菜单信息 -> 李振伟")
    public Result deleteTMenu(@ApiParam("菜单Id") @RequestParam Integer menuId) {
        if (U.isBlank(menuId)){
            return Result.fail("参数不能为空");
        }
        int ok = tMenuService.deleteByPrimaryKey(menuId);
        if (0 == ok) {
            return Result.fail("删除菜单信息失败");
        }
        return Result.success("删除菜单信息成功");
    }


}
