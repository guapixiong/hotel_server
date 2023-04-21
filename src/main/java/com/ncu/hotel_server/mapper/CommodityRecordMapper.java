package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.CommodityRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Mapper
public interface CommodityRecordMapper extends BaseMapper<CommodityRecord> {
    /**
     * 更新商品记录 ，退房操作
     * @param orderId
     * @param status
     * @param time
     * @return
     */
    @Update("update commodity_record set complete_time=#{time},commodity_status=#{status} where order_id=#{orderId}")
    Integer checkoutOrder(@Param("orderId") Integer orderId,@Param("status") String status,@Param("time") String time);

    @Delete("delete from commodity_record where id=#{id}")
    Integer deleteCommodityRecordById(@Param("id") Integer id);
}
