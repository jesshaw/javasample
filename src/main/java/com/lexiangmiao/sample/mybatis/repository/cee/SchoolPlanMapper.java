package com.lexiangmiao.sample.mybatis.repository.cee;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlan;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlanExample;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolPlanKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolPlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    long countByExample(SchoolPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int deleteByExample(SchoolPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int deleteByPrimaryKey(SchoolPlanKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int insert(SchoolPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int insertSelective(SchoolPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    List<SchoolPlan> selectByExample(SchoolPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    SchoolPlan selectByPrimaryKey(SchoolPlanKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int updateByExampleSelective(@Param("record") SchoolPlan record, @Param("example") SchoolPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int updateByExample(@Param("record") SchoolPlan record, @Param("example") SchoolPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int updateByPrimaryKeySelective(SchoolPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_plan
     *
     * @mbg.generated Thu Jul 30 11:31:02 CST 2020
     */
    int updateByPrimaryKey(SchoolPlan record);
}