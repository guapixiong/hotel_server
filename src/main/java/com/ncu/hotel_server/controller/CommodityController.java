package com.ncu.hotel_server.controller;

import com.ncu.hotel_server.service.CommodityService;
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
}
