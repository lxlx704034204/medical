package com.bben.infusion.service.impl;

import com.alibaba.fastjson.JSON;
import com.bben.common.PageInfo;
import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.infusion.config.RedisTemplateUtil;
import com.bben.infusion.mapper.infusion.TControlParamMapper;
import com.bben.infusion.mapper.infusion.TGatherDataMapper;
import com.bben.infusion.mapper.infusion.TPatientInfusionWarnMapper;
import com.bben.infusion.mapper.infusion.TPatientMapper;
import com.bben.infusion.model.infusion.*;
import com.bben.infusion.model.param_model.TPatientInfusionEquipParam;
import com.bben.infusion.model.param_model.TPatientParam;
import com.bben.infusion.service.TPatientService;
import com.bben.infusion.util.Constants;
import com.bben.infusion.util.DateUtil;
import com.bben.infusion.util.VoiceFile;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.jacob.com.Dispatch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service(value = "PatientService")
@CacheConfig(cacheNames = "TPatient")
public class TPatientServiceImpl implements TPatientService {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TPatientMapper tPatientMapper;//这里会报错，但是并不会影响
    @Autowired
    private TGatherDataMapper tGatherDataMapper;
    @Autowired
    private TControlParamMapper tControlParamMapper;
    @Autowired
    private TPatientInfusionWarnMapper tPatientInfusionWarnMapper;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public TPatient selectByPrimaryKey(Integer id) {
        return tPatientMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public int deleteByPrimaryKey(Integer id) {
        return tPatientMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CachePut(key = "#result.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TPatient insertSelective(TPatient record) {
        int count = tPatientMapper.insertSelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    @Override
    @CachePut(key = "#record.id", unless = "#result == null")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TPatient updateByPrimaryKey(TPatient record) {
        int count = tPatientMapper.updateByPrimaryKeySelective(record);
        if (count == 0) {
            return null;
        }

        return record;
    }

    //多条件查询，找出符合条件的记录
    @Override
    public PageInfo<TPatient> findByCondition(TPatient record, int pageNum, int pageSize) {
        TPatientExample tPatientExample = new TPatientExample();
        TPatientExample.Criteria criteria = tPatientExample.createCriteria();

        tPatientExample.setOrderByClause(" code");
        if (U.isNotBlank(record.getCode())) {
            criteria.andCodeEqualTo(record.getCode());
        }

        if (U.isNotBlank(record.getName())) {
            criteria.andNameEqualTo(record.getName());
        }

        criteria.andStatusEqualTo((byte)1);

        PageHelper.startPage(pageNum, pageSize);
        List<TPatient> listTPatient = tPatientMapper.selectByExample(tPatientExample);
        PageInfo<TPatient> pageInfoTPatient = new PageInfo<>(listTPatient);

        return pageInfoTPatient;
    }

    //多条件查询，找出符合条件的记录
    @Override
    public PageInfo<TPatientParam> findPatientEquipByCondition(TPatient record, int pageNum, int pageSize) {
        TPatientExample tPatientExample = new TPatientExample();
        TPatientExample.Criteria criteria = tPatientExample.createCriteria();

        tPatientExample.setOrderByClause(" code");
        if (U.isNotBlank(record.getCode())) {
            criteria.andCodeEqualTo(record.getCode());
        }

        if (U.isNotBlank(record.getName())) {
            criteria.andNameEqualTo(record.getName());
        }

        if (U.isNotBlank(record.getIdType())) {
            criteria.andIdTypeEqualTo(record.getIdType());
        }

        if (U.isNotBlank(record.getIdNumber())) {
            criteria.andIdNumberEqualTo(record.getIdNumber());
        }

        if (U.isNotBlank(record.getMobile())) {
            criteria.andMobileEqualTo(record.getMobile());
        }

        criteria.andStatusEqualTo((byte)1);

        PageHelper.startPage(pageNum, pageSize);
        List<TPatientParam> listTPatient = tPatientMapper.selectPatientEquipByExample(tPatientExample);
        PageInfo<TPatientParam> pageInfoTPatient = new PageInfo<>(listTPatient);

        return pageInfoTPatient;
    }

    @Override
    public List<TPatient> findRunPatientByCondition(TPatient record) {
        TPatientExample tPatientExample = new TPatientExample();
        TPatientExample.Criteria criteria = tPatientExample.createCriteria();

        tPatientExample.setOrderByClause(" bed_no");
        if (U.isBlank(record.getWardId()) || "0".equals(record.getWardId())) return null;
        criteria.andWardIdEqualTo(record.getWardId());
        criteria.andRunStatusEqualTo(Constants.RunStatusConstant.DOING);

        List<TPatient> listTPatient = tPatientMapper.selectByExample(tPatientExample);
        return listTPatient;
    }
    public final ObjectMapper mapper = new ObjectMapper();
    /**
     * 根据病人信息查找对应设备及输液信息
     * @param record
     * @return
     */
    @Override
    public JSONArray findPatientInfusionByCondition(boolean hasVoice,TPatient record){
        String run_infusion_patient_key = "infusion:patient:run:"+record.getWardId();
        if (!redisTemplateUtil.hasKey(run_infusion_patient_key)) {
            //输液看板正在输液用户10分钟查询一次
            redisTemplateUtil.set(run_infusion_patient_key,findRunPatientByCondition(record), 600);
        }
        List<TPatient> tPatientList = (ArrayList<TPatient>)redisTemplateUtil.get(run_infusion_patient_key);
        JSONArray jsonArray = new JSONArray();
        if (A.isEmpty(tPatientList)) return jsonArray;
        JSONArray voiceArray = new JSONArray();
        JSONArray vpArray = new JSONArray();
        //List<TPatientInfusionWarn> warnListd = Collections.synchronizedList(new ArrayList<>());
        List<TPatientInfusionWarn> warnList = new ArrayList<TPatientInfusionWarn>();

        String control_end_warn = Constants.ControlParam.INFUSION_END_WARN;//输液【已经】结束阀值百分比
        String control_ending_warn = Constants.ControlParam.INFUSION_ENDING_WARN;//输液【即将】结束阀值百分比
        if (!redisTemplateUtil.hasKey(control_end_warn) || U.isBlank(redisTemplateUtil.get(control_end_warn))) {
            TControlParam tcEndWarn = tControlParamMapper.selectByPrimaryKey(Constants.ControlParam.INFUSION_END_WARN);
            if (U.isNotBlank(tcEndWarn)) {
                redisTemplateUtil.set(control_end_warn, tcEndWarn.getValue(), 14400);//保存4小时
            } else {
                redisTemplateUtil.set(control_end_warn, Constants.ControlParam.INFUSION_END_WARN_DEFAULT, 14400);//保存4小时
            }
        }
        if (!redisTemplateUtil.hasKey(control_ending_warn) || U.isBlank(redisTemplateUtil.get(control_ending_warn))) {
            TControlParam tcEndingWarn = tControlParamMapper.selectByPrimaryKey(Constants.ControlParam.INFUSION_ENDING_WARN);
            if (U.isNotBlank(tcEndingWarn)) {
                redisTemplateUtil.set(control_ending_warn, tcEndingWarn.getValue(), 14400);//保存4小时
            } else {
                redisTemplateUtil.set(control_ending_warn, Constants.ControlParam.INFUSION_ENDING_WARN_DEFAULT, 14400);//保存4小时
            }
        }
        int ending_warn = Integer.parseInt(redisTemplateUtil.get(control_ending_warn).toString());
        int end_warn = Integer.parseInt(redisTemplateUtil.get(control_end_warn).toString());

        tPatientList.forEach(p -> {
            int boardStatus = Constants.BoardStatus.BLUE;
            int infusionStatus = Constants.InfusionStatus.NORMAL;
            int batteryStatus = Constants.BatteryStatus.NORMAL;
            int speed = 0;

            //正在输液的病人设备电池信息
            String infusion_patient = "infusion_patient" + Constants.redisSplit + p.getWardId() + Constants.redisSplit + p.getId();
            if (!redisTemplateUtil.hasKey(infusion_patient) || U.isBlank(redisTemplateUtil.get(infusion_patient))) {
                TPatientInfusionEquipParam pInfusionEquip = tPatientMapper.selectPatientInfusionEquipByCon(p.getId());
                if (U.isBlank(pInfusionEquip)) return;
                redisTemplateUtil.set(infusion_patient, pInfusionEquip, 3600);//保存1小时
            }
            TPatientInfusionEquipParam tPatientInfusionEquip = (TPatientInfusionEquipParam)redisTemplateUtil.get(infusion_patient);

            org.json.simple.JSONObject jsonObject = new org.json.simple.JSONObject();
            jsonObject.put("pId", p.getId());
            jsonObject.put("pName", p.getName());
            jsonObject.put("bedNo", p.getBedNo());
            jsonObject.put("nurseLevel", p.getNurseLevel());
            jsonObject.put("sex", p.getSex());
            jsonObject.put("cureNo", p.getCureNo());
            jsonObject.put("infusionNo", tPatientInfusionEquip.getInfusionNo());
            jsonObject.put("sequenceId", tPatientInfusionEquip.getSequenceId());
            jsonObject.put("drugNameList", JSONValue.parse(tPatientInfusionEquip.getDrugNameList()));
            jsonObject.put("normalDrip", tPatientInfusionEquip.getNormalDrip());
            jsonObject.put("beginTime", tPatientInfusionEquip.getBeginTime());
            jsonObject.put("equipmentSn", tPatientInfusionEquip.getEquipmentSn());
            jsonObject.put("continueTime", tPatientInfusionEquip.getContinueTime());

            //从Redis里面获取集合
            List<TGatherData> tGatherDataList = redisTemplateUtil.lListRange(tPatientInfusionEquip.getEquipmentSn(), 0, Constants.RECENTLY_GATHER);
            if (A.isEmpty(tGatherDataList)) {//缓存中不存在数据
                TGatherDataExample tGatherDataExample = new TGatherDataExample();
                TGatherDataExample.Criteria tgdecriteria = tGatherDataExample.createCriteria();
                //查询最近监控中大于执行时间的五条数据
                tGatherDataExample.setOrderByClause(" create_time DESC LIMIT 5");
                tgdecriteria.andEquipmentSnEqualTo(tPatientInfusionEquip.getEquipmentSn());
                tgdecriteria.andCreateTimeGreaterThanOrEqualTo(tPatientInfusionEquip.getBeginTime());
                tGatherDataList = tGatherDataMapper.selectByExample(tGatherDataExample);

                //真实数据采集中已经缓存数据不需要此操作，此处作为模拟效果
                tGatherDataList.forEach(tgd -> {
                    redisTemplateUtil.lList(tPatientInfusionEquip.getEquipmentSn(),tgd, 36000);//10小时的保存时间
                });
            }

            //未获取到监控数据：认为是设备故障
            if (A.isEmpty(tGatherDataList)) {
                boardStatus = Constants.BoardStatus.BROWN;
                infusionStatus = Constants.InfusionStatus.ERROR;
                jsonObject.put("percent", 0);//剩余百分比
                jsonObject.put("speed", speed);//滴速
                jsonObject.put("boardStatus", boardStatus);
                jsonObject.put("infusionStatus", infusionStatus);
                jsonObject.put("batteryStatus", batteryStatus);
                //发送患者输液告警记录
                insertInfusionWarnObj(p.getId(), tPatientInfusionEquip.getEquipmentSn(), infusionStatus, 0);
                jsonArray.add(jsonObject);
                return;
            }

            //开始计算速度 百分比 语音播放
            int currentWeight = tGatherDataList.get(0).getWeight();
            int bottleWeight = tPatientInfusionEquip.getBottleWeight();
            int bottleLiquidWeight = tPatientInfusionEquip.getBottleLiquidWeight();
            //(当前质量 - 瓶子重量)/总质量*100%
            int percent = ((currentWeight - bottleWeight) * 100 / bottleLiquidWeight);

            //判断设备一开始绑定时候的电池id的电压值是否小于告警阀值，因为一旦输液就会产生监控数据
            //当前电压值<=该设备类型电量低告警阀值 为电量不足
            int voltageWarn = tPatientInfusionEquip.getVoltageWarn();
            if (tPatientInfusionEquip.getVoltage() <= voltageWarn || tGatherDataList.get(0).getVoltage() <= voltageWarn){
                batteryStatus = Constants.BatteryStatus.LACK;
            }
            int reduWeight = tGatherDataList.get(tGatherDataList.size() - 1).getWeight() - currentWeight;
            if (reduWeight == 0) {
                boardStatus = Constants.BoardStatus.RED;
                infusionStatus = Constants.InfusionStatus.PAUSE;
            } else {
                double reduTime = DateUtil.timeIntervalMin(tGatherDataList.get(0).getCreateTime(), tGatherDataList.get(tGatherDataList.size() - 1).getCreateTime());
                //花费的质量（最后一个 - 第一个）【g】/ 花费的时间（第一个 - 最后一个时间）【折算成分钟】 / 0.05g = 速度（滴/分）
                speed = (int) (reduWeight / reduTime / 0.05);
                if (speed > tPatientInfusionEquip.getMaxDrip()) {
                    boardStatus = Constants.BoardStatus.RED;
                    infusionStatus = Constants.InfusionStatus.FAST;
                } else if (speed < tPatientInfusionEquip.getMinDrip()) {
                    boardStatus = Constants.BoardStatus.RED;
                    infusionStatus = Constants.InfusionStatus.SLOW;
                }
            }
            //净液重*(100-85)%+瓶重=即将结束的质量
            int endingWeight = bottleLiquidWeight * (100 - ending_warn) / 100 + bottleWeight;
            int endWeight = bottleLiquidWeight * (100 - end_warn) / 100 + bottleWeight;
            if (currentWeight <= endWeight) {
                boardStatus = Constants.BoardStatus.RED;
                infusionStatus = Constants.InfusionStatus.OVER;
                if (hasVoice){
                    //加入语音通知
                    String key = Constants.INFUSION_PREFIX_REDIS + Constants.redisSplit + p.getWardId() + Constants.redisSplit + p.getId() + Constants.redisSplit + p.getBedNo();
                    if (!redisTemplateUtil.hasKey(key) || U.isBlank(redisTemplateUtil.get(key))) {
                        String date = DateUtil.SDF_STANDARD_DAY.format(new Date());
                        String fileName = String.valueOf(System.nanoTime()) + Constants.voiceSuffix;
                        String voicePath = Constants.voicePath + date + "/" + fileName;
                        voiceArray.add(voicePath);
                        JSONObject vj = new JSONObject();
                        vj.put("date",date);
                        vj.put("bedNo",p.getBedNo());
                        vj.put("fileName",fileName);
                        vj.put("key",key);
                        vj.put("voicePath",voicePath);
                        vpArray.add(vj);
                    } else {
                        voiceArray.add(redisTemplateUtil.get(key).toString());
                        //真实环境不需要加这段，因为测试数据固定且访问频繁，不能超时以后又生成语音
                        redisTemplateUtil.set(key, redisTemplateUtil.get(key).toString(), 1800);//该床位号呼叫播报有效时间30分钟
                    }
                }
            } else if (currentWeight <= endingWeight) {
                boardStatus = Constants.BoardStatus.YELLOW;
                infusionStatus = Constants.InfusionStatus.ENDING;
            }

            //添加输液告警记录
            if (batteryStatus != Constants.BatteryStatus.NORMAL) {
                TPatientInfusionWarn tPatientInfusionWarn = new TPatientInfusionWarn();
                tPatientInfusionWarn.setPatientId(p.getId());
                tPatientInfusionWarn.setDripSpeed(speed);
                tPatientInfusionWarn.setEquipmentSn(tPatientInfusionEquip.getEquipmentSn());
                tPatientInfusionWarn.setInfusionStatus(7);
                warnList.add(tPatientInfusionWarn);
            }
            if (infusionStatus != Constants.InfusionStatus.NORMAL) {
                TPatientInfusionWarn tPatientInfusionWarn = new TPatientInfusionWarn();
                tPatientInfusionWarn.setPatientId(p.getId());
                tPatientInfusionWarn.setDripSpeed(speed);
                tPatientInfusionWarn.setEquipmentSn(tPatientInfusionEquip.getEquipmentSn());
                tPatientInfusionWarn.setInfusionStatus(infusionStatus);
                warnList.add(tPatientInfusionWarn);
            }
            jsonObject.put("percent", percent);//剩余百分比
            jsonObject.put("speed", speed);//滴速
            jsonObject.put("boardStatus", boardStatus);
            jsonObject.put("infusionStatus", infusionStatus);
            jsonObject.put("batteryStatus", batteryStatus);
            jsonArray.add(jsonObject);
        });
        if (hasVoice && A.isNotEmpty(voiceArray)){
            org.json.simple.JSONObject voiceObject = new org.json.simple.JSONObject();
            voiceObject.put("voice",voiceArray);
            jsonArray.add(voiceObject);
        };

        //异步生成语音文件
        if (A.isNotEmpty(vpArray)){
            new Thread(() -> {
                for (int i=0;i<vpArray.size();i++){
                    JSONObject jb = (JSONObject)vpArray.get(i);
                    VoiceFile.voiceConvertFile(String.valueOf(jb.get("date")), String.valueOf(jb.get("bedNo")) + "床输液结束", String.valueOf(jb.get("fileName")));
                    redisTemplateUtil.set(String.valueOf(jb.get("key")), String.valueOf(jb.get("voicePath")), 1800);//该床位号结束播报有效时间30分钟
                }
            }).start();
        };

        //添加输液告警记录
        if (A.isNotEmpty(warnList)){
            new Thread(() -> {
                for (TPatientInfusionWarn piw:warnList){
                    insertInfusionWarn(piw);
                }
            }).start();
        }
        return jsonArray;
    }

    /**
     * 新增输液告警记录
     * @param tPatientInfusionWarn
     * @return
     */
    private int insertInfusionWarn(TPatientInfusionWarn tPatientInfusionWarn){
        //输液状态 0：正常  1：过快 2：过慢 3：即将结束 4：输液暂停 5：已结束待处理 6：设备故障
        String warnType = TPatientInfusionWarn.WarnTypeConstant.LACK;
        switch (tPatientInfusionWarn.getInfusionStatus()){
            case 1:
                warnType = TPatientInfusionWarn.WarnTypeConstant.FAST;
                break;
            case 2:
                warnType = TPatientInfusionWarn.WarnTypeConstant.SLOW;
                break;
            case 3:
                warnType = TPatientInfusionWarn.WarnTypeConstant.ENDING;
                break;
            case 4:
                warnType = TPatientInfusionWarn.WarnTypeConstant.PAUSE;
                break;
            case 5:
                warnType = TPatientInfusionWarn.WarnTypeConstant.OVER;
                break;
            case 6:
                warnType = TPatientInfusionWarn.WarnTypeConstant.ERROR;
                break;
            default:
                warnType = TPatientInfusionWarn.WarnTypeConstant.LACK;
                break;
        }

        tPatientInfusionWarn.setWarnType(warnType);
        tPatientInfusionWarn.setWarnTime(new Date());
        tPatientInfusionWarn.setCreateTime(new Date());
        return tPatientInfusionWarnMapper.insertSelective(tPatientInfusionWarn);
    }

    /**
     * 单个新增输液告警记录
     * @param pid
     * @param equipmentSn
     * @param infusionStatus
     * @param speed
     * @return
     */
    private int insertInfusionWarnObj(int pid,String equipmentSn,int infusionStatus,int speed){
        TPatientInfusionWarn tPatientInfusionWarn = new TPatientInfusionWarn();
        //输液状态 0：正常  1：过快 2：过慢 3：即将结束 4：输液暂停 5：已结束待处理 6：设备故障
        String warnType = TPatientInfusionWarn.WarnTypeConstant.LACK;
        switch (infusionStatus){
            case 1:
                warnType = TPatientInfusionWarn.WarnTypeConstant.FAST;
                break;
            case 2:
                warnType = TPatientInfusionWarn.WarnTypeConstant.SLOW;
                break;
            case 3:
                warnType = TPatientInfusionWarn.WarnTypeConstant.ENDING;
                break;
            case 4:
                warnType = TPatientInfusionWarn.WarnTypeConstant.PAUSE;
                break;
            case 5:
                warnType = TPatientInfusionWarn.WarnTypeConstant.OVER;
                break;
            case 6:
                warnType = TPatientInfusionWarn.WarnTypeConstant.ERROR;
                break;
            default:
                warnType = TPatientInfusionWarn.WarnTypeConstant.LACK;
                break;
        }

        tPatientInfusionWarn.setPatientId(pid);
        tPatientInfusionWarn.setEquipmentSn(equipmentSn);
        tPatientInfusionWarn.setWarnType(warnType);
        tPatientInfusionWarn.setDripSpeed(speed);
        tPatientInfusionWarn.setWarnTime(new Date());
        tPatientInfusionWarn.setCreateTime(new Date());
        return tPatientInfusionWarnMapper.insertSelective(tPatientInfusionWarn);
    }

}
