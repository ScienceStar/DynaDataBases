/*
package com.manager;

import com.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

*/
/**
 * @ClassName QuartzManager
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/10
 * @Version V1.0
 **//*

public class QuartzManager {
    private SchedulerFactory sf= new StdSchedulerFactory();
    */
/**
     * @description 基于简单触发器 实现基本定时功能
     * @date 2018/8/19 0:39
     * @param jobName 任务名
     * @param jobGroupName  任务组名
     * @param triggerName  触发器名
     * @param triggerGroupName  触发器组名
     * @param job 任务类
     * @param time 间隔多久执行一次
     * @param startTime 起始时间
     * @param endTime 结束时间
     * @return void
     *//*

    public void addSimpleJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Job job, long time, Date startTime, Date endTime) throws SchedulerException {
        int i =0;
        Scheduler schd=sf.getScheduler();
        //实例化jobdetail
//        JobDetail jobDetail=new JobDetail(jobName,jobGroupName,job.getClass());
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity(jobName,jobGroupName).build();
        //实例化触发器
//        SimpleTrigger trigger=new SimpleTrigger(triggerName,triggerGroupName,jobName,jobGroupName,startTime,endTime, SimpleTrigger.REPEAT_INDEFINITELY,time*1000L);
        Trigger trigger= newTrigger().withIdentity(triggerName,triggerGroupName).forJob(jobName,jobGroupName).startAt(startTime).endAt(endTime).build();
        System.out.println("simpleTrigger 触发器执行："+(i++)+"次!");
        //两者组成一个计划任务注册到scheduler
        schd.scheduleJob(jobDetail,trigger);
        if(!schd.isShutdown()){
            schd.start();//启动调度器
        }
    }
    */
/**
     * @description 基于cron表达式 实现任务调度
     * @date 2018/8/19 11:01
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param job
     * @param time
     * @return void
     *//*

    public void addCronJob(String jobName,String jobGroupName,String triggerName,String triggerGroupName,Job job,String time) throws SchedulerException {
        Scheduler sched=sf.getScheduler();
        */
/*//*
/实例化jobdetail
        JobDetail jobDetail=new JobDetail(jobName,jobGroupName,job.getClass());
        //实例化触发器
        CronTrigger trigger=new CronTrigger(triggerName,triggerGroupName);*//*


        //        JobDetail jobDetail=new JobDetail(jobName,jobGroupName,job.getClass());
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity(jobName,jobGroupName).build();
        //实例化触发器
//        SimpleTrigger trigger=new SimpleTrigger(triggerName,triggerGroupName,jobName,jobGroupName,startTime,endTime, SimpleTrigger.REPEAT_INDEFINITELY,time*1000L);
        CronTrigger trigger= (CronTrigger) newTrigger().withIdentity(triggerName,triggerGroupName).forJob(jobName,jobGroupName).build();
        trigger.getTriggerBuilder().withSchedule(cronSchedule(time));//触发器时间设定
        sched.scheduleJob(jobDetail,trigger);
        if(!sched.isShutdown()){
            sched.start();//启动调度器
        }

    }


}
*/
