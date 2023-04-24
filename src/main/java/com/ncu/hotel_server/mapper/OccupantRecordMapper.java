package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.OccupantRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

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
     * 客流量通过登记身份证的人数来确定
     * @param start
     * @param end
     * @return
     */
    @Select("select id, order_id, card_id, name, type,DATE_FORMAT( register_time,'%Y-%m-%d') time, leave_time from occupant_record where register_time between #{start} and #{end} order by register_time")
    List<Map<String,Object>> getCustomerFlowByTime(@Param("start") String start, @Param("end") String end);

    /**
     * 退房操作
     * @param id
     * @param time
     * @return
     */
    @Update("update occupant_record set leave_time=#{time} where order_id=#{id}")
    Integer checkoutRecord(@Param("id") Integer id,@Param("time") String time);

    /**
     * 根据订单id来确定入住人
     * @param orderId
     * @return
     */
    @Select("select * from occupant_record where order_id=#{orderId}")
    List<Map<String,Object>> getCustomerByRecordId(@Param("orderId") Integer orderId);

    /**
     * 根据时间获取入住人
     * @param start
     * @param end
     * @return
     */
    @Select("select a.id, a.name,a.card_id,r.room_number,a.type,a.register_time,a.leave_time\n" +
            "from occupant_record a left join order_record o on a.order_id = o.order_id left join room r on o.room_id = r.room_id\n" +
            "where register_time between #{start} and #{end} order by register_time desc")
    List<Map<String,Object>> getOccupantByTime(@Param("start") String start,@Param("end") String end);

    /**
     * 删除一条入住记录
     * @param id
     * @return
     */
    @Delete("delete from occupant_record where id=#{id}")
    Integer deleteOccupantById(@Param("id") Integer id);

}
