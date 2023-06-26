package com.ncu.hotel_server.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface MiniProgramService {
    List<Map<String,Object>> selectUserByOpenid(String openid);
    Integer insertOneByOpenid( String openid);
    List<Map<String,Object>> selectRecordByCustomerId(String id);
    Integer insertReservation( Map<String, String> params);
    Map<String, Object> getOrderDetailById(Integer id);
}
