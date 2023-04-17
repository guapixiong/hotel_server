package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.OrderRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
public interface OrderRecordService extends IService<OrderRecord> {
    List<Map<String,Object>> getSalesByTime(String start, String end);
    List<Map<String,Object>> getRecordTotal(String start,String end);
    List<Map<String,Object>> getOrderByTime(String start,String end);
    Integer addFastCheckIn(Map<String,Object> params) throws Exception;
    Integer addBookAStayInfo(Map<String,Object> params) throws Exception;
    Integer cancelOrderById(Integer id);
}
