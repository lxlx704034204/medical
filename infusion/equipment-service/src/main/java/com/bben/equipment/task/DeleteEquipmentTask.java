package com.bben.equipment.task;

import com.bben.equipment.mapper.TGatherDataMapper;
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
 * 删除一个月前的采集的数据
 *
 * @author 陈旭东
 * @version v.0.1
 * @date
 */
@Component
@EnableScheduling
public class DeleteEquipmentTask implements SchedulingConfigurer {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TGatherDataMapper tGatherDataMapper;

    @Value("${delete-equipment-data.cron}")
    private String cron;

    @Value("${delete-equipment-data.day-count}")
    private Integer dayCount;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = () -> {
            //任务逻辑代码部分.
            log.info("DeleteEquipmentTask task is running ... " + new Date());
            autoDeleteOldEquipmentData();
        };

        Trigger trigger = triggerContext -> {
            log.info("DeleteEquipmentTask cron change to:" + cron);

            //任务触发，可修改任务的执行周期.
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        };
        taskRegistrar.addTriggerTask(task, trigger);
    }

    private void autoDeleteOldEquipmentData() {
        try {
            Integer i = 0;
            Integer count = 0;
            do {
                i = tGatherDataMapper.deleteByDay(dayCount);
                if (i > 0) {
                    count += i;
                    Thread.sleep(100);
                }
            } while (i > 0);

            log.info("autoDeleteOldEquipmentData finish! delete RowCount=" + count + " ,now:" + new Date());
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }
}