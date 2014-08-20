package com.zhy.spread.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "spread_account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = true)
    private User user;

    @Column(name = "total_money", insertable = true, updatable = true, nullable = false)
    private Long totalMoney;

    @Column(name = "create_time", nullable = true, insertable = false)
    private Timestamp createTime;

    @Column(name = "status", insertable = true, updatable = true, nullable = false)
    private Integer status;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Consume> consumes = new ArrayList<Consume>();

    public Account(){
        
    }
    
    public Account(Long id){
        this.id = id;
    }
    
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

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Consume> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<Consume> consumes) {
        this.consumes = consumes;
    }
}
