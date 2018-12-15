package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TMedicationRecordDto;
import com.bben.bedcard.model.bedcard.TMedicationRecord;
import com.bben.bedcard.service.TMedicationRecordService;
import com.bben.bedcard.vo.TMedicationRecordVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.github.pagehelper.PageHelper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用药记录接口")
@RestController
@RequestMapping("/medicationRecord")
public class MedicationRecordController extends BaseController {

    @Autowired
    private TMedicationRecordService tMedicationRecordService;

    public Result addTMedicationRecordError(TMedicationRecordDto tMedicationRecordDto){
        return Result.fail("添加用药记录失败");
    }

    public Result updateTMedicationRecordError(TMedicationRecord tMedicationRecord){
        return Result.fail("更新用药记录失败");
    }

    @GetMapping("/selectByMedicationRecordId")
    @ApiOperation("根据Id查询用药记录信息 -> 李振伟")
    public Result<TMedicationRecordVo> selectByMedicationRecordId(@ApiParam("用药记录Id") @RequestParam Integer medicationRecordId){
        if (U.isBlank(medicationRecordId)){
            return Result.fail("参数不能为空");
        }
        TMedicationRecordVo tMedicationRecordVo = tMedicationRecordService.selectByPrimaryKey(medicationRecordId);
        return  Result.success("查询数据成功",tMedicationRecordVo);
    }

    @PostMapping("/addTMedicationRecord")
    @ApiOperation("添加用药记录信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTMedicationRecordError")
    public Result addTMedicationRecord(TMedicationRecordDto tMedicationRecordDto){
        if (U.isBlank(tMedicationRecordDto)){
            return Result.fail("对象不能为空");
        }
        TMedicationRecord ok = tMedicationRecordService.insertSelective(TMedicationRecordDto.assemblyData(tMedicationRecordDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TRoleId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTMedicationRecord")
    @ApiOperation("更新用药记录信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTMedicationRecordError")
    public Result updateTMedicationRecord(TMedicationRecord tMedicationRecord){
        if (U.isBlank(tMedicationRecord)){
            return Result.fail("对象不能为空");
        }
        TMedicationRecord ok = tMedicationRecordService.updateByPrimarykey(tMedicationRecord);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByMedicationRecordId")
    @ApiOperation("删除用药记录信息 -> 李振伟")
    public Result deleteByMedicationRecordId(@ApiParam("用药记录id") @RequestParam Integer medicationRecordId){
        if (U.isBlank(medicationRecordId)){
            return Result.fail("参数不能为空");
        }
        int ok = tMedicationRecordService.deleteByPrimarykey(medicationRecordId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTMedicationRecordVoByCondition")
    @ApiOperation("根据条件查询用药记录信息 -> 李振伟")
    public  Result<PageInfo<TMedicationRecordVo>> getTMedicationRecordVoByCondition(TMedicationRecordDto tMedicationRecordDto,
                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        List<TMedicationRecordVo> medicationRecordVoList = tMedicationRecordService.selectByCondition(TMedicationRecordDto.assemblyData(tMedicationRecordDto));
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TMedicationRecordVo> tMedicationRecordVoPageInfo = new PageInfo<>(medicationRecordVoList);
        return Result.success("查询用药记录信息成功",tMedicationRecordVoPageInfo);
    }
}
