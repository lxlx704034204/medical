package com.bben.infusion.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.infusion.dto.TPatientEquipRefDto;
import com.bben.infusion.model.infusion.TPatientEquipRef;
import com.bben.infusion.service.TPatientEquipRefService;
import com.bben.infusion.vo.TPatientEquipRefVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "病人对应输液监控设备")
@RestController
@RequestMapping(value = "/patientEquip")
public class PatientEquipRefController extends BaseController {

    @Autowired
    private TPatientEquipRefService TPatientEquipRefService;

    @PostMapping("/add")
    @ApiOperation("添加病人对应输液监控设备记录 -> 陈旭东")
    public Result addTPatientEquipRef(TPatientEquipRefDto TPatientEquipRefDto) {
        //转换成需要显示的类型
        TPatientEquipRef TPatientEquipRef = JsonUtil.convert(TPatientEquipRefDto, TPatientEquipRef.class);
        TPatientEquipRef ok = TPatientEquipRefService.insertSelective(TPatientEquipRef);

        if (U.isBlank(ok)) {
            return Result.fail("add病人对应输液监控设备信息失败");
        }

        log.info("Return equnipmentSN:" + ok.getEquipmentSn());
        return Result.success("添加病人对应输液监控设备记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除病人对应输液监控设备记录 -> 陈旭东")
    public Result delTPatientEquipRef(@ApiParam("id") @RequestParam Integer id) {
        int ok = TPatientEquipRefService.deleteByPrimaryKey(id);
        if (ok == 0) {
            return Result.fail("删除病人对应输液监控设备信息失败");
        }

        return Result.success("删除病人对应输液监控设备信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改病人对应输液监控设备记录 -> 陈旭东")
    public Result updateTPatientEquipRef(TPatientEquipRef TPatientEquipRef) {
        TPatientEquipRef TPatientEquipRef1 = TPatientEquipRefService.updateByPrimaryKey(TPatientEquipRef);
        if (U.isBlank(TPatientEquipRef1)) {
            return Result.fail("修改病人对应输液监控设备信息失败");
        }
        return Result.success("修改病人对应输液监控设备信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取病人对应输液监控设备信息 -> 陈旭东")
    public Result<TPatientEquipRefVo> selecTPatientEquipRef(@ApiParam("id") @RequestParam Integer id) {
        TPatientEquipRef TPatientEquipRef = TPatientEquipRefService.selectByPrimaryKey(id);
        if (U.isBlank(TPatientEquipRef)) {
            return Result.success("无病人对应输液监控设备数据");
        }

        //转换成需要显示的类型
        TPatientEquipRefVo TPatientEquipRefVo = JsonUtil.convert(TPatientEquipRef, TPatientEquipRefVo.class);

        return Result.success("获取病人对应输液监控设备信息成功", TPatientEquipRefVo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找病人对应输液监控设备信息 -> 陈旭东")
    public Result<PageInfo<TPatientEquipRef>> findByCondition(TPatientEquipRef TPatientEquipRef,
                                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TPatientEquipRef> pageInfoTPatientEquipRef = TPatientEquipRefService.findByCondition(TPatientEquipRef, pageNum, pageSize);
        if (U.isBlank(pageInfoTPatientEquipRef)) {
            return Result.success("无病人对应输液监控设备数据");
        }

        return Result.success("根据条件查找病人对应输液监控设备信息成功", pageInfoTPatientEquipRef);
    }
}
