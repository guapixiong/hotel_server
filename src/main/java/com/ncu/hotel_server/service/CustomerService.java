package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xph
 * @since 2023-03-30
 */
public interface CustomerService extends IService<Customer> {
    Integer getCustomerTotalByTime(String start,String end);
}
