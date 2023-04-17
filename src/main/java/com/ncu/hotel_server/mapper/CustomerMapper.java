package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.management.ObjectName;
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
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 根据电话号码来查找用户id
     * @param phone
     * @return
     */
    @Select("select customer_id from customer where customer_phone=#{phone}")
    List<Map<String, Object>> selectOneByPhone(@Param("phone") String phone);

    /**
     * 插入姓名和电话
     * @param name
     * @param phone
     * @return
     */
    @Insert("insert into customer (customer_name,customer_phone) values (#{name},#{phone})")
    Integer insertOneByPhone(@Param("name") String name,@Param("phone") String phone);
    /**
     * 查找所有人
     */
    @Select("select * from customer")
    List<Map<String,Object>> getAllUser();
}

