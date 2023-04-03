package com.ncu.hotel_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 押金记录
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@TableName("deposit")
public class Deposit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("order_id")
    private Integer orderId;

    @TableField("payment_type")
    private Integer paymentType;

    /**
     * 登记时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 完成时间
     */
    @TableField("complete_time")
    private LocalDateTime completeTime;

    /**
     * 押金
     */
    @TableField("deposit")
    private Float deposit;


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

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
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

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Deposit{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", paymentType=" + paymentType +
        ", createTime=" + createTime +
        ", completeTime=" + completeTime +
        ", deposit=" + deposit +
        "}";
    }
}
