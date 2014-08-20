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
@Table(name = "spread_consume_detail")
public class Consume extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8623771543973201174L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "consume_order_id", nullable = false, insertable = true, updatable = false)
    private String consumeOrderId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, insertable = true, updatable = false)
    private Account account;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "recommend_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private Recommend recommend;

    @Column(name = "price", nullable = false, updatable = false, insertable = true)
    private Integer price;

    @Column(name = "start_time", nullable = false, insertable = true, updatable = true)
    private Timestamp startTime;

    @Column(name = "end_time", nullable = false, insertable = true, updatable = true)
    private Timestamp endTime;

    @Column(name = "create_time", nullable = true, insertable = false)
    private Timestamp createTime;

    @Column(name = "cur_total_money", nullable = false, insertable = true, updatable = false)
    private Long curTotalMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recommend getRecommend() {
        return recommend;
    }

    public void setRecommend(Recommend recommend) {
        this.recommend = recommend;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getCurTotalMoney() {
        return curTotalMoney;
    }

    public void setCurTotalMoney(Long curTotalMoney) {
        this.curTotalMoney = curTotalMoney;
    }

    public String getConsumeOrderId() {
        return consumeOrderId;
    }

    public void setConsumeOrderId(String consumeOrderId) {
        this.consumeOrderId = consumeOrderId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

}
