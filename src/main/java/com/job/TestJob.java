/*
package com.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * @ClassName TestJob
 * @Description: TODO
 * @Author lxc
 * @Date 2020/2/10
 * @Version V1.0
 **//*

public class TestJob implements Job {
    SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int i = 0;
    Date d = new Date();
    String returnstr = DateFormat.format(d);

    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // TODO Auto-generated method stub
        System.out.println(returnstr+"★★★★★★★★★★★"+i++);
    }
}
*/
