package com.bben.equipment.task;

import com.bben.equipment.netty.EquipmentClient;
import com.bben.equipment.netty.EquipmentClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 系统自动执行job
 *
 * @author 陈旭东
 * @version v.0.1
 * @date
 */
@Component
@EnableScheduling
public class ReadEquipmentTask implements SchedulingConfigurer {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EquipmentClientHandler clientHandler;

    @Value("${equipment.cron}")
    private String cron;

    @Value("${equipment.gatewayIP}")
    private String gatewayIP;

    @Value("${equipment.gatewayPort}")
    private Integer gatewayPort;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = () -> {
            //任务逻辑代码部分.
            log.info("AutoEquipmentTask task is running ... " + new Date());
            autoReadEquipment();
        };

        Trigger trigger = triggerContext -> {
            log.info("AutoEquipmentTask cron change to:" + cron);

            //任务触发，可修改任务的执行周期.
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        };
        taskRegistrar.addTriggerTask(task, trigger);
    }

    private void autoReadEquipment() {
        try {
            clientHandler.setHost(gatewayIP);
            clientHandler.setPort(gatewayPort);
            new EquipmentClient(clientHandler).connect(gatewayIP, gatewayPort);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        //        多线程启动
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1; i++) {
//                    try {
//                        new EquipmentClient(clientHandler).connect(gatewayIP, gatewayPort);
//                        Thread.sleep(100);  //毫秒
//                    } catch (Exception e) {
//                        log.debug(e.getMessage());
//                    }
//                }
//            }
//        }).start();

    }
}