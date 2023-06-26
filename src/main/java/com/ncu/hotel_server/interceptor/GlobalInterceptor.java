package com.ncu.hotel_server.interceptor;

import com.ncu.hotel_server.util.JWTTokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author : Xiong Penghui
 * @date : 2023-04-18 16:27
 **/

public class GlobalInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
 //       System.out.println("到这啦");
//        System.out.println(request.getHeader("Authentication"));

        //return true;  //测试环境,小程序没有使用token，可以自己加，但是我懒得加了，所以小程序需要把这个注释打开。由于开始只做了网页端，没有考虑到小程序。
        if(request.getHeader("Authentication")!=null) {
            if (JWTTokenUtil.verify(request.getHeader("Authentication"))) {
                return true;
            } else {
                response.setStatus(401);//token过期
                return false;
            }
        }
        else{
            response.setStatus(401);//没有token
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
