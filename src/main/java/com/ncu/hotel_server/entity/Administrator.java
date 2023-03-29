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

@TableName("administrator")
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "administrator_id", type = IdType.AUTO)
    private Integer administratorId;

    @TableField("administrator_name")
    private String administratorName;

    @TableField("administrator_phone")
    private String administratorPhone;

    @TableField("account_name")
    private String accountName;

    @TableField("account_password")
    private String accountPassword;

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getAdministratorPhone() {
        return administratorPhone;
    }

    public void setAdministratorPhone(String administratorPhone) {
        this.administratorPhone = administratorPhone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
