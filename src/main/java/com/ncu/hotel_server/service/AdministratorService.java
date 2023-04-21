package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.Administrator;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
public interface AdministratorService extends IService<Administrator> {
    Boolean signIn(String name,String password);

}
