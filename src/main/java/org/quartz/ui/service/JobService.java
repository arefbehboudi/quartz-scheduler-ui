package org.quartz.ui.service;

import org.quartz.ui.model.QuartzJobDetail;

import java.util.List;

public interface JobService {

    List<QuartzJobDetail> getAllJobs();

    boolean isJobRunning(String jobName);
}
