package com.ncu.hotel_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xph
 * @since 2023-03-30
 */
@TableName("commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 商品价格
     */
    @TableField("price")
    private Float price;

    /**
     * 商品数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 商品图片
     */
    @TableField("commodity_url")
    private String commodityUrl;

    /**
     * 房间简介
     */
    @TableField("commodity_introduction")
    private String commodityIntroduction;


    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCommodityUrl() {
        return commodityUrl;
    }

    public void setCommodityUrl(String commodityUrl) {
        this.commodityUrl = commodityUrl;
    }

    public String getCommodityIntroduction() {
        return commodityIntroduction;
    }

    public void setCommodityIntroduction(String commodityIntroduction) {
        this.commodityIntroduction = commodityIntroduction;
    }

    @Override
    public String toString() {
        return "Commodity{" +
        "commodityId=" + commodityId +
        ", name=" + name +
        ", price=" + price +
        ", amount=" + amount +
        ", commodityUrl=" + commodityUrl +
        ", commodityIntroduction=" + commodityIntroduction +
        "}";
    }
}
