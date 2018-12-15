package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TQuestionDto;
import com.bben.bedcard.model.bedcard.TQuestion;
import com.bben.bedcard.service.TQuestionService;
import com.bben.bedcard.vo.TQuestionVo;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/14 15:46
 */
@Api(tags = "问卷调查接口")
@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController {

    @Autowired
    private TQuestionService tQuestionService;

    public Result addTQuestionError(TQuestionDto tQuestionDto){
        return Result.fail("添加问卷调查失败");
    }

    public Result updateTQuestionError(TQuestion tQuestion){
        return Result.fail("更新问卷调查失败");
    }

    @GetMapping("/selectByQuestionId")
    @ApiOperation("根据Id查询问卷调查信息 -> 李振伟")
    public Result<TQuestionVo> selectByQuestionId(@ApiParam("问卷调查Id") @RequestParam Integer questionId,
                                                  @ApiParam("用户id") @RequestParam Integer userId){
        if (U.isBlank(questionId)){
            return Result.fail("参数不能为空");
        }
        TQuestionVo tQuestionVo = tQuestionService.selectByPrimaryKey(questionId, userId);
        if (U.isBlank(tQuestionVo)){
            return Result.fail("查询数据位空");
        }
        return  Result.success("查询数据成功",tQuestionVo);
    }

    @PostMapping("/addTQuestion")
    @ApiOperation("添加问卷调查信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTQuestionError")
    public Result addTQuestion(TQuestionDto tQuestionDto){
        if (U.isBlank(tQuestionDto)){
            return Result.fail("对象不能为空");
        }
        TQuestion ok = tQuestionService.insertSelective(TQuestionDto.assemblyData(tQuestionDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TRoleId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTQuestion")
    @ApiOperation("更新问卷调查信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTQuestionError")
    public Result updateTQuestion(TQuestion tQuestion){
        if (U.isBlank(tQuestion)){
            return Result.fail("对象不能为空");
        }
        TQuestion ok = tQuestionService.updateByPrimarykey(tQuestion);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByQuestionId")
    @ApiOperation("删除问卷调查信息 -> 李振伟")
    public Result deleteByQuestionId(@ApiParam("问题列表id") @RequestParam Integer querstionId){
        if (U.isBlank(querstionId)){
            return Result.fail("参数不能为空");
        }
        int ok = tQuestionService.deleteByPrimarykey(querstionId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @GetMapping("/getTQuestionVoByPage")
    @ApiOperation("按照分页查询问卷调查信息 -> 李振伟")
    public Result<PageInfo<TQuestionVo>> getTQuestionVoByPage(@ApiParam("用户id") @RequestParam Integer userId, @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TQuestionVo> tQuestionVoPageInfo = tQuestionService.selectByPage(userId,pageNum,pageSize);
        return Result.success("查询问卷调查信息成功",tQuestionVoPageInfo);
    }

    @PostMapping("/getTQuestionVoByCondition")
    @ApiOperation("根据条件查询问卷调查信息 -> 李振伟")
    public  Result<PageInfo<TQuestionVo>> getTQuestionVoByCondition(@ApiParam("用户id") @RequestParam Integer userId,TQuestionDto tQuestionDto,
                                                            @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                            @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TQuestionVo> tQuestionVoPageInfo = tQuestionService.selectByCondition(userId,TQuestionDto.assemblyData(tQuestionDto),pageNum,pageSize);
        return Result.success("查询问卷调查信息成功",tQuestionVoPageInfo);
    }
}
