package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Room;
import com.ncu.hotel_server.mapper.RoomMapper;
import com.ncu.hotel_server.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
