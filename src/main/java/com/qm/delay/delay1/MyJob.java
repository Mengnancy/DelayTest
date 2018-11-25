package com.qm.delay.delay1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("扫描数据");
    }

    public static void main(String[] args) throws SchedulerException {
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
