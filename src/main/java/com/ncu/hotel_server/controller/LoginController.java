package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.AdministratorService;
import com.ncu.hotel_server.util.JWTTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录
 *
 * @author : Xiong Penghui
 * @date : 2023-04-23 09:03
 **/
@Api("登录接口")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AdministratorService administratorService;

    @ApiOperation("登录验证")
    @PostMapping("/signIn")
    public Map<String, Object> signIn(@RequestBody Map<String,Object> params, HttpServletResponse response){
        String username=params.get("username").toString();
        String password=params.get("password").toString();
        List<Map<String,Object>> result=administratorService.signIn(username,password);
        String token="";
        Map<String,Object> data=new HashMap<>();
        if(result.size()==1){
            token=JWTTokenUtil.token(username,password);
            data.put("token",token);
            data.put("uid",result.get(0).get("administrator_id"));
        }
        else{
            response.setStatus(203);
        }
        return data;
    }

    @ApiOperation("新增用户")
    @PostMapping("/signUp")
    public Boolean signUp(@RequestBody Map<String,Object> params){
        return administratorService.signUp(params);
    }
}
