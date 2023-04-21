package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Commodity;
import com.ncu.hotel_server.mapper.CommodityMapper;
import com.ncu.hotel_server.mapper.CommodityRecordMapper;
import com.ncu.hotel_server.service.CommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {
    @Autowired
    CommodityRecordMapper commodityRecordMapper;

    @Override
    public List<Map<String, Object>> selectAllInfo() {
        return baseMapper.selectAllInfo();
    }

    @Override
    public List<Map<String, Object>> getCommodityType() {
        return baseMapper.getCommodityType();
    }

    @Override
    public Integer insertCommodity(Map<String,String> params) {
        return baseMapper.insertCommodity((String)params.get("name"),(String) params.get("price"),params.get("amount"),(String) params.get("commodity_url"),params.get("commodity_introduction"), params.get("category_id"));
    }

    @Override
    public Integer updateCommodity(Map<String,String> params) {
        return baseMapper.updateCommodity( params.get("commodity_id"), params.get("name"), params.get("price"), params.get("amount"), params.get("commodity_url"), params.get("commodity_introduction"), params.get("category_id"));
    }

    @Override
    public Integer deleteCommodity(int id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getCommodityRecordByTime(String start, String end) {
        return baseMapper.getCommodityRecordByTime(start,end);
    }
    @Transactional
    @Override
    public Integer insertCommodityRecords(Map<String, Object> params) throws Exception {
        Integer record_id= Integer.parseInt(params.get("record_id").toString()) ;
        Integer commodity_id=0;
        Integer count=0;
        Integer amount=0;
        Double price=0.0;
        int update=0;
        int insert=0;
        List<Map<String, Object>> commodities= (List<Map<String, Object>>) params.get("commodities");
        for (Map<String,Object> element:commodities) {
            commodity_id= (Integer) element.get("commodity_id");
            count= (Integer) element.get("count");
            amount=(Integer) element.get("amount");
            price= Double.parseDouble(element.get("price").toString());

            update+=baseMapper.updateAmountById(amount-count,commodity_id);
            insert+= baseMapper.insertRecord(record_id,commodity_id,count,count*price);
            //System.out.println("id:"+commodity_id+"count:"+count+"price:"+price);
        }
        if(update==insert&&update==commodities.size()){
            return 1;
        }
        else
             throw new Exception("商品记录添加出现异常");
    }

    @Override
    public Integer deleteCommodityRecordById(Integer id) {
        return commodityRecordMapper.deleteCommodityRecordById(id);
    }
}
