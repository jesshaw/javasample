package com.lexiangmiao.sample.transaction.springcloud.seata.inventoryserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InventoryDao {
    @Update("UPDATE inventory SET used = used + #{count},residue = residue - #{count} WHERE product_id = #{productId} ")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
