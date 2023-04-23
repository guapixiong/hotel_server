package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.Administrator;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
public interface AdministratorService extends IService<Administrator> {
    List<Map<String,Object>> signIn(String name, String password);
    Boolean updatePassword(Map<String,Object> params);
    Boolean signUp( Map<String,Object> params);

}
