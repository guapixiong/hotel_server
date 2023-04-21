package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

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
public interface CommodityService extends IService<Commodity> {
    List<Map<String, Object>> selectAllInfo();
    List<Map<String,Object>> getCommodityType();
    Integer insertCommodity(Map<String,String> params);
    Integer updateCommodity(Map<String,String> params);
    Integer deleteCommodity(int id);
    List<Map<String,Object>> getCommodityRecordByTime(String start,String end);
    Integer insertCommodityRecords( Map<String, Object> params) throws Exception;
    Integer deleteCommodityRecordById(Integer id);
}
