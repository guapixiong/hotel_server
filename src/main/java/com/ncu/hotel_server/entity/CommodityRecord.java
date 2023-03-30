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
 * @since 2023-03-30
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
     * 顾客id
     */
    @TableField("customer_id")
    private String customerId;

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
     * 房间id
     */
    @TableField("room_id")
    private String roomId;

    /**
     * 员工id
     */
    @TableField("staff_id")
    private String staffId;

    /**
     * -1已退款，0为已取消，1为已创建，2已送达，3待结账，4已完成
     */
    @TableField("order_status")
    private String orderStatus;

    @TableField("payment_amount")
    private Float paymentAmount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "CommodityRecord{" +
        "id=" + id +
        ", customerId=" + customerId +
        ", commodityId=" + commodityId +
        ", createTime=" + createTime +
        ", completeTime=" + completeTime +
        ", roomId=" + roomId +
        ", staffId=" + staffId +
        ", orderStatus=" + orderStatus +
        ", paymentAmount=" + paymentAmount +
        "}";
    }
}
