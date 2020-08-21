package sample.cee;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mzxiao on 2020/7/27 9:56
 */
public class ScoresPerYear {
    private String cityName;
    private String levelName;
    @JsonProperty("school_id")
    private String schoolId;
    @JsonProperty("school_name")
    private String schoolName;
    @JsonProperty("province_id")
    private String provinceId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("batch")
    private String batch;
    @JsonProperty("zslx")
    private String zslx;
    @JsonProperty("xclevel")
    private String xclevel;
    @JsonProperty("max")
    private String max;
    @JsonProperty("min_section")
    private String minSection;
    @JsonProperty("min")
    private String min;
    @JsonProperty("average")
    private String average;
    @JsonProperty("filing")
    private String filing;
    @JsonProperty("type_control")
    private String typeControl;
    @JsonProperty("batch_control")
    private String batchControl;
    @JsonProperty("local_batch_name")
    private String localBatchName;
    @JsonProperty("zslx_name")
    private String zslxName;
    @JsonProperty("xclevel_name")
    private String xclevelName;
    @JsonProperty("proscore")
    private String proscore;
    @JsonProperty("year")
    private String year;

    @JsonProperty("min_score_2019_s")
    private String minScore2019s;
    @JsonProperty("min_score_2019")
    private String minScore2019;
    @JsonProperty("min_score_2018s")
    private String minScore2018s;
    @JsonProperty("min_score_2018")
    private String minScore2018;
    @JsonProperty("min_score_2017s")
    private String minScore2017s;
    @JsonProperty("min_score_2017")
    private String minScore2017;
    @JsonProperty("min_score_2016s")
    private String minScore2016s;
    @JsonProperty("min_score_2016")
    private String minScore2016;
    @JsonProperty("min_score_2015s")
    private String minScore2015s;
    @JsonProperty("min_score_2015")
    private String minScore2015;
    @JsonProperty("min_score_2014s")
    private String minScore2014s;
    @JsonProperty("min_score_2014")
    private String minScore2014;

    public String getMinScore2019s() {
        return minScore2019s;
    }

    public void setMinScore2019s(String minScore2019s) {
        this.minScore2019s = minScore2019s;
    }

    public String getMinScore2018s() {
        return minScore2018s;
    }

    public void setMinScore2018s(String minScore2018s) {
        this.minScore2018s = minScore2018s;
    }

    public String getMinScore2017s() {
        return minScore2017s;
    }

    public void setMinScore2017s(String minScore2017s) {
        this.minScore2017s = minScore2017s;
    }

    public String getMinScore2016s() {
        return minScore2016s;
    }

    public void setMinScore2016s(String minScore2016s) {
        this.minScore2016s = minScore2016s;
    }

    public String getMinScore2015s() {
        return minScore2015s;
    }

    public void setMinScore2015s(String minScore2015s) {
        this.minScore2015s = minScore2015s;
    }

    public String getMinScore2014s() {
        return minScore2014s;
    }

    public void setMinScore2014s(String minScore2014s) {
        this.minScore2014s = minScore2014s;
    }

    private String provinceName;

    public ScoresPerYear() {
        String defaultVal = "0";
        this.minScore2019 = defaultVal;

        this.minScore2018 = defaultVal;

        this.minScore2017 = defaultVal;

        this.minScore2016 = defaultVal;

        this.minScore2015 = defaultVal;

        this.minScore2014 = defaultVal;
        this.minScore2019s = defaultVal;

        this.minScore2018s = defaultVal;

        this.minScore2017s = defaultVal;

        this.minScore2016s = defaultVal;

        this.minScore2015s = defaultVal;

        this.minScore2014s = defaultVal;
    }

    public String getMinScore2019() {
        return minScore2019;
    }

    public void setMinScore2019(String minScore2019) {
        this.minScore2019 = minScore2019;
    }

    public String getMinScore2018() {
        return minScore2018;
    }

    public void setMinScore2018(String minScore2018) {
        this.minScore2018 = minScore2018;
    }

    public String getMinScore2017() {
        return minScore2017;
    }

    public void setMinScore2017(String minScore2017) {
        this.minScore2017 = minScore2017;
    }

    public String getMinScore2016() {
        return minScore2016;
    }

    public void setMinScore2016(String minScore2016) {
        this.minScore2016 = minScore2016;
    }

    public String getMinScore2015() {
        return minScore2015;
    }

    public void setMinScore2015(String minScore2015) {
        this.minScore2015 = minScore2015;
    }

    public String getMinScore2014() {
        return minScore2014;
    }

    public void setMinScore2014(String minScore2014) {
        this.minScore2014 = minScore2014;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getXclevel() {
        return xclevel;
    }

    public void setXclevel(String xclevel) {
        this.xclevel = xclevel;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMinSection() {
        return minSection;
    }

    public void setMinSection(String minSection) {
        this.minSection = minSection;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getFiling() {
        return filing;
    }

    public void setFiling(String filing) {
        this.filing = filing;
    }

    public String getTypeControl() {
        return typeControl;
    }

    public void setTypeControl(String typeControl) {
        this.typeControl = typeControl;
    }

    public String getBatchControl() {
        return batchControl;
    }

    public void setBatchControl(String batchControl) {
        this.batchControl = batchControl;
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

    public String getXclevelName() {
        return xclevelName;
    }

    public void setXclevelName(String xclevelName) {
        this.xclevelName = xclevelName;
    }

    public String getProscore() {
        return proscore;
    }

    public void setProscore(String proscore) {
        this.proscore = proscore;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }
}
