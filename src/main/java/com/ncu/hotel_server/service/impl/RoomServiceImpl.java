package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Room;
import com.ncu.hotel_server.mapper.CommodityMapper;
import com.ncu.hotel_server.mapper.CustomerMapper;
import com.ncu.hotel_server.mapper.OrderRecordMapper;
import com.ncu.hotel_server.mapper.RoomMapper;
import com.ncu.hotel_server.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    OrderRecordMapper orderRecordMapper;

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

    @Override
    public List<Map<String, Object>> getAvailableRoomByTime(String start, String end) {
        return baseMapper.getAvailableRoomByTime(start,end);
    }

    @Override
    @Transactional
    public Integer insertReservation(@RequestBody Map<String, String> params) throws Exception {
        List<Map<String,Object>> customer=customerMapper.selectOneByPhone(params.get("customer_phone"));
        Long customer_id;
        if(customer.size()>=1){
            customer_id= (Long) customer.get(0).get("customer_id");
        }
        else {
            int i=customerMapper.insertOneByPhone(params.get("customer_name"),params.get("customer_phone"));
            if(i==1){
                customer=customerMapper.selectOneByPhone(params.get("customer_phone"));
                customer_id= (Long) customer.get(0).get("customer_id");
            }
            else
                throw new Exception("插入顾客数据异常");
        }
        //params.forEach((k,v)-> System.out.println(k+":"+v));
        return orderRecordMapper.insertReservationRecord(customer_id,params.get("room_id"),params.get("room_type"),"1",params.get("check_in_time"),params.get("check_out_time"));
    }
}
