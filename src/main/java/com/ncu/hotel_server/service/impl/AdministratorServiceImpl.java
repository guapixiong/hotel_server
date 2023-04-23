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
    public List<Map<String,Object>> signIn(String name, String password) {
        return baseMapper.signIn(name,password);
    }

    @Override
    public Boolean updatePassword(Map<String, Object> params) {
        Integer id=Integer.parseInt(params.get("id").toString());
        Map<String,Object> map=baseMapper.selectAccount(id);
        String oldPassword=params.get("oldPassword").toString();
        if(map.get("account_password").toString().equals(oldPassword)){
            String newPassword=params.get("newPassword").toString();
            int i= baseMapper.updatePassword(id,newPassword);
            if(i==1){
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public Boolean signUp(Map<String, Object> params) {
        String name=params.get("name").toString();
        String password=params.get("password").toString();
        List<Map<String,Object>> result= baseMapper.selectAccountByName(name);
        if(result.size()==0){
            int i=baseMapper.insertAccount(name,password);
            if(i==1)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
