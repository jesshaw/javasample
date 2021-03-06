package com.lexiangmiao.sample.mybatis.repository.cee;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialty;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialtyExample;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolSpecialtyKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolSpecialtyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    long countByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int deleteByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int deleteByPrimaryKey(SchoolSpecialtyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int insert(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int insertSelective(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    List<SchoolSpecialty> selectByExample(SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    SchoolSpecialty selectByPrimaryKey(SchoolSpecialtyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int updateByExampleSelective(@Param("record") SchoolSpecialty record, @Param("example") SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int updateByExample(@Param("record") SchoolSpecialty record, @Param("example") SchoolSpecialtyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int updateByPrimaryKeySelective(SchoolSpecialty record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_specialty
     *
     * @mbg.generated Fri Aug 21 09:11:04 CST 2020
     */
    int updateByPrimaryKey(SchoolSpecialty record);
}