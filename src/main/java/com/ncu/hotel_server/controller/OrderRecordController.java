package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.OrderRecordService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/orderRecord")
public class OrderRecordController {
    @Autowired
    OrderRecordService orderRecordService;
    @ApiOperation("获取时间段营业额")
    @GetMapping("/getSalesByTime")
    public List<Map<String,Object>> getSalesByTime(@Param("start") String start, @Param("end") String end){
        return orderRecordService.getSalesByTime(start, end);
    }
    @ApiOperation("获取订单量通过时间")
    @GetMapping("/getRecordTotal")
    public List<Map<String,Object>> getRecordTotal(@Param("start") String start, @Param("end") String end){
        return orderRecordService.getRecordTotal(start, end);
    }
    @ApiOperation("获取订单基础信息通过时间")
    @GetMapping("/getOrderByTime")
    public List<Map<String,Object>> getOrderByTime(@Param("start") String start, @Param("end") String end){
        return orderRecordService.getOrderByTime(start, end);
    }
}
