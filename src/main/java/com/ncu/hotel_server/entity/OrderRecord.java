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
@TableName("order_record")
public class OrderRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField("customer_id")
    private String customerId;

    /**
     * 房间id
     */
    @TableField("room_id")
    private String roomId;

    /**
     * 0为标准房价格，1为钟点房
     */
    @TableField("room_type")
    private String roomType;

    /**
     * -1为已退款，0为已取消，1为已预定，2待结账，3已完成
     */
    @TableField("order_status")
    private String orderStatus;

    /**
     * 入住时间
     */
    @TableField("check_in_time")
    private LocalDateTime checkInTime;

    /**
     * 退房时间
     */
    @TableField("check_out_time")
    private LocalDateTime checkOutTime;

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
     * 0为现金支付，1为账户支付
     */
    @TableField("payment_type")
    private String paymentType;
    /**
     * 最终付款金额，将房间费用和商品费用结算在一起
     */
    @TableField("final_payment_amount")
    private Float finalPaymentAmount;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Float getFinalPaymentAmount() {
        return finalPaymentAmount;
    }

    public void setFinalPaymentAmount(Float finalPaymentAmount) {
        this.finalPaymentAmount = finalPaymentAmount;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
        "orderId=" + orderId +
        ", customerId=" + customerId +
        ", roomId=" + roomId +
        ", roomType=" + roomType +
        ", orderStatus=" + orderStatus +
        ", checkInTime=" + checkInTime +
        ", checkOutTime=" + checkOutTime +
        ", createTime=" + createTime +
        ", completeTime=" + completeTime +
        ", paymentType=" + paymentType +
        ", finalPaymentAmount=" + finalPaymentAmount +
        "}";
    }
}
