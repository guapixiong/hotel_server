package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.service.OrderRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api("订单模块")
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
    @ApiOperation("快速添加入住信息")
    @PostMapping("/addFastCheckIn")
    public Integer addFastCheckIn(@RequestBody Map<String,Object> params) throws Exception {
     return orderRecordService.addFastCheckIn(params);
    }
    @ApiOperation("预定入住信息添加")
    @PostMapping("/addBookAStayInfo")
    public Integer addBookAStayInfo(@RequestBody Map<String,Object> params) throws Exception {
        return orderRecordService.addBookAStayInfo(params);
    }
    @ApiOperation("取消预定订单")
    @GetMapping("/cancelOrderById")
    public Integer cancelOrderById(Integer id){
        return orderRecordService.cancelOrderById(id);
    }
    @ApiOperation("通过订单id来获取订单有关用户房间信息")
    @GetMapping("/getOrderDetailById")
    public Map<String ,Object> getOrderDetailById(String orderId){
        return orderRecordService.getOrderDetailById(orderId);
    }
    @ApiOperation("通过订单id来获取相关商品信息")
    @GetMapping("/getCommodityRecordByOrderId")
    public List<Map<String,Object>> getCommodityRecordByOrderId(String orderId){
        return orderRecordService.getCommodityRecordByOrderId(orderId);
    }
    @ApiOperation("结账退房操作")
    @PostMapping("/checkoutByOrderId")
    public Integer checkoutByOrderId(@RequestBody Map<String,Object> params) throws Exception {
        return orderRecordService.checkoutByOrderId(params);
    }
    @ApiOperation("退款操作")
    @GetMapping("/reimburseOrder")
    public Integer reimburseOrder(String orderId,Double actualCharge) throws Exception {
        return orderRecordService.reimburseOrder(orderId,actualCharge);
    }
    @ApiOperation("根据订单来获取入住人信息")
    @GetMapping("/getCustomerByRecordId")
    public List<Map<String,Object>> getCustomerByRecordId(String orderId){
        return orderRecordService.getCustomerByRecordId(Integer.parseInt(orderId));
    }

    @ApiOperation("根据订单id来更新个别信息")
    @GetMapping("/updateRecordById")
    public Integer updateRecordById(String id,Double payment){
        return orderRecordService.updateRecordById(Integer.parseInt(id),payment);
    }

    @ApiOperation("根据订单id删除订单")
    @GetMapping("/deleteRecordById")
    public Integer deleteRecordById(String id){
        return orderRecordService.deleteRecordById(Integer.parseInt(id));
    }
}
