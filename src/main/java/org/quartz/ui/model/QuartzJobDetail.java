package org.quartz.ui.model;

import java.util.Date;

public class QuartzJobDetail {
    private String jobName;

    private String jobGroupName;

    private Date nextFireTime;

    private Date preFireTime;

    private Date scheduleTime;
}
