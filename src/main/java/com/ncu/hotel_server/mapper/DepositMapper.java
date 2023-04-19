package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Deposit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 押金记录 Mapper 接口
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Mapper
public interface DepositMapper extends BaseMapper<Deposit> {
    /**
     * 插入一条押金记录
     * @param order_id
     * @param deposit
     * @return
     */
    @Insert("INSERT INTO deposit (order_id,  deposit) VALUES (#{order_id},#{deposit})")
    Integer insertDeposit(@Param("order_id") Integer order_id,@Param("deposit")Double deposit);

}
