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
@Table(name = "spread_wechat_resource")
public class WeResource extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4154044974488715558L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "wechat_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private WeChat weChat;

    @Column(name = "url", insertable = true, updatable = true, nullable = false)
    private String url;

    @Column(name = "create_time", insertable = false, updatable = false, nullable = true)
    private Timestamp createTime;

    @Column(name = "is_valid", insertable = true, updatable = true, nullable = true)
    private Boolean isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeChat getWeChat() {
        return weChat;
    }

    public void setWeChat(WeChat weChat) {
        this.weChat = weChat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}
