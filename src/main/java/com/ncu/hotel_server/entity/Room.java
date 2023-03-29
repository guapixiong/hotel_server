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
 * @since 2023-03-29
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

    @TableField("room_price")
    private Float roomPrice;

    /**
     * 押金
     */
    @TableField("room_deposit")
    private Float roomDeposit;

    /**
     * 默认0，0未启用，1为可使用空房，2为已住人,3为已退房未整理
     */
    @TableField("room_state")
    private String roomState;

    /**
     * 房间大小，多少平单位m2
     */
    @TableField("room_size")
    private String roomSize;

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

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }
}
