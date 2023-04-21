package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Administrator;
import com.ncu.hotel_server.mapper.AdministratorMapper;
import com.ncu.hotel_server.service.AdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {
    @Override
    public Boolean signIn(String name, String password) {
        List<Map<String,Object>> result=baseMapper.signIn(name,password);
        if(result.size()==1)
            return true;
        else
            return false;
    }
}
