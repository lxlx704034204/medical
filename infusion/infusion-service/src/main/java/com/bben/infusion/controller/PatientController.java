package com.bben.infusion.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bben.common.BaseController;
import com.bben.common.PageInfo;
import com.bben.common.entity.vo.Result;
import com.bben.common.util.A;
import com.bben.common.util.JsonUtil;
import com.bben.common.util.U;
import com.bben.infusion.config.RedisTemplateUtil;
import com.bben.infusion.dto.TPatientDto;
import com.bben.infusion.model.infusion.*;
import com.bben.infusion.model.param_model.TPatientParam;
import com.bben.infusion.service.*;
import com.bben.infusion.util.Constants;
import com.bben.infusion.util.DateUtil;
import com.bben.infusion.util.VoiceFile;
import com.bben.infusion.vo.TPatientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Api(tags = "病人接口")
@RestController
@RequestMapping(value = "/patient")
public class PatientController extends BaseController {

    @Autowired
    private TPatientService tPatientService;
    @Autowired
    private TPatientEquipRefService tPatientEquipRefService;
    @Autowired
    private TInfusionEquipService tInfusionEquipService;
    @Autowired
    private TPatientInfusionInfoService tPatientInfusionInfoService;
    @Autowired
    private TGatherDataService tGatherDataService;

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @PostMapping("/addtest")
    @ApiOperation("测试 -> lsq")
    public Result addTPatientTest() throws InterruptedException {

        //Redis插入测试数据

        TGatherData gatherData = new TGatherData();
        gatherData.setVoltage(380);
        gatherData.setWeight(249);
        gatherData.setCreateTime(new Date());
        gatherData.setEquipmentSn("SN00001");
        gatherData.setIp("172.40.1.137");
        gatherData.setPort(8082);
        String str_equipment = JSON.toJSONString(gatherData);
        redisTemplateUtil.lList("SN00001", gatherData, 300);
        Thread.sleep(500);
        TGatherData tt = new TGatherData();
        tt.setVoltage(379);
        tt.setWeight(248);
        tt.setCreateTime(new Date());
        tt.setEquipmentSn("SN00001");
        tt.setIp("172.40.1.137");
        tt.setPort(8082);
        String str_equipmenttt = JSON.toJSONString(tt);
        redisTemplateUtil.lList("SN00001", tt, 300);


        List<TGatherData> tGatherDataList = redisTemplateUtil.lListRange("SN00001", 0, Constants.RECENTLY_GATHER);
        for (TGatherData tg:tGatherDataList){
            System.out.println(tg.getEquipmentSn());
            System.out.println(tg.getVoltage());
        }

        List<TGatherData> ttList = (ArrayList<TGatherData>)redisTemplateUtil.lListRange("SN00001",0,2);
        System.out.println("ttList="+ttList);
        for (TGatherData tg:ttList){
            System.out.println(tg.getEquipmentSn());
            System.out.println(tg.getVoltage());
        };
//        Thread.sleep(2000);
//        TGatherData aa = new TGatherData();
//        aa.setVoltage(300);
//        aa.setWeight(200);
//        aa.setCreateTime(new Date());
//        aa.setEquipmentSn("SN00001");
//        aa.setIp("172.40.1.137");
//        aa.setPort(8082);
//        String str_equipmentaa = JSON.toJSONString(aa);
//        redisTemplateUtil.lList("SN00001", str_equipmentaa, 3600);
//
//        System.out.println("获取list缓存的长度："+redisTemplateUtil.lListSize("SN00001"));
//        System.out.println("通过索引 获取list中的值："+redisTemplateUtil.lListIndex("SN00001",0));
//
//        //即使数据不够也不会数组越界
//        System.out.println("通过索引范围 获取list中的值："+redisTemplateUtil.lListRange("SN00001",0,4));
//
//        List<TGatherData> tGatherDataLi = JSONArray.parseArray(redisTemplateUtil.lListRange("SN00001",0,1).toString(),TGatherData.class);
//        if (A.isNotEmpty(tGatherDataLi)){
//            tGatherDataLi.forEach(s ->{
//                System.out.println(s.getEquipmentSn());
//                System.out.println(s.getCreateTime());
//            });
//        }
//        List<TGatherData> tGatherDataList = redisTemplateUtil.lListRange("SN00001",0,4);
        //加入语音通知
//        String key = 1 + Constants.redisSplit + "NO1";
////        log.info("redisTemplateUtil.hasKey(key) -> {} ",redisTemplateUtil.hasKey(key));
////        log.info("redisTemplateUtil.get(key) -> {} ",redisTemplateUtil.get(key));
////        log.info("U.isBlank(redisTemplateUtil.get(key)) -> {} ",U.isBlank(redisTemplateUtil.get(key)));
////        if(!redisTemplateUtil.hasKey(key) && U.isBlank(redisTemplateUtil.get(key))){
////            String voice = VoiceFile.voiceConvertFile("1床输液结束");
////                if (U.isNotBlank(voice)){
////                redisTemplateUtil.set(key,voice,60);//1分钟
////            }
////        }
        return Result.success("添加病人记录成功");
    }

    @PostMapping("/add")
    @ApiOperation("添加病人记录 -> 陈旭东")
    public Result addTPatient(TPatientDto tPatientDto) {
        //转换成需要显示的类型
        TPatient tPatient = JsonUtil.convert(tPatientDto, TPatient.class);
        TPatient ok = tPatientService.insertSelective(tPatient);

        if (U.isBlank(ok)) {
            return Result.fail("add病人信息失败");
        }

        log.info("Return Code:" + ok.getCode());
        return Result.success("添加病人记录成功");
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除病人记录 -> 陈旭东")
    public Result delTPatient(@ApiParam("id") @RequestParam Integer id) {
        int ok = tPatientService.deleteByPrimaryKey(id);
        if (ok == 0) {
            return Result.fail("删除病人信息失败");
        }

        return Result.success("删除病人信息成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改病人记录 -> 陈旭东")
    public Result updateTPatient(TPatient tPatient) {
        TPatient tPatient1 = tPatientService.updateByPrimaryKey(tPatient);
        if (U.isBlank(tPatient1)) {
            return Result.fail("修改病人信息失败");
        }
        return Result.success("修改病人信息成功");
    }

    @GetMapping("/select")
    @ApiOperation("获取病人信息 -> 陈旭东")
    public Result<TPatientVo> selecTPatient(@ApiParam("id") @RequestParam Integer id) {
        TPatient tPatient = tPatientService.selectByPrimaryKey(id);
        if (U.isBlank(tPatient)) {
            return Result.success("无病人数据");
        }

        //转换成需要显示的类型
        TPatientVo tPatientVo = JsonUtil.convert(tPatient, TPatientVo.class);

        return Result.success("获取病人信息成功", tPatientVo);
    }

    @GetMapping("/findByCondition")
    @ApiOperation("根据条件查找病人信息 -> 陈旭东")
    public Result<PageInfo<TPatient>> findByCondition(TPatient tPatient,
                                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TPatient> pageInfoTPatient = tPatientService.findByCondition(tPatient, pageNum, pageSize);
        if (U.isBlank(pageInfoTPatient)) {
            return Result.success("无病人数据");
        }

        return Result.success("根据条件查找病人信息成功", pageInfoTPatient);
    }

    @GetMapping("/findPatientEquipByCondition")
    @ApiOperation("根据条件查找病人与输液监控关系信息 -> 陈旭东")
    public Result<PageInfo<TPatientParam>> findPatientEquipByCondition(TPatient tPatient,
                                                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<TPatientParam> pageInfoTPatient = tPatientService.findPatientEquipByCondition(tPatient, pageNum, pageSize);
        if (U.isBlank(pageInfoTPatient)) {
            return Result.success("无数据");
        }

        return Result.success("根据条件查找信息成功", pageInfoTPatient);
    }
}
