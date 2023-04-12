package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Commodity;
import com.ncu.hotel_server.mapper.CommodityMapper;
import com.ncu.hotel_server.service.CommodityService;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {

    @Override
    public List<Map<String, Object>> selectAllInfo() {
        return baseMapper.selectAllInfo();
    }

    @Override
    public List<Map<String, Object>> getCommodityType() {
        return baseMapper.getCommodityType();
    }
}
