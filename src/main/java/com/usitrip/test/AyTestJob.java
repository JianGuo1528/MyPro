package com.usitrip.test;

import org.quartz.*;

import java.util.List;
import java.util.logging.Logger;

public class AyTestJob implements Job {
    private static final Logger log = Logger.getLogger(AyTestJob.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            List<JobExecutionContext> jobs = jobExecutionContext.getScheduler().getCurrentlyExecutingJobs();
            if (jobs != null && !jobs.isEmpty()) {
                for (JobExecutionContext job : jobs) {
                    if (job.getTrigger().equals(jobExecutionContext.getTrigger()) && !job.getJobInstance().equals(this)) {
                        log.info("There's another instance running, : " + this);
                        return;
                    }
                }
            }
            SchedulerContext schedulerContext = jobExecutionContext.getScheduler().getContext();
            System.out.println("AyTestJob.execute!!!");
            System.out.println(schedulerContext.getLong("time"));
            System.out.println("current time: " + System.currentTimeMillis());

        } catch (SchedulerException e) {
            System.out.println(e.getCause());
        }
    }
}
