package com.bben.infusion.service.impl;

import com.bben.common.util.A;
import com.bben.common.util.U;
import com.bben.infusion.config.RedisTemplateUtil;
import com.bben.infusion.mapper.infusion.TPatientCallMapper;
import com.bben.infusion.model.infusion.TPatientCall;
import com.bben.infusion.model.infusion.TPatientCallExample;
import com.bben.infusion.service.TPatientCallService;
import com.bben.infusion.util.Constants;
import com.bben.infusion.util.DateUtil;
import com.bben.infusion.util.VoiceFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service(value = "PatientCallService")
@CacheConfig(cacheNames = "TPatientCall")
public class TPatientCallServiceImpl implements TPatientCallService{
    @Autowired
    private TPatientCallMapper tPatientCallMapper;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Override
    public List<TPatientCall> selectByExample(TPatientCallExample example) {
        return tPatientCallMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "#id", unless = "#result == null")
    public TPatientCall selectByPrimaryKey(Integer id) {
        return tPatientCallMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONArray selectByCondition(TPatientCall record) {
        JSONArray jsonArray = new JSONArray();
        JSONArray voiceArray = new JSONArray();
        JSONObject voiceObject = new JSONObject();

        TPatientCallExample tPatientCallExample = new TPatientCallExample();
        TPatientCallExample.Criteria criteria = tPatientCallExample.createCriteria();
        tPatientCallExample.setOrderByClause(" create_time DESC");

        if (U.isNotBlank(record.getWardId())) criteria.andWardIdEqualTo(record.getWardId());
        //真实环境是分钟，此次为了测试改成2天
        //if (U.isNotBlank(record.getCreateTime())) criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getBeformMinuteTime(new Date(),Constants.CALL_INTERVAL_TIME))
        if (U.isNotBlank(record.getCreateTime())) criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getBeforeDayTime(record.getCreateTime(),Constants.CALL_INTERVAL_TIME));
        List<TPatientCall> tPatientCallList = tPatientCallMapper.selectByExample(tPatientCallExample);

        tPatientCallList.forEach(pc -> {
            JSONObject jsonObject = new JSONObject();
            // key = "call" + 病区id + 病人id + 床位号
            String key = Constants.CALL_PREFIX_REDIS + Constants.redisSplit + pc.getWardId() + Constants.redisSplit + pc.getPatientId() + Constants.redisSplit + pc.getBedNo();
            if(!redisTemplateUtil.hasKey(key) || U.isBlank(redisTemplateUtil.get(key))){
                String date = DateUtil.SDF_STANDARD_DAY.format(new Date());
                String fileName = String.valueOf(System.nanoTime()) + Constants.voiceSuffix;
                String voicePath = Constants.voicePath + date + "/" + fileName;
                new Thread(() -> {
                    VoiceFile.voiceConvertFile(date,pc.getBedNo()+"床呼叫",fileName);
                    redisTemplateUtil.set(key,voicePath,1800);//该床位号呼叫播报有效时间30分钟
                }).start();
                voiceArray.add(voicePath);
            }else{
                voiceArray.add(redisTemplateUtil.get(key).toString());
                //真实环境不需要加这段，因为测试数据固定且访问频繁，不能超时以后又生成语音
                redisTemplateUtil.set(key,redisTemplateUtil.get(key).toString(),1800);//该床位号呼叫播报有效时间30分钟
            }
            jsonObject.put("pId",pc.getPatientId());
            jsonObject.put("bId",pc.getBedId());
            jsonObject.put("bedNo",pc.getBedNo());
            jsonObject.put("bedCardId",pc.getBedCardId());
            jsonArray.add(jsonObject);
        });
        if (A.isNotEmpty(voiceArray)){
            voiceObject.put("voice",voiceArray);
            jsonArray.add(voiceObject);
        };
        return jsonArray;
    }

}
