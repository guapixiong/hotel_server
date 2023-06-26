package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.mapper.OrderRecordMapper;
import com.ncu.hotel_server.service.MiniProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : Xiong Penghui
 * @date : 2023-05-31 18:44
 **/
@Service
public class MiniProgramServiceImpl implements MiniProgramService {
    @Autowired
    OrderRecordMapper orderRecordMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public List<Map<String,Object>> selectUserByOpenid(String openid) {
        return customerMapper.selectUserByOpenid(openid);
    }

    @Override
    public Integer insertOneByOpenid(String openid) {
        return customerMapper.insertOneByOpenid(openid);
    }

    @Override
    public List<Map<String, Object>> selectRecordByCustomerId(String id) {
        return orderRecordMapper.selectRecordByCustomerId(id);
    }

    @Override
    public Integer insertReservation(Map<String, String> params) {
        return orderRecordMapper.insertReservationRecord(Long.parseLong(params.get("customer_id")),params.get("room_id"),params.get("room_type"),"1",params.get("check_in_time"),params.get("check_out_time"));
    }

    @Override
    public Map<String, Object> getOrderDetailById(Integer id) {
        return orderRecordMapper.getOrderDetailById(id) ;
    }
}
