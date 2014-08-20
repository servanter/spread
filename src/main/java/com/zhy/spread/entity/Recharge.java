package com.zhy.spread.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zhy.spread.common.Page;

@Entity
@Table(name = "spread_recharge_detail")
public class Recharge extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7376424260718842462L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "recharge_type", nullable = false, insertable = true, updatable = false)
    private Integer rechargeType;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = true, updatable = false)
    private User user;

    @Column(name = "money", nullable = false, insertable = true, updatable = false)
    private Long money;

    @Column(name = "recharge_order_id", nullable = false, insertable = true, updatable = false)
    private String rechargeOrderId;

    @Column(name = "recharge_time", nullable = true, insertable = false, updatable = false)
    private Timestamp rechargeTime;

    @Column(name = "return_code", nullable = false, insertable = true, updatable = true)
    private Integer returnCode;

    @Column(name = "recharge_comment", nullable = true, insertable = true, updatable = false)
    private String rechargeComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRechargeType() {
        return rechargeType;
    }

    public void setRechargeType(Integer rechargeType) {
        this.rechargeType = rechargeType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRechargeOrderId() {
        return rechargeOrderId;
    }

    public void setRechargeOrderId(String rechargeOrderId) {
        this.rechargeOrderId = rechargeOrderId;
    }

    public Timestamp getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Timestamp rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeComment() {
        return rechargeComment;
    }

    public void setRechargeComment(String rechargeComment) {
        this.rechargeComment = rechargeComment;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }
}
