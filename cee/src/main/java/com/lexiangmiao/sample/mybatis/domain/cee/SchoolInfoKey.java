package com.lexiangmiao.sample.mybatis.domain.cee;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table school_info
 */
public class SchoolInfoKey extends BaseDomain {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_info.school_info_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    private Long schoolInfoId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_info.school_info_id
     *
     * @return the value of school_info.school_info_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    public Long getSchoolInfoId() {
        return schoolInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_info.school_info_id
     *
     * @param schoolInfoId the value for school_info.school_info_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    public void setSchoolInfoId(Long schoolInfoId) {
        this.schoolInfoId = schoolInfoId;
    }
}