package org.quartz.ui.service;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.ui.model.QuartzJobDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JobServiceImp implements JobService {

    private final Scheduler scheduler;

    public JobServiceImp(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public List<QuartzJobDetail> getAllJobs() {
        List<QuartzJobDetail> jobs = new ArrayList<>();
        try {
            List<String> jobGroupNames = scheduler.getJobGroupNames();

            for (String jobGroupName : jobGroupNames) {
                Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName));
                for (JobKey jobKey : jobKeys) {
                    List<Trigger> triggersOfJob = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
                    Trigger first = triggersOfJob.getFirst();
                    
                }
            }
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

        return jobs;
    }

    @Override
    public boolean isJobRunning(String jobName) {

        try {
            List<JobExecutionContext> currentlyExecutingJobs = scheduler.getCurrentlyExecutingJobs();

            for (JobExecutionContext currentlyExecutingJob : currentlyExecutingJobs) {
                if(currentlyExecutingJob.getJobDetail().getKey().getName().equals(jobName))
                    return true;
            }

        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
