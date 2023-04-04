package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
