package com.zhy.spread.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "spread_action")
public class Action implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7011098428834508924L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "s_share", nullable = false, insertable = true, updatable = true)
    private Integer share;

    @Column(name = "s_read", nullable = false, insertable = true, updatable = true)
    private Integer read;

    @Column(name = "s_enjoy", nullable = false, insertable = true, updatable = true)
    private Integer enjoy;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "wechat_id", referencedColumnName = "id", unique = true)
    private WeChat weChat;

    @Column(name = "create_time", nullable = true, insertable = false, updatable = false)
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(Integer enjoy) {
        this.enjoy = enjoy;
    }

    public WeChat getWeChat() {
        return weChat;
    }

    public void setWeChat(WeChat weChat) {
        this.weChat = weChat;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
