//package com.bben.infusion.task;
//
//import com.alibaba.fastjson.JSON;
//import com.bben.common.entity.vo.Result;
//import com.bben.common.util.A;
//import com.bben.common.util.U;
//import com.bben.infusion.model.infusion.TPatientCall;
//import com.bben.infusion.model.infusion.TWard;
//import com.bben.infusion.service.TPatientCallService;
//import com.bben.infusion.service.TWardService;
//import com.bben.infusion.transmission.CallWebSocket;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.Trigger;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.Session;
//import java.io.IOException;
//import java.util.Date;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * 输液看板病人呼叫接口
// * websocket推送
// */
//@Component
//@EnableScheduling
//public class PatientCallTask implements SchedulingConfigurer {
//    Logger log = LoggerFactory.getLogger(PatientCallTask.class);
//
//    @Autowired
//    private TPatientCallService tPatientCallService;
//    @Autowired
//    private TWardService tWardService;
//    @Autowired
//    private CallWebSocket webSocket;
//
//    @Value("${infusion-call.cron}")
//    private String cron;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        Runnable task = () -> {
//            //任务逻辑代码部分.
//            log.info("PatientCallTask task is running ... " + new Date());
//            try {
//                autoReadInfusionCall();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Trigger trigger = triggerContext -> {
//            log.info("InfusionTask cron change to:" + cron);
//            //任务触发，可修改任务的执行周期.
//            return new CronTrigger(cron).nextExecutionTime(triggerContext);
//        };
//
//        taskRegistrar.addTriggerTask(task,trigger);
//    }
//
//    private void autoReadInfusionCall() throws IOException {
//        ConcurrentHashMap<String, CopyOnWriteArraySet<Session>> sessionHashMap = webSocket.getSessionHashMap();
//        if (A.isEmpty(sessionHashMap)) {
//            log.info("PatientCallTask autoReadInfusionCall sessionHashMap is null");
//            return;
//        }
//
//        for (String twid:sessionHashMap.keySet()){
//            log.info("key,sessions -> {} {} ",twid,sessionHashMap.get(twid));
//            //查找病区的信息
//            TWard tWard = tWardService.selectByPrimaryKey(Integer.parseInt(twid));
//
//            if (U.isBlank(tWard)) {
//                webSocket.BroadCastInfoSet(twid,sessionHashMap.get(twid), JSON.toJSONString(Result.success("无病区数据")));
//                return;
//            }
//
//            //查找病人呼叫信息
//            TPatientCall tPatientCall = new TPatientCall();
//            tPatientCall.setWardId(twid);
//            tPatientCall.setCreateTime(new Date());
//            JSONArray jsonArray = tPatientCallService.selectByCondition(tPatientCall);
//
//            if (A.isEmpty(jsonArray)){
//                webSocket.BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("无病人呼叫数据")));
//                return;
//            }
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("wId",twid);
//            jsonObject.put("name",tWard.getName());
//            jsonObject.put("callInfo",jsonArray);
//            webSocket.BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("获取病区病人呼叫信息成功",jsonObject)));
//            log.info("PatientCallTask autoReadInfusionCall() end ...");
//        }
//    }
//
//}
