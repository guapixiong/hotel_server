package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.entity.Commodity;
import com.ncu.hotel_server.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@Api("商品接口")
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    CommodityService commodityService;
    @ApiOperation("查询所有商品信息")
    @GetMapping("/getAllInfo")
    public List<Map<String,Object>> getAllInfo(){
        return commodityService.selectAllInfo();
    }

    @ApiOperation("查询所有种类")
    @GetMapping("/getCommodityType")
    public List<Map<String,Object>> getCommodityType(){
        return commodityService.getCommodityType();
    }

    @ApiOperation("插入一条商品信息")
    @PostMapping("/insertCommodity")
    public Integer insertCommodity(@RequestBody Map<String,String> params){
        return commodityService.insertCommodity(params);
    }
    @ApiOperation("更新一条商品信息")
    @PostMapping("/updateCommodity")
    public Integer updateCommodity(@RequestBody Map<String,String> params){
        return commodityService.updateCommodity(params);
    }
    @ApiOperation("删除一条商品信息")
    @GetMapping("/deleteCommodity")
    public Integer deleteCommodity(@Param("commodity_id") int commodity_id){
        return commodityService.deleteCommodity(commodity_id);
    }
    @ApiOperation("通过时间来获取商品记录")
    @GetMapping("/getCommodityRecordByTime")
    public List<Map<String,Object>> getCommodityRecordByTime( String start,  String end){
        return commodityService.getCommodityRecordByTime(start,end);
    }
}
