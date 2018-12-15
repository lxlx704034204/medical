//package com.bben.infusion.task;
//
//import com.alibaba.fastjson.JSON;
//import com.bben.common.entity.vo.Result;
//import com.bben.common.util.A;
//import com.bben.common.util.U;
//import com.bben.infusion.model.infusion.TPatient;
//import com.bben.infusion.model.infusion.TWard;
//import com.bben.infusion.service.TPatientService;
//import com.bben.infusion.service.TWardService;
//import com.bben.infusion.transmission.InfusionWebSocket;
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
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@Component
//@EnableScheduling
//public class InfusionTask implements SchedulingConfigurer {
//    Logger log = LoggerFactory.getLogger(InfusionTask.class);
//
//    @Autowired
//    private TPatientService tPatientService;
//    @Autowired
//    private TWardService tWardService;
//    @Autowired
//    private InfusionWebSocket webSocket;
//
//    @Value("${infusion-board.cron}")
//    private String cron;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        Runnable task = () -> {
//            //任务逻辑代码部分.
//            log.info("InfusionTask task is running ... " + new Date());
//            try {
//                autoReadInfusion();
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
//    private void autoReadInfusion() throws IOException {
//        ConcurrentHashMap<String, CopyOnWriteArraySet<Session>> sessionHashMap = webSocket.getSessionHashMap();
//        if (A.isEmpty(sessionHashMap)) {
//            log.info("InfusionTask autoReadInfusion sessionHashMap is null");
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
//            //查找病区正在输液的病人信息
//            TPatient tPatient = new TPatient();
//            tPatient.setWardId(String.valueOf(twid));
////            List<TPatient> listTPatient = tPatientService.findRunPatientByCondition(tPatient);
////            if (A.isEmpty(listTPatient)){
////                webSocket.BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("无病区输液看板数据")));
////                return;
////            }
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("wId",twid);
//            jsonObject.put("name",tWard.getName());
//            jsonObject.put("currentTime", System.currentTimeMillis());
//
//            JSONArray jsonArray = tPatientService.findPatientInfusionByCondition(true,tPatient);
//            jsonObject.put("info",jsonArray);
//            webSocket.BroadCastInfoSet(twid,sessionHashMap.get(twid),JSON.toJSONString(Result.success("获取病区输液看板信息成功",jsonObject)));
//            log.info("InfusionTask autoReadInfusion() end ...");
//        }
//    }
//
//}
