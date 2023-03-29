package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Customer;
import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xph
 * @since 2023-03-29
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
