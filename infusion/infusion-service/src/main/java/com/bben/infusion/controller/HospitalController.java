package com.bben.infusion.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.infusion.dto.THospitalDto;
import com.bben.infusion.model.infusion.THospital;
import com.bben.infusion.service.THospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "医院接口")
@RestController
@RequestMapping(value = "/hospital")
public class HospitalController extends BaseController {

    @Autowired
    private THospitalService tHospitalService;

    @PostMapping("/add")
    @ApiOperation("添加医院记录 -> lsq")
    public Result addTHospital(THospitalDto tHospitalDto) {
        //转换成需要显示的类型
        THospital tHospital = JsonUtil.convert(tHospitalDto, THospital.class);
        THospital ok = tHospitalService.insertSelective(tHospital);

        if (U.isBlank(ok)) {
            return Result.fail("add医院信息失败");
        }

        log.info("Return Name:" + ok.getName());
        return Result.success("添加医院记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除医院记录 -> lsq")
    public Result delTHospital(@ApiParam("id") @RequestParam Integer id) {
        int ok = tHospitalService.deleteByPrimaryKey(id);
        if (ok == 0) {
            return Result.fail("删除医院信息失败");
        }

        return Result.success("删除医院信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改医院记录 -> lsq")
    public Result updateTHospital(THospital tHospital) {
        THospital tHospital1 = tHospitalService.updateByPrimaryKey(tHospital);
        if (U.isBlank(tHospital1)) {
            return Result.fail("修改医院信息失败");
        }
        return Result.success("修改医院信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取医院信息 -> lsq")
    public Result<THospitalDto> selectTHospital(@ApiParam("id") @RequestParam Integer id) {
        THospital tHospital = tHospitalService.selectByPrimaryKey(id);
        if (U.isBlank(tHospital)) {
            return Result.success("无医院数据");
        }

        //转换成需要显示的类型
        THospitalDto tHospitalDto = JsonUtil.convert(tHospital, THospitalDto.class);

        return Result.success("获取医院信息成功", tHospitalDto);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找医院信息 -> lsq")
    public Result<PageInfo<THospital>> findByCondition(THospital tHospital,
                                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<THospital> pageInfoTHospital = tHospitalService.findByCondition(tHospital, pageNum, pageSize);
        if (U.isBlank(pageInfoTHospital)) {
            return Result.success("无医院数据");
        }

        return Result.success("根据条件查找医院信息成功", pageInfoTHospital);
    }

}
