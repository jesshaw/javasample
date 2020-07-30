package com.lexiangmiao.sample.mybatis.domain.cee;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table school_plan
 */
public class SchoolPlan extends SchoolPlanKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.school_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String schoolId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.special_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String specialId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.num
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.type
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.province
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.batch
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String batch;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.spid
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String spid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.zslx
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String zslx;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.info
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String info;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level1_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level1Name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level2_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level2Name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level3_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level3Name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level1
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level2
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.spname
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String spname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.level3
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String level3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.local_batch_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String localBatchName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.zslx_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private String zslxName;

    /**
     * Database Column Remarks:
     *   年份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_plan.year
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    private Integer year;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.school_id
     *
     * @return the value of school_plan.school_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.school_id
     *
     * @param schoolId the value for school_plan.school_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.special_id
     *
     * @return the value of school_plan.special_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getSpecialId() {
        return specialId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.special_id
     *
     * @param specialId the value for school_plan.special_id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setSpecialId(String specialId) {
        this.specialId = specialId == null ? null : specialId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.num
     *
     * @return the value of school_plan.num
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.num
     *
     * @param num the value for school_plan.num
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.type
     *
     * @return the value of school_plan.type
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.type
     *
     * @param type the value for school_plan.type
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.province
     *
     * @return the value of school_plan.province
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.province
     *
     * @param province the value for school_plan.province
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.batch
     *
     * @return the value of school_plan.batch
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getBatch() {
        return batch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.batch
     *
     * @param batch the value for school_plan.batch
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.id
     *
     * @return the value of school_plan.id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.id
     *
     * @param id the value for school_plan.id
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.spid
     *
     * @return the value of school_plan.spid
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getSpid() {
        return spid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.spid
     *
     * @param spid the value for school_plan.spid
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setSpid(String spid) {
        this.spid = spid == null ? null : spid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.zslx
     *
     * @return the value of school_plan.zslx
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getZslx() {
        return zslx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.zslx
     *
     * @param zslx the value for school_plan.zslx
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setZslx(String zslx) {
        this.zslx = zslx == null ? null : zslx.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.info
     *
     * @return the value of school_plan.info
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.info
     *
     * @param info the value for school_plan.info
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level1_name
     *
     * @return the value of school_plan.level1_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel1Name() {
        return level1Name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level1_name
     *
     * @param level1Name the value for school_plan.level1_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name == null ? null : level1Name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level2_name
     *
     * @return the value of school_plan.level2_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel2Name() {
        return level2Name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level2_name
     *
     * @param level2Name the value for school_plan.level2_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name == null ? null : level2Name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level3_name
     *
     * @return the value of school_plan.level3_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel3Name() {
        return level3Name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level3_name
     *
     * @param level3Name the value for school_plan.level3_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name == null ? null : level3Name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level1
     *
     * @return the value of school_plan.level1
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel1() {
        return level1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level1
     *
     * @param level1 the value for school_plan.level1
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel1(String level1) {
        this.level1 = level1 == null ? null : level1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level2
     *
     * @return the value of school_plan.level2
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel2() {
        return level2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level2
     *
     * @param level2 the value for school_plan.level2
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel2(String level2) {
        this.level2 = level2 == null ? null : level2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.spname
     *
     * @return the value of school_plan.spname
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getSpname() {
        return spname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.spname
     *
     * @param spname the value for school_plan.spname
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setSpname(String spname) {
        this.spname = spname == null ? null : spname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.level3
     *
     * @return the value of school_plan.level3
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLevel3() {
        return level3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.level3
     *
     * @param level3 the value for school_plan.level3
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLevel3(String level3) {
        this.level3 = level3 == null ? null : level3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.local_batch_name
     *
     * @return the value of school_plan.local_batch_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getLocalBatchName() {
        return localBatchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.local_batch_name
     *
     * @param localBatchName the value for school_plan.local_batch_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setLocalBatchName(String localBatchName) {
        this.localBatchName = localBatchName == null ? null : localBatchName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.zslx_name
     *
     * @return the value of school_plan.zslx_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public String getZslxName() {
        return zslxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.zslx_name
     *
     * @param zslxName the value for school_plan.zslx_name
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setZslxName(String zslxName) {
        this.zslxName = zslxName == null ? null : zslxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_plan.year
     *
     * @return the value of school_plan.year
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_plan.year
     *
     * @param year the value for school_plan.year
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    public void setYear(Integer year) {
        this.year = year;
    }
}