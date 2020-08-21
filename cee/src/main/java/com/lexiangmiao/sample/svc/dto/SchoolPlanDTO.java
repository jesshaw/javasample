package com.lexiangmiao.sample.svc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mzxiao on 2020/7/30 11:21
 */
public class SchoolPlanDTO {
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }

    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }

    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLocalBatchName() {
        return localBatchName;
    }

    public void setLocalBatchName(String localBatchName) {
        this.localBatchName = localBatchName;
    }

    public String getZslxName() {
        return zslxName;
    }

    public void setZslxName(String zslxName) {
        this.zslxName = zslxName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("school_id")
    String schoolId;
    @JsonProperty("special_id")
    String specialId;
    @JsonProperty("num")
    Integer num;
    @JsonProperty("type")
    String type;
    @JsonProperty("province")
    String province;
    @JsonProperty("batch")
    String batch;
    @JsonProperty("id")
    String id;
    @JsonProperty("spid")
    String spid;
    @JsonProperty("zslx")
    String zslx;
    @JsonProperty("info")
    String info;
    @JsonProperty("level1_name")
    String level1Name;
    @JsonProperty("level2_name")
    String level2Name;
    @JsonProperty("level3_name")
    String level3Name;
    @JsonProperty("level1")
    String level1;
    @JsonProperty("level2")
    String level2;
    @JsonProperty("spname")
    String spname;
    @JsonProperty("level3")
    String level3;
    @JsonProperty("local_batch_name")
    String localBatchName;
    @JsonProperty("zslx_name")
    String zslxName;
    Integer year;
}
