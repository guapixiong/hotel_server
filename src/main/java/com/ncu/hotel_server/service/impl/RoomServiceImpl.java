package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Room;
import com.ncu.hotel_server.mapper.RoomMapper;
import com.ncu.hotel_server.service.RoomService;
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
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Override
    public Integer getRoomTotal() {
        return baseMapper.selectCount(null);
    }

    @Override
    public List<Map<String, Object>> getAllRoomDetail() {
        return baseMapper.getAllRoomDetail();
    }

    @Override
    public Integer insertRoom(Room room) {
        return baseMapper.insert(room);
    }

    @Override
    public Integer updateRoom(Room room) {
        return baseMapper.updateById(room);
    }

    @Override
    public Integer deleteRoom(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getTypeInfo() {
        return baseMapper.getTypeInfo();
    }

}
