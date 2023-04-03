package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.OrderRecord;
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
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {
    /**
     * 总收入通过订单状态等于完成的时候来确定
     * @param start
     * @param end
     * @return
     */
    @Select("select  DATE_FORMAT(complete_time,'%Y-%m-%d') time,final_payment_amount\n" +
            "from order_record\n" +
            "where   order_status ='3' and complete_time between #{start} and #{end}")
    List<Map<String,Object>> getSalesByTime(@Param("start") String start, @Param("end") String end);

    /**
     * 订单量通过创建时间来确定，取消也是，视为订单量
     * @param start
     * @param end
     * @return
     */
    @Select("select order_id,DATE_FORMAT(create_time,'%Y-%m-%d') time,order_status\n" +
            "from order_record\n" +
            "where create_time between #{start} and #{end}")
    List<Map<String,Object>> getRecordTotal(@Param("start") String start,@Param("end") String end);
}
