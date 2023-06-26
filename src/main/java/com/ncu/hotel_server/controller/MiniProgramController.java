package com.ncu.hotel_server.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import com.ncu.hotel_server.service.CustomerService;
import com.ncu.hotel_server.service.MiniProgramService;
import io.swagger.annotations.Api;
import javafx.beans.binding.ObjectExpression;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序接口
 *
 * @author : Xiong Penghui
 * @date : 2023-05-31 17:51
 **/
@Api("小程序接口")
@RestController
@RequestMapping("/miniProgram")
public class MiniProgramController {
    @Value("${miniProgram.appid}")
    private String appid;
    @Value("${miniProgram.secret}")
    private String secret;

    @Autowired
    CustomerService customerService;
    @Autowired
    MiniProgramService miniProgramService;
    @Transactional
    @GetMapping("/login")
    public Map<String,Object> login( String code){
        //String appid="wxd1a91a9312c9e7e4";
        System.out.println(appid+",code:"+code);
        Map<String,Object> map=new HashMap<>();
        //初始化微信服务
        WxMaDefaultConfigImpl config=new WxMaDefaultConfigImpl();
        config.setAppid(appid);
        config.setSecret(secret);

        final WxMaService wxMaService= new WxMaServiceImpl();
        wxMaService.setWxMaConfig(config);
        try{
            WxMaJscode2SessionResult session=wxMaService.getUserService().getSessionInfo(code);
            List<Map<String,Object>> result=miniProgramService.selectUserByOpenid(session.getOpenid());
            if(result.size()<1){
                miniProgramService.insertOneByOpenid(session.getOpenid());
                List<Map<String,Object>> result1=miniProgramService.selectUserByOpenid(session.getOpenid());
                map.put("customerId",result1.get(0).get("customer_id"));
            }
            else {
                map.put("customerId",result.get(0).get("customer_id"));
            }
            map.put("sessionKey",session.getSessionKey());
            //map.put("openid",session.getOpenid());
        } catch (WxErrorException e) {
            e.printStackTrace();
            return map;
        }

        return map;
    }
    @GetMapping("/getOrderByUserId")
    public List<Map<String,Object>> getOrderByUserId(String id){
        return miniProgramService.selectRecordByCustomerId(id);
    }
    @PostMapping("/insertOrder")
    public Integer insertOrder(@RequestBody Map<String,String> params){
//        params.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });
        customerService.updateCustomer(params.get("customer_phone"),params.get("customer_name"),Integer.parseInt(params.get("customer_id")));


        return miniProgramService.insertReservation(params);
    }
//    @GetMapping("/getOrderDetailById")
//    public Map<String, Object> getOrderDetailById(Integer id){
//        return miniProgramService.getOrderDetailById(id);
//    }
}
