package com.lexiangmiao.sample.mybatis.domain.cee;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table provincial_score
 */
public class ProvincialScore extends ProvincialScoreKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.school_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String schoolId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.school_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String schoolName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.province_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String provinceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.type
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.batch
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String batch;

    /**
     * Database Column Remarks:
     *   招生类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.zslx
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer zslx;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.xclevel
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String xclevel;

    /**
     * Database Column Remarks:
     *   最高分
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.max
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer max;

    /**
     * Database Column Remarks:
     *   最低位次
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.min_section
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer minSection;

    /**
     * Database Column Remarks:
     *   最低分
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.min
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer min;

    /**
     * Database Column Remarks:
     *   平均分
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.average
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer average;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.filing
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String filing;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.type_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String typeControl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.batch_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String batchControl;

    /**
     * Database Column Remarks:
     *   录取批次
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.local_batch_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String localBatchName;

    /**
     * Database Column Remarks:
     *   招生类型名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.zslx_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String zslxName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.xclevel_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String xclevelName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.proscore
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private String proscore;

    /**
     * Database Column Remarks:
     *   年份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.year
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    private Integer year;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.school_id
     *
     * @return the value of provincial_score.school_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.school_id
     *
     * @param schoolId the value for provincial_score.school_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.school_name
     *
     * @return the value of provincial_score.school_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.school_name
     *
     * @param schoolName the value for provincial_score.school_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.province_id
     *
     * @return the value of provincial_score.province_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.province_id
     *
     * @param provinceId the value for provincial_score.province_id
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.type
     *
     * @return the value of provincial_score.type
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.type
     *
     * @param type the value for provincial_score.type
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.batch
     *
     * @return the value of provincial_score.batch
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getBatch() {
        return batch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.batch
     *
     * @param batch the value for provincial_score.batch
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.zslx
     *
     * @return the value of provincial_score.zslx
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getZslx() {
        return zslx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.zslx
     *
     * @param zslx the value for provincial_score.zslx
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setZslx(Integer zslx) {
        this.zslx = zslx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.xclevel
     *
     * @return the value of provincial_score.xclevel
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getXclevel() {
        return xclevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.xclevel
     *
     * @param xclevel the value for provincial_score.xclevel
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setXclevel(String xclevel) {
        this.xclevel = xclevel == null ? null : xclevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.max
     *
     * @return the value of provincial_score.max
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getMax() {
        return max;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.max
     *
     * @param max the value for provincial_score.max
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.min_section
     *
     * @return the value of provincial_score.min_section
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getMinSection() {
        return minSection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.min_section
     *
     * @param minSection the value for provincial_score.min_section
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setMinSection(Integer minSection) {
        this.minSection = minSection;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.min
     *
     * @return the value of provincial_score.min
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getMin() {
        return min;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.min
     *
     * @param min the value for provincial_score.min
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.average
     *
     * @return the value of provincial_score.average
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getAverage() {
        return average;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.average
     *
     * @param average the value for provincial_score.average
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setAverage(Integer average) {
        this.average = average;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.filing
     *
     * @return the value of provincial_score.filing
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getFiling() {
        return filing;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.filing
     *
     * @param filing the value for provincial_score.filing
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setFiling(String filing) {
        this.filing = filing == null ? null : filing.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.type_control
     *
     * @return the value of provincial_score.type_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getTypeControl() {
        return typeControl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.type_control
     *
     * @param typeControl the value for provincial_score.type_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setTypeControl(String typeControl) {
        this.typeControl = typeControl == null ? null : typeControl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.batch_control
     *
     * @return the value of provincial_score.batch_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getBatchControl() {
        return batchControl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.batch_control
     *
     * @param batchControl the value for provincial_score.batch_control
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setBatchControl(String batchControl) {
        this.batchControl = batchControl == null ? null : batchControl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.local_batch_name
     *
     * @return the value of provincial_score.local_batch_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getLocalBatchName() {
        return localBatchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.local_batch_name
     *
     * @param localBatchName the value for provincial_score.local_batch_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setLocalBatchName(String localBatchName) {
        this.localBatchName = localBatchName == null ? null : localBatchName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.zslx_name
     *
     * @return the value of provincial_score.zslx_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getZslxName() {
        return zslxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.zslx_name
     *
     * @param zslxName the value for provincial_score.zslx_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setZslxName(String zslxName) {
        this.zslxName = zslxName == null ? null : zslxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.xclevel_name
     *
     * @return the value of provincial_score.xclevel_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getXclevelName() {
        return xclevelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.xclevel_name
     *
     * @param xclevelName the value for provincial_score.xclevel_name
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setXclevelName(String xclevelName) {
        this.xclevelName = xclevelName == null ? null : xclevelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.proscore
     *
     * @return the value of provincial_score.proscore
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public String getProscore() {
        return proscore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.proscore
     *
     * @param proscore the value for provincial_score.proscore
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setProscore(String proscore) {
        this.proscore = proscore == null ? null : proscore.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.year
     *
     * @return the value of provincial_score.year
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.year
     *
     * @param year the value for provincial_score.year
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    public void setYear(Integer year) {
        this.year = year;
    }
}