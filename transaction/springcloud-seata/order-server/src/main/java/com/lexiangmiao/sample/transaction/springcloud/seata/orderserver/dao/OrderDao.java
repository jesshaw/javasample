package com.lexiangmiao.sample.transaction.springcloud.seata.orderserver.dao;

import com.lexiangmiao.sample.transaction.springcloud.seata.orderserver.entity.Order;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface OrderDao {
    @Insert("INSERT INTO `order` (`id`,`user_id`,`product_id`,`count`,`money`,`status`) " +
            "VALUES(NULL, #{userId}, #{productId}, #{count}, #{money},0) ")
     void create(Order order);

    @Update("UPDATE `order` SET money = money - #{money},status = 1 " +
            "where user_id = #{userId} and status = #{status} ")
     void update(@Param("userId") Long userId, @Param("money") BigDecimal money, @Param("status") Integer status);
}
