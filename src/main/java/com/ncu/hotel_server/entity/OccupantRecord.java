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
 * @since 2023-04-03
 */
@TableName("occupant_record")
public class OccupantRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房间订单id
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 身份证号
     */
    @TableField("card_id")
    private String cardId;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 0为居民身份证，1为临时身份证
     */
    @TableField("type")
    private String type;


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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OccupantRecord{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", cardId=" + cardId +
        ", name=" + name +
        ", type=" + type +
        "}";
    }
}
