package com.lexiangmiao.sample.mybatis.repository.cee;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialty;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialtyExample;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialtyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolSpecialtyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    long countByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int deleteByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int deleteByPrimaryKey(SchoolSpecialtyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int insert(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int insertSelective(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    List<SchoolSpecialty> selectByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    SchoolSpecialty selectByPrimaryKey(SchoolSpecialtyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") SchoolSpecialty record, @Param("example") SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int updateByExample(@Param("record") SchoolSpecialty record, @Param("example") SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int updateByPrimaryKeySelective(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Thu Jul 30 10:42:19 CST 2020
     */
    int updateByPrimaryKey(SchoolSpecialty record);
}