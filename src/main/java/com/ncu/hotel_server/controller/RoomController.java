package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.entity.Room;
import com.ncu.hotel_server.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Api("房间接口")
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    @ApiOperation("获取房间总数")
    @GetMapping("/getRoomTotal")
    public Integer getRoomTotal(){
        return roomService.getRoomTotal();
    }

    @ApiOperation("获取所有房间信息")
    @GetMapping("/getAllRoomDetail")
    List<Map<String, Object>> getAllRoomDetail(){
        return roomService.getAllRoomDetail();
    }

    @ApiOperation("添加一个房间记录")
    @PostMapping("/insertRoom")
    public Boolean insertRoom(@RequestBody Room room){
        int result=roomService.insertRoom(room);
        if(result==1)
            return true;
        else
            return false;
    }
    @ApiOperation("获取房间类型")
    @GetMapping("/getTypeInfo")
    public List<Map<String,Object>> getTypeInfo(){
        return roomService.getTypeInfo();
    }
    @ApiOperation("修改一个房间记录")
    @PostMapping("/updateRoom")
    public Integer updateRoom(@RequestBody Room room){
        return roomService.updateRoom(room);
    }
    @ApiOperation("删除一个房间记录")
    @GetMapping("/deleteRoom")
    public Integer deleteRoom(@Param("room_id") Integer room_id){
        return roomService.deleteRoom(room_id);
    }

    @ApiOperation("通过时间获取可利用的房间")
    @GetMapping("/getAvailableRoomByTime")
    public List<Map<String,Object>> getAvailableRoomByTime(String start,String end){
        return roomService.getAvailableRoomByTime(start,end);
    }

}
