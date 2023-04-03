package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.OccupantRecordService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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
@RestController
@RequestMapping("/occupantRecord")
public class OccupantRecordController {
    @Autowired
    OccupantRecordService occupantRecordService;
    @ApiOperation("获取时间段内顾客流量")
    @GetMapping("/getCustomerFlowByTime")
    public List<Map<String,Object>> getCustomerFlowByTime(@Param("start") String start, @Param("end") String end){
        return occupantRecordService.getCustomerFlowByTime(start,end);
    }
}
