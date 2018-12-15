package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TUserQuestionnaireDto;
import com.bben.bedcard.model.bedcard.TUserQuestionnaire;
import com.bben.bedcard.service.TUserQuestionnaireService;
import com.bben.bedcard.vo.TUserQuestionnaireVo;
import com.bben.common.BaseController;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/15 11:53
 */
@Api(tags = "用户问卷调查接口")
@RestController
@RequestMapping("/userQuestionnaire")
public class UserQuestionnaireController extends BaseController {

    @Autowired
    private TUserQuestionnaireService tUserQuestionnaireService;

    @GetMapping("/selectTUserQuestionnaireAll")
    @ApiOperation("查询所有用户问卷调查 -> 李振伟")
    public Result<List<TUserQuestionnaireVo>> selectTUserQuestionnaireAll(){
        List<TUserQuestionnaireVo> tUserQuestionnaireVos = new ArrayList<>();
        try {
            tUserQuestionnaireVos = tUserQuestionnaireService.findAll();
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("查询数据异常");
        }
        return Result.success("查询数据成功",tUserQuestionnaireVos);
    }

    @GetMapping("/selectTUserQuestionnaireById")
    @ApiOperation("根据id查询用户调查问卷 -> 李振伟")
    public Result<TUserQuestionnaireVo> selectTUserQuestionnaireById(@ApiParam("调查问卷id") @RequestParam Integer userQuestionnaireId){
        if (U.isBlank(userQuestionnaireId)){
            return Result.fail("参数不能为空");
        }
        TUserQuestionnaireVo tUserQuestionnaireVo;
        try {
            tUserQuestionnaireVo = tUserQuestionnaireService.selectByPrimaryKey(userQuestionnaireId);
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("查询数据异常");
        }
        return Result.success("查询数据成功",tUserQuestionnaireVo);
    }

    @PostMapping("/addTUserQuestionnaire")
    @ApiOperation("提交用户调查问卷 -> 李振伟")
    public Result addTUserQuestionnaire(@ApiParam("用户答案id,多个用英文','隔开") @RequestParam String questionAnswerIds,
                                        @ApiParam("用户id") @RequestParam Integer userId){
        if (U.isBlank(questionAnswerIds)){
            return Result.fail("参数不能为空");
        }
        int ok ;
        try {
            ok = tUserQuestionnaireService.insertSelective(questionAnswerIds,userId);
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("添加数据异常");
        }
        if (0 == ok){
            return Result.fail("添加数据失败");
        }
        return Result.success("添加数据成功");
    }

    @PostMapping("/updateTUserQuestionnaire")
    @ApiOperation("更新用户调查问卷 -> 李振伟")
    public Result updateTUserQuestionnaire(TUserQuestionnaire tUserQuestionnaire){
        if (U.isBlank(tUserQuestionnaire)){
            return Result.fail("参数不能为空");
        }
        TUserQuestionnaire ok;
        try {
            ok = tUserQuestionnaireService.updateByPrimarykey(tUserQuestionnaire);
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("更新数据异常");
        }
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @GetMapping("/deleteTUserQuestionnaireById")
    @ApiOperation("删除调查问卷接口 -> 李振伟")
    public Result deleteTUserQuestionnaireById(@ApiParam("调查问卷id") @RequestParam Integer userQuestionnaireId){
        if (U.isBlank(userQuestionnaireId)){
            return Result.fail("参数不能为空");
        }
        int ok;
        try {
            ok = tUserQuestionnaireService.deleteByPrimarykey(userQuestionnaireId);
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("删除数据异常");
        }
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/selectByCondition")
    @ApiOperation("按条件查询调查问卷接口 -> 李振伟")
    public Result<List<TUserQuestionnaireVo>> selectByCondition(TUserQuestionnaireDto tUserQuestionnaireDto){
        List<TUserQuestionnaireVo> tUserQuestionnaireVoList = new ArrayList<>();
        try {
            tUserQuestionnaireVoList = tUserQuestionnaireService.selectByCondition(TUserQuestionnaireDto.assemblyData(tUserQuestionnaireDto));
        } catch (Exception e){
            e.printStackTrace();
            return Result.fail("查询数据异常");
        }

        return Result.success("查询数据成功",tUserQuestionnaireVoList);
    }

}
