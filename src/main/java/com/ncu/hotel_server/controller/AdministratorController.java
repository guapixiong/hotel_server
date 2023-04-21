package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.AdministratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Api("管理员")
@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @ApiOperation("登录验证")
    @PostMapping("/signIn")
    public Boolean signIn(@RequestBody Map<String,Object> params){
        return administratorService.signIn(params.get("username").toString(),params.get("password").toString());
    }


}
