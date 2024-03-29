package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import javafx.beans.binding.ObjectExpression;
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
public interface CommodityMapper extends BaseMapper<Commodity> {
    /**
     * 查询商品信息和种类
     * @return
     */
    @Select("select *\n" +
            "from commodity,category\n" +
            "where commodity.category_id=category.id")
    List<Map<String, Object>> selectAllInfo();
    @Select("select * from category")
    /**
     * 查询商品种类
     */
    List<Map<String,Object>> getCommodityType();
    /**
     * 插入一条商品信息
     */
    @Insert("INSERT INTO commodity ( name, price, amount, commodity_url, commodity_introduction, category_id ) VALUES ( #{name}, #{price}, #{amount},#{url},#{introduction},#{category_id} )")
    Integer insertCommodity(@Param("name") String name, @Param("price") String price, @Param("amount") String amount, @Param("url") String url,@Param("introduction") String introduction,@Param("category_id") String category_id);

    /**
     * 更新商品信息
     * @return
     */
    @Update("update commodity set name=#{name},price=#{price},amount=#{amount},commodity_url=#{commodity_url},commodity_introduction=#{commodity_introduction},category_id=#{category_id}\n" +
            "where commodity_id=#{commodity_id} ")
    Integer updateCommodity(@Param("commodity_id") String commodity_id,@Param("name") String name,@Param("price") String  price,@Param("amount") String amount,@Param("commodity_url") String commodity_url,@Param("commodity_introduction")String commodity_introduction,@Param("category_id") String category_id);

    /**
     * 查找时间段内所有商品订单详情
     * @param start
     * @param end
     * @return
     */
    @Select("select a.id,\n" +
            "       a.order_id,\n" +
            "       r.room_number,\n" +
            "       c2.customer_name,\n" +
            "       c2.customer_phone,\n" +
            "       c.name,\n" +
            "       a.commodity_status,\n" +
            "       a.commodity_count,\n" +
            "       a.money,\n" +
            "       a.create_time,\n" +
            "       a.complete_time\n" +
            "from commodity_record a\n" +
            "         left join commodity c on a.commodity_id = c.commodity_id\n" +
            "         left outer join order_record o on a.order_id = o.order_id\n" +
            "         left join customer c2 on o.customer_id = c2.customer_id left join room r on o.room_id = r.room_id\n" +
            "where   a.create_time between #{start} and #{end} order by a.create_time desc")
    List<Map<String,Object>> getCommodityRecordByTime(@Param("start")String start,@Param("end")String end);

    /**
     * 更新商品数量
     * @param amount
     * @param commodity_id
     * @return
     */
    @Update("update commodity set amount=#{amount} where commodity_id=#{commodity_id}")
    Integer updateAmountById(@Param("amount") Integer amount,@Param("commodity_id") Integer commodity_id);

    /**
     * 插入商品记录
     * @param order_id
     * @param commodity_id
     * @param commodity_count
     * @param money
     * @return
     */
    @Insert("INSERT INTO commodity_record ( order_id, commodity_id,  commodity_count, money ) VALUES ( #{order_id},#{commodity_id},#{commodity_count},#{money})")
    Integer insertRecord(@Param("order_id") Integer order_id,@Param("commodity_id") Integer commodity_id,@Param("commodity_count") Integer commodity_count,@Param("money") Double money);
    @Select("select * from commodity where commodity_id=#{commodity_id}")
    Map<String,Object> selectCommodityById(@Param("commodity_id") Integer commodity_id);

}
