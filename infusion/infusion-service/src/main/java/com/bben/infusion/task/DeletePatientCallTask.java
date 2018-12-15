package com.bben.infusion.task;

import com.bben.infusion.util.Constants;
import com.bben.infusion.util.DateUtil;
import com.bben.infusion.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * 定期删除病人呼叫语音
 */
@Component
@EnableScheduling
public class DeletePatientCallTask implements SchedulingConfigurer {
    Logger log = LoggerFactory.getLogger(DeletePatientCallTask.class);

    @Value("${delete-infusion-call-data.cron}")
    private String cron;

    @Value("${delete-infusion-call-data.day-count}")
    private Integer dayCount;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = () -> {
            try {
                log.info("DeletePatientCallTask task is running ... " + new Date());
                autoDeleteInfusion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Trigger trigger = triggerContext -> {
            log.info("DeletePatientCallTask cron change to:" + cron);
            return new CronTrigger(cron).nextExecutionTime(triggerContext);
        };

        taskRegistrar.addTriggerTask(task,trigger);
    }

    private void autoDeleteInfusion(){
        Date date = DateUtil.getBeforeDayTime(new Date(),dayCount);
        String day = DateUtil.SDF_STANDARD_DAY.format(date);
        String path = Constants.voicesPath + File.separator + day;
        FileUtil.delFolder(path);
    }

}
