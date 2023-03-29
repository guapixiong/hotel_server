package com.ncu.hotel_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xph
 * @since 2023-03-29
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping("/me")
    public String getMe(){
        return "566666";
    }

}
