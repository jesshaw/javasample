package com.lexiangmiao.sample.svc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lexiangmiao.sample.util.CustomDoubleDeserializer;
import com.lexiangmiao.sample.util.CustomIntegerDeserializer;

/**
 * Created by mzxiao on 2020/7/30 8:53
 */
public class SchoolSpecialtyDTO {

    @JsonProperty("school_id")

    String schoolId;
    @JsonProperty("special_id")
    String specialId;
    @JsonProperty("type")
    String type;
    @JsonProperty("max")
    @JsonDeserialize(using = CustomDoubleDeserializer.class)
    Double max;
    @JsonProperty("min")
    @JsonDeserialize(using = CustomDoubleDeserializer.class)
    Double min;
    @JsonProperty("average")
    @JsonDeserialize(using = CustomDoubleDeserializer.class)
    Double average;
    @JsonProperty("min_section")
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    Integer minSection;
    @JsonProperty("province")
    String province;
    @JsonProperty("batch")
    String batch;
    @JsonProperty("id")
    Integer id;
    @JsonProperty("spid")
    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    Integer spid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getMinSection() {
        return minSection;
    }

    public void setMinSection(Integer minSection) {
        this.minSection = minSection;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
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
}
