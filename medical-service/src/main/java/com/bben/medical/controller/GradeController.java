package com.bben.medical.controller;

import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.medical.dto.GradeDto;
import com.bben.medical.model.sqlMedical.Grade;
import com.bben.medical.service.GradeService;
import com.bben.medical.vo.GradeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Grade地址接口")
@RestController
@RequestMapping(value = "/grade")
public class GradeController extends BaseController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/add")
    @ApiOperation("添加记录 -> 陈旭东")
    public Result addGrade(GradeDto GradeDto) {
        //转换成需要显示的类型
        Grade Grade = JsonUtil.convert(GradeDto, Grade.class);
        Grade ok = gradeService.insertSelective(Grade);

        if (U.isBlank(ok)) {
            return Result.fail("add信息失败");
        }

        log.info("Return Grade:" + ok.getGrade());
        return Result.success("添加记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除记录 -> 陈旭东")
    public Result delGrade(@ApiParam("id") @RequestParam Integer id) {
        int ok = gradeService.deleteByPrimaryKey(id);
        if (ok == 0) {
            return Result.fail("删除信息失败");
        }

        return Result.success("删除信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改记录 -> 陈旭东")
    public Result updateGrade(Grade Grade) {
        Grade Grade1 = gradeService.updateByPrimaryKey(Grade);
        if (U.isBlank(Grade1)) {
            return Result.fail("修改信息失败");
        }
        return Result.success("修改信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取信息 -> 陈旭东")
    public Result<GradeVo> selecGrade(@ApiParam("id") @RequestParam Integer id) {
        Grade Grade = gradeService.selectByPrimaryKey(id);
        if (U.isBlank(Grade)) {
            return Result.fail("无数据");
        }

        //转换成需要显示的类型
        GradeVo GradeVo = JsonUtil.convert(Grade, GradeVo.class);

        return Result.success("获取地址信息成功", GradeVo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找信息 -> 陈旭东")
    public Result<PageInfo<Grade>> findByCondition(Grade Grade,
                                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Grade> pageInfoGrade = gradeService.findByCondition(Grade, pageNum, pageSize);
        if (U.isBlank(pageInfoGrade)) {
            return Result.fail("无数据");
        }

        return Result.success("根据条件查找信息成功", pageInfoGrade);
    }
}
