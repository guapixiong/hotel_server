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
@TableName("room")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "room_id", type = IdType.AUTO)
    private Integer roomId;

    @TableField("room_name")
    private String roomName;

    /**
     * 房间照片
     */
    @TableField("room_url")
    private String roomUrl;

    /**
     * 0为钟点房，1为单人间，2为双人间，3为三人间
     */
    @TableField("room_type")
    private String roomType;

    /**
     * 房间价格
     */
    @TableField("room_price")
    private Float roomPrice;

    /**
     * 押金
     */
    @TableField("room_deposit")
    private Float roomDeposit;

    /**
     * 房间折扣
     */
    @TableField("room_discount")
    private Float roomDiscount;

    /**
     * 默认1，0未启用，1为可使用空房，2已预定，3为已住人,4为已退房未整理
     */
    @TableField("room_state")
    private String roomState;

    /**
     * 房间简介
     */
    @TableField("room_introduction")
    private String roomIntroduction;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Float getRoomDeposit() {
        return roomDeposit;
    }

    public void setRoomDeposit(Float roomDeposit) {
        this.roomDeposit = roomDeposit;
    }

    public Float getRoomDiscount() {
        return roomDiscount;
    }

    public void setRoomDiscount(Float roomDiscount) {
        this.roomDiscount = roomDiscount;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomIntroduction() {
        return roomIntroduction;
    }

    public void setRoomIntroduction(String roomIntroduction) {
        this.roomIntroduction = roomIntroduction;
    }

    @Override
    public String toString() {
        return "Room{" +
        "roomId=" + roomId +
        ", roomName=" + roomName +
        ", roomUrl=" + roomUrl +
        ", roomType=" + roomType +
        ", roomPrice=" + roomPrice +
        ", roomDeposit=" + roomDeposit +
        ", roomDiscount=" + roomDiscount +
        ", roomState=" + roomState +
        ", roomIntroduction=" + roomIntroduction +
        "}";
    }
}
