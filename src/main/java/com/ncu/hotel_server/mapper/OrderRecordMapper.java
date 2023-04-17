package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.OrderRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import javafx.beans.binding.ObjectExpression;
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
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {
    /**
     * 总收入通过订单状态等于完成的时候来确定
     * @param start
     * @param end
     * @return
     */
    @Select("select  DATE_FORMAT(complete_time,'%Y-%m-%d') time,final_payment_amount\n" +
            "from order_record\n" +
            "where   order_status ='3' and complete_time between #{start} and #{end}")
    List<Map<String,Object>> getSalesByTime(@Param("start") String start, @Param("end") String end);

    /**
     * 订单量通过创建时间来确定，取消也是，视为订单量
     * @param start
     * @param end
     * @return
     */
    @Select("select order_id,DATE_FORMAT(create_time,'%Y-%m-%d') time,order_status\n" +
            "from order_record\n" +
            "where create_time between #{start} and #{end}")
    List<Map<String,Object>> getRecordTotal(@Param("start") String start,@Param("end") String end);

    /**
     * 根据时间来获取订单基础信息
     * @param start
     * @param end
     * @return
     */
    @Select("select order_id,c.customer_name,c.customer_phone,r.room_number,order_status,check_in_time,check_out_time,order_record.create_time,order_record.complete_time,final_payment_amount\n" +
            "from order_record left join room r on order_record.room_id = r.room_id left join customer c on order_record.customer_id = c.customer_id\n" +
            "where order_record.create_time between #{start} and #{end}")
    List<Map<String, Object>> getOrderByTime(@Param("start") String start,@Param("end") String end);

    /**
     * 擦汗如预定记录
     * @param customer_id
     * @param room_id
     * @param room_type
     * @param order_status
     * @param check_in_time
     * @param check_out_time
     * @return
     */
    @Insert("insert into order_record(customer_id, room_id, room_type,order_status,check_in_time, check_out_time) values(#{customer_id},#{room_id},#{room_type},#{order_status},#{check_in_time},#{check_out_time})")
    Integer insertReservationRecord(@Param("customer_id") Long customer_id, @Param("room_id") String room_id, @Param("room_type") String room_type,
                                    @Param("order_status") String order_status, @Param("check_in_time") String check_in_time, @Param("check_out_time") String check_out_time);

    /**
     * 添加记录同时获取记录id
     * @param orderRecord
     * @return
     */
    @Insert("insert into order_record(customer_id, room_id, room_type,order_status,check_in_time, check_out_time) values(#{customerId},#{roomId},#{roomType},#{orderStatus},#{checkInTime},#{checkOutTime})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId",keyColumn="order_id")
    Integer insertRecord(OrderRecord orderRecord);

    /**
     * 更新订单状态
     * @param status
     * @param id
     * @return
     */
    @Update("update order_record set order_status=#{status} where order_id=#{id}")
    Integer updateStatus(@Param("status") String status,@Param("id") Integer id);
    @Update("update order_record set order_status=#{status},complete_time=#{time} where order_id=#{id}")
    Integer cancelOrder(@Param("status") String status,@Param("id") Integer id,@Param("time") String time);
}
