package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.beans.binding.ObjectExpression;
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
public interface RoomMapper extends BaseMapper<Room> {
    @Select("select room_id, room_number, room_url, type_id, room_price, hour_price, room_introduction, room_state,type\n" +
            "from room,room_type where room.type_id=room_type.id")
    List<Map<String, Object>> getAllRoomDetail();

    /**
     * 获取房间类型
     * @return
     */
    @Select("select * from room_type")
    List<Map<String,Object>> getTypeInfo();

    /**
     * 查询可利用的房间
     * @param start
     * @param end
     * @return
     */
    @Select("select *\n" +
            "from room,room_type\n" +
            "where room_id not in (select room_id\n" +
            "from  (select room_id,if(room_type=1,DATE_FORMAT(check_in_time,'%Y-%m-%d 06:00:00'),check_in_time) check_in_time,if(room_type=1,DATE_FORMAT(check_out_time,'%Y-%m-%d 06:00:00'),check_out_time) check_out_time,order_status\n" +
            "from order_record) a\n" +
            "where  order_status not in ('-1','0') and (check_in_time<=#{end} and check_out_time>=#{start}))\n" +
            "and room_state='1' and room.type_id= room_type.id")
    List<Map<String,Object>> getAvailableRoomByTime(@Param("start") String start,@Param("end") String end);
}
