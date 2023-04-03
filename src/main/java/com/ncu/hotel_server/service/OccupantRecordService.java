package com.ncu.hotel_server.service;

import com.ncu.hotel_server.entity.OccupantRecord;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface OccupantRecordService extends IService<OccupantRecord> {
    List<Map<String,Object>> getCustomerFlowByTime(String start, String end);
}
