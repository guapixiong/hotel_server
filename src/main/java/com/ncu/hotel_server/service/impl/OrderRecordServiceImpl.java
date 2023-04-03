package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.OrderRecord;
import com.ncu.hotel_server.mapper.OrderRecordMapper;
import com.ncu.hotel_server.service.OrderRecordService;
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
public class OrderRecordServiceImpl extends ServiceImpl<OrderRecordMapper, OrderRecord> implements OrderRecordService {
    @Override
    public List<Map<String, Object>> getSalesByTime(String start, String end) {
        return baseMapper.getSalesByTime(start, end);
    }

    @Override
    public List<Map<String, Object>> getRecordTotal(String start, String end) {
        return baseMapper.getRecordTotal(start,end);
    }
}
