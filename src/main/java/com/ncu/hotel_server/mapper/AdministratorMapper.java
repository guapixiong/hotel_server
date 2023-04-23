package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Administrator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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
    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    @Select("select * from administrator where account_name=#{name} and account_password=#{password}")
    List<Map<String,Object>> signIn(@Param("name") String name,@Param("password") String password);

    /**
     * 查找用户
     * @param id
     * @return
     */
    @Select("select * from administrator where administrator_id =#{id}")
    Map<String,Object> selectAccount(@Param("id") Integer id);

    /**
     * 更新用户
     */
    @Update("update administrator set account_password=#{password} where administrator_id =#{id}")
    Integer updatePassword(@Param("id") Integer id,@Param("password") String password);

    /**
     * 查找用户
     * @param name
     * @return
     */
    @Select("select * from administrator where account_name =#{name}")
    List<Map<String,Object>> selectAccountByName(@Param("name") String  name);

    /**
     * 新增一个用户
     * @param username
     * @param password
     * @return
     */
    @Insert("insert into administrator(account_name,account_password) values(#{name},#{password}) ")
    Integer insertAccount(@Param("name")String username,@Param("password") String password);

}
