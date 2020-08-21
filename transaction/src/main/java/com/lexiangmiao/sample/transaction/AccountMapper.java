package com.lexiangmiao.sample.transaction;

import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

/**
 * Created by mzxiao on 2020/8/21 10:34
 */
@Mapper
public interface AccountMapper {
    @Results(id = "accountResult", value = {
            @Result(property = "id", column = "t_account_id", id = true),
            @Result(property = "name", column = "name", id = true),
            @Result(property = "balance", column = "balance", id = true)}
    )
    @Select("SELECT * FROM t_account WHERE t_account_id = #{id}")
    Account findById(@Param("id") long id);


    @Results(id = "accountResult", value = {
            @Result(property = "id", column = "t_account_id", id = true),
            @Result(property = "name", column = "name", id = true),
            @Result(property = "balance", column = "balance", id = true)}
    )
    @Select("SELECT * FROM t_account WHERE name=#{name}")
    Account findByName(@Param("name") String name);

    @Insert("INSERT into t_account (name,balance) values(#{name},#{balance})")
    @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=int.class)
    int insert(Account account);

    @Update("UPDATE t_account set balance=#{balance} WHERE name=#{name})")
    int update(@Param("name") String name, @Param("balance")BigDecimal balance);

}
