package com.bben.bedcard.controller;

import com.bben.bedcard.model.bedcard.TBed;
import com.bben.bedcard.model.bedcard.TBedCard;
import com.bben.bedcard.service.TBedCardService;
import com.bben.bedcard.service.TBedService;
import com.bben.bedcard.vo.TBedCardVo;
import com.bben.bedcard.vo.TBedVo;
import com.bben.common.BaseController;
import com.bben.common.constants.Status;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.U;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Lizhenwei
 * @Date: 2018/11/10 9:55
 */
@Api(tags = "床头卡接口")
@RestController
@RequestMapping("/bedCard")
public class BedCardController extends BaseController {

    @Autowired
    private TBedCardService tBedCardService;

    @Autowired
    private TBedService tBedService;

    @ApiOperation("根据设备编号获取床位及病人信息 -> 李振伟")
    @GetMapping("/getBedInfo")
    public Result<TBedVo> getBedInfo(@ApiParam("设备编号") @RequestParam String code){
        if (U.isBlank(code)){
            return Result.fail("参数不能为空");
        }
        TBedVo tBedVo = null;
        try {
            TBedCard tBedCard = new TBedCard();
            tBedCard.setCode(code);
            tBedCard.setStatus((byte) Status.EFFECTIVE.getStatus().intValue());
            List<TBedCardVo> tBedCardVoList = tBedCardService.selectByCondition(tBedCard);
            if (A.isEmpty(tBedCardVoList)){
                return Result.fail("没有此设备");
            }
            tBedVo = new TBedVo();
            TBedCardVo tBedCardVo = tBedCardVoList.get(0);
            if (U.isNotBlank(tBedCardVo.getId())){
                TBed tBed = new TBed();
                tBed.setBedCardId(tBedCardVo.getId());
                tBed.setStatus((byte) Status.EFFECTIVE.getStatus().intValue());
                List<TBedVo> tBedVoList = tBedService.selectByCondition(tBed);
                if (A.isEmpty(tBedVoList)){
                    return Result.fail("此设备没有绑定床位");
                }
                tBedVo = tBedVoList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result.fail("查询床位信息异常");
        }
        return Result.success("查询床位信息成功",tBedVo);
    }
}
