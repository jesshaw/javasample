package com.lexiangmiao.sample.mybatis.domain.cee;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table provincial_score
 */
public class ProvincialScoreKey extends BaseDomain {
    /**
     * Database Column Remarks:
     *   主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column provincial_score.provincial_score_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    private Long provincialScoreId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column provincial_score.provincial_score_id
     *
     * @return the value of provincial_score.provincial_score_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    public Long getProvincialScoreId() {
        return provincialScoreId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column provincial_score.provincial_score_id
     *
     * @param provincialScoreId the value for provincial_score.provincial_score_id
     *
     * @mbg.generated Thu Jul 30 10:25:48 CST 2020
     */
    public void setProvincialScoreId(Long provincialScoreId) {
        this.provincialScoreId = provincialScoreId;
    }
}