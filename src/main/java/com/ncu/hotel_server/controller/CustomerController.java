package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.CustomerService;
import io.swagger.annotations.Api;
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
    @GetMapping("getAllUser")
    public List<Map<String,Object>> getAllUser(){
        return customerService.getAllUser();
    }
}
