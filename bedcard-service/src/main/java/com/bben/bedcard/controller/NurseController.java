package com.bben.bedcard.controller;

import com.bben.bedcard.service.TNurseService;
import com.bben.bedcard.vo.TNurseVo;
import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/12 15:58
 */
@Api(tags = "护士接口")
@RestController
@RequestMapping("/nurse")
public class NurseController extends BaseController {

    @Autowired
    private TNurseService tNurseService;

    @GetMapping("/selectByNurseId")
    @ApiOperation("查询护士详细信息接口 -> 李振伟")
    public Result<TNurseVo> selectByNurseId(@ApiParam("护士id") @RequestParam Integer nurseId){
        if (U.isBlank(nurseId)){
            return Result.fail("参数不能为空");
        }
        TNurseVo tNurseVo = tNurseService.selectByPrimaryKey(nurseId);
        if (U.isBlank(tNurseVo)){
            return Result.fail("查询无数据");
        }
        return Result.success("查询参数成功",tNurseVo);
    }
}
