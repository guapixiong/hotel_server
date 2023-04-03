package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Deposit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
