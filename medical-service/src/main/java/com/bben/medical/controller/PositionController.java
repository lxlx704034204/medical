package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.medical.dto.TPositionDto;
import com.bben.medical.model.medical.TPosition;
import com.bben.medical.service.TPositionService;
import com.bben.medical.vo.TPositionVo;
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
@Api(tags = "岗位接口")
@RestController
@RequestMapping(value = "/position")
public class PositionController extends BaseController {

    @Autowired
    private TPositionService tPositionService;

    @Autowired
    RestTemplate restTemplate;

    public Result addTPositionError(TPositionDto tPositionDto){
        return Result.fail("添加岗位数据失败");
    }

    public Result updateTPositionError(TPosition tPosition){
        return Result.fail("跟新岗位数据失败");
    }

    @GetMapping("/selectAllPosition")
    @ApiOperation("获取岗位信息 -> 李振伟")
    public Result selectAllPosition(){
        List<TPosition> tPositionList = tPositionService.findAllTPosition();
        if (A.isEmpty(tPositionList)){
            return Result.fail("无岗位数据");
        }
        return Result.success("数据获取成功",TPositionVo.assemblyDataList(tPositionList));
    }

    @GetMapping("/selectPositionById")
    @ApiOperation("根据主键获取岗位信息 -> 李振伟")
    public Result selectPositionById(@ApiParam("岗位Id") @RequestParam Integer positionId){
        TPosition tPosition = tPositionService.selectByPrimaryKey(positionId);
        if (U.isBlank(tPosition)){
            return Result.fail("获取岗位信息失败");
        }
        return Result.success("获取岗位信息成功",TPositionVo.assemblyData(tPosition));
    }

    @PostMapping("/addTPosition")
    @ApiParam("添加岗位信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTPositionError")
    public Result addTPosition(TPositionDto tPositionDto){
        TPosition tPosition = JsonUtil.convert(tPositionDto,TPosition.class);
        TPosition ok = tPositionService.insertSelective(tPosition);
        if (U.isBlank(ok)){
            return Result.fail("添加岗位信息失败");
        }
        log.info("Return positionId :"+ok.getId());
        return Result.success("添加岗位信息成功");
    }

    @PostMapping("/updateTPosition")
    @ApiParam("更新岗位信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTPositionError")
    public Result updateTPosition(TPosition tPosition){
        TPosition ok = tPositionService.updateByPrimaryKey(tPosition);
        if (U.isBlank(ok)){
            return Result.fail("更新岗位信息失败");
        }
        return Result.success("更新岗位信息成功");
    }

    @DeleteMapping("/deleteBypositionId")
    @ApiParam("删除岗位信息 -> 李振伟")
    public Result deleteBypositionId(@ApiParam("岗位Id") @RequestParam Integer positionId){
        if (U.isBlank(positionId)){
            return Result.fail("参数不能为空");
        }
        int ok = tPositionService.deleteByPrimaryKey(positionId);
        if (0 == ok){
            return Result.fail("删除岗位信息失败");
        }
        return Result.success("删除岗位信息成功");
    }

    @PostMapping("/findByCondition")
    @ApiParam("根据条件查找岗位信息")
    public Result<PageInfo<TPositionVo>> findByCondition(TPositionDto tPositionDto,
                                                       @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                       @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        TPosition tPosition = JsonUtil.convert(tPositionDto,TPosition.class);
        PageInfo<TPosition> tPositionPageInfo = tPositionService.findByCondition(tPosition,pageNum,pageSize);
        if (U.isBlank(tPositionPageInfo)){
            return Result.fail("查询岗位信息失败");
        }
        return Result.success("查询岗位信息成功",TPositionVo.assemblyDataListPage(tPositionPageInfo));
    }

    @GetMapping("/getTPositionVoByPage")
    @ApiParam("分页信息")
    public Result<PageInfo<TPositionVo>> getTPositionVoByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize
                                                            ){
        PageInfo<TPosition> tPositionPageInfo = tPositionService.findByPage(pageNum,pageSize);
        if (U.isBlank(tPositionPageInfo)){
            return Result.fail("查询岗位信息失败");
        }
        return Result.success("查找岗位信息成功",TPositionVo.assemblyDataListPage(tPositionPageInfo));
    }


}
