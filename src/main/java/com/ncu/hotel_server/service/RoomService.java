package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.Room;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface RoomService extends IService<Room> {
    Integer getRoomTotal();
    List<Map<String, Object>>  getAllRoomDetail();
}
