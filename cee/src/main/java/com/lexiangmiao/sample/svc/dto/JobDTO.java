package com.lexiangmiao.sample.svc.dto;

import java.util.Date;

/**
 * Created by mzxiao on 2020/7/31 17:18
 */
public class JobDTO {
    private String id;
    private Date createTime; //Long
    private String submitterName;
    private JobDefinitionDTO jobDef;  //Another class

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public JobDefinitionDTO getJobDef() {
        return jobDef;
    }

    public void setJobDef(JobDefinitionDTO jobDef) {
        this.jobDef = jobDef;
    }
}
