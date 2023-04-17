package com.ncu.hotel_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ncu.hotel_server.entity.Customer;
import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Override
    public List<Map<String, Object>> getAllUser() {
        return baseMapper.getAllUser();
    }
}
