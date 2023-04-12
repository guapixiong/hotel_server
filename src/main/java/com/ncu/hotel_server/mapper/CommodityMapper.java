package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
