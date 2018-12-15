package com.bben.bedcard.controller;

import com.bben.bedcard.dto.TVideoDto;
import com.bben.bedcard.model.bedcard.TVideo;
import com.bben.bedcard.service.TVideoService;
import com.bben.bedcard.vo.TVideoVo;
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

@Api(tags = "视频接口")
@RestController
@RequestMapping("/video")
public class VideoController extends BaseController {


    @Autowired
    private TVideoService tVideoService;

    public Result addTVideoError(TVideoDto tVideoDto){
        return Result.fail("添加视频失败");
    }

    public Result updateTVideoError(TVideo tVideo){
        return Result.fail("更新视频失败");
    }

    @GetMapping("/selectByVideoId")
    @ApiOperation("根据Id查询视频信息 -> 李振伟")
    public Result<TVideoVo> selectByVideoId(@ApiParam("视频Id") @RequestParam Integer videoId){
        if (U.isBlank(videoId)){
            return Result.fail("参数不能为空");
        }
        TVideoVo tVideoVo = tVideoService.selectByPrimaryKey(videoId);
        return  Result.success("查询数据成功",tVideoVo);
    }

    @PostMapping("/addTVideo")
    @ApiOperation("添加视频信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "addTVideoError")
    public Result addTVideo(TVideoDto tVideoDto){
        if (U.isBlank(tVideoDto)){
            return Result.fail("对象不能为空");
        }
        TVideo ok = tVideoService.insertSelective(TVideoDto.assemblyData(tVideoDto));
        if (U.isBlank(ok)){
            return Result.fail("添加数据失败");
        }
        log.info("TVideoId : "+ok.getId());
        return Result.success("添加数据成功");

    }

    @PostMapping("/updateTVideo")
    @ApiOperation("更新视频信息 -> 李振伟")
    @HystrixCommand(fallbackMethod = "updateTVideoError")
    public Result updateTVideo(TVideo tVideo){
        if (U.isBlank(tVideo)){
            return Result.fail("对象不能为空");
        }
        TVideo ok = tVideoService.updateByPrimarykey(tVideo);
        if (U.isBlank(ok)){
            return Result.fail("更新数据失败");
        }
        return Result.success("更新数据成功");
    }

    @DeleteMapping("/deleteByVideoId")
    @ApiOperation("删除视频信息 -> 李振伟")
    public Result deleteByVideoId(@ApiParam("视频id") @RequestParam Integer videoId){
        if (U.isBlank(videoId)){
            return Result.fail("参数不能为空");
        }
        int ok = tVideoService.deleteByPrimarykey(videoId);
        if (0 == ok){
            return Result.fail("删除数据失败");
        }
        return Result.success("删除数据成功");
    }

    @PostMapping("/getTVideoVoByCondition")
    @ApiOperation("根据条件查询视频信息 -> 李振伟")
    public  Result<PageInfo<TVideoVo>> getTVideoVoByCondition(TVideoDto tVideoDto,
                                                      @RequestParam(name = "pageNum",required = false,defaultValue = "1")int pageNum,
                                                      @RequestParam(name = "pageSize",required = false,defaultValue = "10")int pageSize){
        PageInfo<TVideoVo> tVideoVoPageInfo = tVideoService.selectByCondition(TVideoDto.assemblyData(tVideoDto),pageNum,pageSize);
        if (U.isBlank(tVideoVoPageInfo)){
            return Result.success("查询视频信息成功");
        }
        PageHelper.startPage(pageNum,pageSize);
        return Result.success("查询视频信息成功",tVideoVoPageInfo);
    }

}
