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
 * @since 2023-03-29
 */

@TableName("order_record")
public class OrderRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField("customer_id")
    private String customerId;

    @TableField("create_date")
    private LocalDateTime createDate;

    @TableField("check_in_time")
    private LocalDateTime checkInTime;

    @TableField("check_out_time")
    private LocalDateTime checkOutTime;

    @TableField("room_id")
    private String roomId;

    @TableField("staff_id")
    private String staffId;

    /**
     * -1已退押金，0为已取消，1为已创建，2已付押金，3已入住，4待结账，5已完成
     */
    @TableField("order_status")
    private String orderStatus;

    @TableField("payment_amount")
    private Float paymentAmount;

    /**
     * 入住人数
     */
    @TableField("livingPopulation")
    private Integer livingPopulation;

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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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

    public Integer getLivingPopulation() {
        return livingPopulation;
    }

    public void setLivingPopulation(Integer livingPopulation) {
        this.livingPopulation = livingPopulation;
    }
}
