package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("顾客接口")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @ApiOperation("获取所有用户")
    @GetMapping("getAllUser")
    public List<Map<String,Object>> getAllUser(){
        return customerService.getAllUser();
    }
    @ApiOperation("根据时间获取入住人")
    @GetMapping("/getOccupantByTime")
    public List<Map<String,Object>> getOccupantByTime(String start,String end){
        return customerService.getOccupantByTime(start,end);
    }
    @ApiOperation("删除入住人记录")
    @GetMapping("/deleteOccupantById")
    public Integer deleteOccupantById(Integer id){
        return customerService.deleteOccupantById(id);
    }

    @ApiOperation("删除用户")
    @GetMapping("/deleteCustomerById")
    public Integer deleteCustomerById(Integer id){
        return customerService.deleteCustomerById(id);
    }
    @ApiOperation("增加用户")
    @GetMapping("/insertCustomer")
    public Integer insertCustomer(String customer_phone,String customer_name){
        return customerService.insertCustomer(customer_phone,customer_name);
    }
    @ApiOperation("修改用户")
    @GetMapping("/updateCustomer")
    public Integer updateCustomer(String customer_phone,String customer_name,Integer id){
        return customerService.updateCustomer(customer_phone,customer_name ,id);
    }

}
