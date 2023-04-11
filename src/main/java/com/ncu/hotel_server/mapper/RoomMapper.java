package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Mapper;
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
    @Select("select room_id, room_number, room_url, room_type, room_price, hour_price, room_introduction, room_state\n" +
            "from room")
    List<Map<String, Object>> getAllRoomDetail();
}
