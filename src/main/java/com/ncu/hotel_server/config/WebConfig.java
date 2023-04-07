package com.ncu.hotel_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 图片处理
 *
 * @author : Xiong Penghui
 * @date : 2023-04-07 14:56
 **/
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    // 在D:/res/pic下如果有一张 luffy.jpg.jpg的图片，那么：
//    // 1 访问：http://localhost:8080/img/luffy.jpg 可以访问到
//    // 2 html 中 <img src="http://localhost:8080/img/luffy.jpg">
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("file:D:/hotel/file/");
//    }
//}
