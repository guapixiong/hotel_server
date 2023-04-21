package com.ncu.hotel_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ncu.hotel_server.entity.Customer;
import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.mapper.OccupantRecordMapper;
import com.ncu.hotel_server.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    OccupantRecordMapper occupantRecordMapper;
    @Override
    public List<Map<String, Object>> getAllUser() {
        return baseMapper.getAllUser();
    }

    @Override
    public List<Map<String, Object>> getOccupantByTime(String start, String end) {
        return occupantRecordMapper.getOccupantByTime(start,end);
    }

    @Override
    public Integer deleteOccupantById(Integer id) {
        return occupantRecordMapper.deleteOccupantById(id);
    }

    @Override
    public Integer deleteCustomerById(Integer id) {
        return baseMapper.deleteCustomerById(id);
    }

    @Override
    public Integer updateCustomer(String customer_phone, String customer_name, Integer id) {
        return baseMapper.updateCustomer(customer_phone,customer_name,id);
    }

    @Override
    public Integer insertCustomer(String customer_phone, String customer_name) {
        return baseMapper.insertOneByPhone(customer_name, customer_phone);
    }
}
