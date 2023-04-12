package com.ncu.hotel_server.mapper;

import com.ncu.hotel_server.entity.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Mapper;
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
}
