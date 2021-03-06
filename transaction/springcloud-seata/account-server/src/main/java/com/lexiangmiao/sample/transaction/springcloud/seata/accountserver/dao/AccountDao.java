package com.lexiangmiao.sample.transaction.springcloud.seata.accountserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */

    @Update("UPDATE account SET residue = residue - #{money},used = used + #{money} where user_id = #{userId} ")
    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
