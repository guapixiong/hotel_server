package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Administrator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Mapper
public interface AdministratorMapper extends BaseMapper<Administrator> {
    @Select("select * from administrator where account_name=#{name} and account_password=#{password}")
    List<Map<String,Object>> signIn(@Param("name") String name,@Param("password") String password);
}
