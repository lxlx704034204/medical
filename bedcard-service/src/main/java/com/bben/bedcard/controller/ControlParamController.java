package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TControlParamDto;
import com.bben.bedcard.model.bedcard.TControlParam;
import com.bben.bedcard.service.TControlParamService;
import com.bben.bedcard.vo.TControlParamVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "控制参数接口")
@RestController
@RequestMapping(value = "/controlParam")
public class ControlParamController extends BaseController {

    @Autowired
    private TControlParamService tControlParamService;

    @PostMapping("/add")
    @ApiOperation("添加控制参数记录 -> 陈旭东")
    public Result addTControlParam(TControlParamDto tControlParamDto) {
        //转换成需要显示的类型
        TControlParam tControlParam = JsonUtil.convert(tControlParamDto, TControlParam.class);
        TControlParam ok = tControlParamService.insertSelective(tControlParam);

        if (U.isBlank(ok)) {
            return Result.fail("add控制参数信息失败");
        }

        log.info("Return ParamCode:" + ok.getCode());
        return Result.success("添加控制参数记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除控制参数记录 -> 陈旭东")
    public Result delTControlParam(@ApiParam("paramCode") @RequestParam String code) {
        int ok = tControlParamService.deleteByPrimaryKey(code);
        if (ok == 0) {
            return Result.fail("删除控制参数信息失败");
        }

        return Result.success("删除控制参数信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改控制参数记录 -> 陈旭东")
    public Result updateTControlParam(TControlParam tControlParam) {
        TControlParam TControlParam1 = tControlParamService.updateByPrimaryKey(tControlParam);
        if (U.isBlank(TControlParam1)) {
            return Result.fail("修改控制参数信息失败");
        }
        return Result.success("修改控制参数信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取控制参数信息 -> 陈旭东")
    public Result<TControlParamVo> selecTControlParam(@ApiParam("code") @RequestParam String code) {
        TControlParam tControlParam = tControlParamService.selectByPrimaryKey(code);
        if (U.isBlank(tControlParam)) {
            return Result.success("无控制参数数据");
        }

        //转换成需要显示的类型
        TControlParamVo tControlParamVo = JsonUtil.convert(tControlParam, TControlParamVo.class);

        return Result.success("获取控制参数信息成功", tControlParamVo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找控制参数信息 -> 陈旭东")
    public Result<PageInfo<TControlParam>> findByCondition(TControlParam tControlParam,
                                                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                           @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TControlParam> pageInfoTControlParam = tControlParamService.findByCondition(tControlParam, pageNum, pageSize);
        if (U.isBlank(pageInfoTControlParam)) {
            return Result.success("无控制参数数据");
        }

        return Result.success("根据条件查找控制参数信息成功", pageInfoTControlParam);
    }
}
