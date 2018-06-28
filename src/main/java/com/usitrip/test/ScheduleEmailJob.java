package com.usitrip.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.util.List;
import java.util.logging.Logger;

public class ScheduleEmailJob implements Job {
    private static final Logger log = Logger.getLogger(ScheduleEmailJob.class.getName());
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
            System.out.println("ScheduleEmailJob.execute");
        } catch (SchedulerException e) {
            System.out.println(e.getCause());
        }

    }
}
