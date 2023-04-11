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
@TableName("room")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "room_id", type = IdType.AUTO)
    private Integer roomId;

    @TableField("room_number")
    private String roomNumber;

    /**
     * 房间照片
     */
    @TableField("room_url")
    private String roomUrl;

    /**
     * 1为单人间，2为双人间，3为三人间
     */
    @TableField("room_type")
    private String roomType;

    /**
     * 房间价格(每天)
     */
    @TableField("room_price")
    private Float roomPrice;

    /**
     * 钟点房价格
     */
    @TableField("hour_price")
    private Float hourPrice;


    /**
     * 房间简介
     */
    @TableField("room_introduction")
    private String roomIntroduction;

    /**
     * 0为不启用，1为启用
     */
    @TableField("room_state")
    private String roomState;


    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public Float getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(Float hourPrice) {
        this.hourPrice = hourPrice;
    }


    public String getRoomIntroduction() {
        return roomIntroduction;
    }

    public void setRoomIntroduction(String roomIntroduction) {
        this.roomIntroduction = roomIntroduction;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    @Override
    public String toString() {
        return "Room{" +
        "roomId=" + roomId +
        ", roomNumber=" + roomNumber +
        ", roomUrl=" + roomUrl +
        ", roomType=" + roomType +
        ", roomPrice=" + roomPrice +
        ", hourPrice=" + hourPrice +
        ", roomIntroduction=" + roomIntroduction +
        ", roomState=" + roomState +
        "}";
    }
}
