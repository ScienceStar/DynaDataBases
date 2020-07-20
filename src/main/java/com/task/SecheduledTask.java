package com.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SecheduledTask
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/13
 * @Version V1.0
 **/
@Component
public class SecheduledTask {
    protected static Logger log= LoggerFactory.getLogger(SecheduledTask.class);
    //  定时任务时间表达式
    @Scheduled(cron = "0/10 * * * * ?") //每10秒执行一次
    public void scheduledTaskByCorn() {
        //这里是对某个代码段或者某个功能进行定时操作
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        log.info("**********定时任务："+date);
    }
}
