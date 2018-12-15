package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TQuestionAnswerDto;
import com.bben.bedcard.model.bedcard.TQuestionAnswer;
import com.bben.bedcard.service.TQuestionAnswerService;
import com.bben.bedcard.vo.TQuestionAnswerVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/16 11:16
 */
@Api(tags = "调查问卷答案接口")
@RestController
@RequestMapping("/questionAnswer")
public class QuestionAnswerController extends BaseController {

    @Autowired
    private TQuestionAnswerService tQuestionAnswerService;

    @GetMapping("/selectAllQuestionAnswer")
    @ApiOperation("查询所有问卷调查答案 -> 李振伟")
    public Result<List<TQuestionAnswerVo>> selectAllQuestionAnswer(){
        List<TQuestionAnswerVo> tQuestionAnswerVoList = tQuestionAnswerService.findAll();
        return Result.success("查询数据成功",tQuestionAnswerVoList);
    }

    @GetMapping("/selectQuestionAnswerById")
    @ApiOperation("根据id查询问卷调查答案 -> 李振伟")
    public Result<TQuestionAnswerVo> selectQuestionAnswerById(@ApiParam("问题答案id") @RequestParam Integer questionAnswerId){
        if (U.isBlank(questionAnswerId)){
            return Result.fail("传入参数不能为空");
        }
        TQuestionAnswerVo tQuestionAnswerVo = tQuestionAnswerService.selectByPrimaryKey(questionAnswerId);
        return Result.success("查询数据成功",tQuestionAnswerVo);
    }

    @PostMapping("/addTQuestionAnswer")
    @ApiOperation("添加问卷调查答案 -> 李振伟")
    public Result addTQuestionAnswer(TQuestionAnswerDto tQuestionAnswerDto){
        if (U.isBlank(tQuestionAnswerDto)){
            return null;
        }
        TQuestionAnswer ok = tQuestionAnswerService.insertSelective(TQuestionAnswerDto.assemblyData(tQuestionAnswerDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTQuestionAnswer")
    @ApiOperation("更新问卷调查答案 -> 李振伟")
    public Result updateTQuestionAnswer(TQuestionAnswer tQuestionAnswer){
        if (U.isBlank(tQuestionAnswer)){
            return Result.fail("参数不能为空");
        }
        TQuestionAnswer ok = tQuestionAnswerService.updateByPrimarykey(tQuestionAnswer);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByQuestionAnswerId")
    @ApiOperation("删除问卷调查答案信息 -> 李振伟")
    public Result<PageInfo<TQuestionAnswerVo>> deleteByQuestionAnswerId(@ApiParam("问题列表id") @RequestParam Integer querstionAnswerId){
        if (U.isBlank(querstionAnswerId)){
            return Result.fail("参数不能为空");
        }
        int ok = tQuestionAnswerService.deleteByPrimarykey(querstionAnswerId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @GetMapping("/getTQuestionAnswerVoByPage")
    @ApiOperation("按照分页查询问卷调查答案信息 -> 李振伟")
    public Result<PageInfo<TQuestionAnswerVo>> getTQuestionAnswerVoByPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                              @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TQuestionAnswerVo> tQuestionAnswerVoPageInfo = tQuestionAnswerService.selectByPage(pageNum,pageSize);
        return Result.success("查询问卷调查答案信息成功",tQuestionAnswerVoPageInfo);
    }

    @PostMapping("/getTQuestionAnswerVoByCondition")
    @ApiOperation("根据条件查询问卷调查答案信息 -> 李振伟")
    public Result<PageInfo<TQuestionAnswerVo>> getTQuestionAnswerVoByCondition(TQuestionAnswerDto tQuestionAnswerDto,
                                                                    @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                                    @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TQuestionAnswerVo> tQuestionAnswerVoPageInfo = tQuestionAnswerService.selectByCondition(TQuestionAnswerDto.assemblyData(tQuestionAnswerDto),pageNum,pageSize);
        return Result.success("查询问卷调查信息成功",tQuestionAnswerVoPageInfo);
    }
}
