package com.lexiangmiao.sample.mybatis.repository.cee;

import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfo;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfoExample;
import com.lexiangmiao.sample.mybatis.domain.cee.SchoolInfoKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface SchoolInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    long countByExample(SchoolInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int deleteByExample(SchoolInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int deleteByPrimaryKey(SchoolInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int insert(SchoolInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int insertSelective(SchoolInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    List<SchoolInfo> selectByExample(SchoolInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    SchoolInfo selectByPrimaryKey(SchoolInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int updateByExampleSelective(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int updateByExample(@Param("record") SchoolInfo record, @Param("example") SchoolInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int updateByPrimaryKeySelective(SchoolInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_info
     *
     * @mbg.generated Tue Jul 28 15:10:18 CST 2020
     */
    int updateByPrimaryKey(SchoolInfo record);
}