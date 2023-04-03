package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.OccupantRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Mapper
public interface OccupantRecordMapper extends BaseMapper<OccupantRecord> {
    /**
     * 客流量通过入住时间时的人数俩确定
     * @param start
     * @param end
     * @return
     */
    @Select("select DATE_FORMAT(check_in_time,'%Y-%m-%d') time,o.order_id\n" +
            "from order_record left join occupant_record o on order_record.order_id = o.order_id\n" +
            "where check_in_time between #{start} and #{end} and order_status in('1','2','3')")
    List<Map<String,Object>> getCustomerFlowByTime(@Param("start") String start, @Param("end") String end);
}
