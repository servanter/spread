package com.zhy.spread.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "spread_rel_wechat_recommend")
public class RelWeChatRecommend implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -523467096704677039L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "wechat_id", nullable = false, unique = true, insertable = true)
    private Long weChatId;

    @Column(name = "recommend_id", nullable = false, insertable = true)
    private Long recommendId;

    @Column(name = "create_time", nullable = false, insertable = false)
    private Timestamp createTime;

    @Column(name = "modify_time", nullable = false, insertable = true)
    private Timestamp modifyTime;

    @Column(name = "is_valid", updatable = true, insertable = false)
    private Boolean isValid;

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(Long weChatId) {
        this.weChatId = weChatId;
    }

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
