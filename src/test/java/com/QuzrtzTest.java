package com;

import com.job.HelloJob;
import com.job.TestJob;
import com.manager.QZManager;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName QuzrtzTest
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/10
 * @Version V1.0
 **/
public class QuzrtzTest {
    private static String JOB_NAME = "JOB_NAME_";
    private static String JOB_GROUP_NAME = "JOB_GROUP_NAME_";
    private static String TRIGGER_NAME = "TRIGGER_NAME_";
    private static String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_NAME_";

    /*public static void main(String[] args) throws SchedulerException {
        QuartzManager quartzManager = new QuartzManager();
        HelloJob job = new HelloJob();
        String id = "hello";
        //设置当前开始时间、每隔10秒执行一次、一直循环的任务
        quartzManager.addSimpleJob(JOB_NAME + id, JOB_GROUP_NAME + id, TRIGGER_NAME + id, TRIGGER_GROUP_NAME + id, job, 10, new Date(), null);
        String id1 = "world";
        String time = "0 0 12 * * ?";
        //设置每天12点执行
        // quartzManager.addCronJob(JOB_NAME+id1,JOB_GROUP_NAME+id1,TRIGGER_NAME+id1,TRIGGER_GROUP_NAME+id1,job,time);
    }*/

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Thread t = new Thread(()->{
            System.out.println("hello");
        });
        Date d = new Date();
        String returnstr = DateFormat.format(d);

        TestJob job = new TestJob();
        String job_name = "11";
        try {
            System.out.println(returnstr + "【系统启动】");
            QZManager.addJob(job_name, job, "0/2 * * * * ?"); //每2秒钟执行一次

//            Thread.sleep(10000);
//            System.out.println("【修改时间】");
//            QuartzManager.modifyJobTime(job_name,"0/10 * * * * ?");
//            Thread.sleep(20000);
//            System.out.println("【移除定时】");
//            QuartzManager.removeJob(job_name);
//            Thread.sleep(10000);
//
//            System.out.println("/n【添加定时任务】");
//            QuartzManager.addJob(job_name,job,"0/5 * * * * ?");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuartz() {
        // TODO Auto-generated method stub
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date();
        String returnstr = DateFormat.format(d);

        TestJob job = new TestJob();
        String job_name = "11";
        try {
            System.out.println(returnstr + "【系统启动】");
            QZManager.addJob(job_name, job, "0/2 * * * * ?"); //每2秒钟执行一次

//            Thread.sleep(10000);
//            System.out.println("【修改时间】");
//            QuartzManager.modifyJobTime(job_name,"0/10 * * * * ?");
//            Thread.sleep(20000);
//            System.out.println("【移除定时】");
//            QuartzManager.removeJob(job_name);
//            Thread.sleep(10000);
//
//            System.out.println("/n【添加定时任务】");
//            QuartzManager.addJob(job_name,job,"0/5 * * * * ?");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArray(){
        int num1[]={2,3,4};
        int num2[]={2,3,4,8};
        int n=0;
        for(int i=0;i<num1.length;i++){
            for (int j=0;j<num2.length;j++){
                if(num2[j]!=num1[i]){
                    n=num2[j];
                }
            }
        }
        System.out.println(n);
    }
}
