package com.lexiangmiao.sample.transaction;

import org.apache.ibatis.annotations.*;

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
}
