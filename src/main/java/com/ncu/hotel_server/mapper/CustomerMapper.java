package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xph
 * @since 2023-03-30
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
