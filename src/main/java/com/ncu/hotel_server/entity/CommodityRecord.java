package com.ncu.hotel_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@TableName("commodity_record")
public class CommodityRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 商品id
     */
    @TableField("commodity_id")
    private Integer commodityId;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 订单完成时间
     */
    @TableField("complete_time")
    private LocalDateTime completeTime;

    /**
     * 0为已取消，1为已创建
     */
    @TableField("commodity_status")
    private String commodityStatus;

    /**
     * 商品数量
     */
    @TableField("commodity_count")
    private Integer commodityCount;

    /**
     * 消费金额
     */
    @TableField("money")
    private Float money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(LocalDateTime completeTime) {
        this.completeTime = completeTime;
    }

    public String getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(String commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "CommodityRecord{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", commodityId=" + commodityId +
        ", createTime=" + createTime +
        ", completeTime=" + completeTime +
        ", commodityStatus=" + commodityStatus +
        ", commodityCount=" + commodityCount +
        ", money=" + money +
        "}";
    }
}
