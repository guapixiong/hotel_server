package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.OccupantRecord;
import com.ncu.hotel_server.mapper.OccupantRecordMapper;
import com.ncu.hotel_server.service.OccupantRecordService;
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
public class OccupantRecordServiceImpl extends ServiceImpl<OccupantRecordMapper, OccupantRecord> implements OccupantRecordService {
    @Override
    public List<Map<String, Object>> getCustomerFlowByTime(String start, String end) {

        return baseMapper.getCustomerFlowByTime(start,end);
    }
}
