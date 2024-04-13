package org.quartz.ui.model;

import java.util.Date;

public class QuartzJobDetail {
    private String jobName;

    private String jobGroupName;

    private Date nextFireTime;

    private Date preFireTime;

    private Date scheduleTime;

    public QuartzJobDetail(String jobName, String jobGroupName, Date nextFireTime, Date preFireTime, Date scheduleTime) {
        this.jobName = jobName;
        this.jobGroupName = jobGroupName;
        this.nextFireTime = nextFireTime;
        this.preFireTime = preFireTime;
        this.scheduleTime = scheduleTime;
    }
}
