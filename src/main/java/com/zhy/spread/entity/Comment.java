package com.zhy.spread.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import net.sf.json.JSONObject;

import com.zhy.spread.common.Paging;

@Entity
@Table(name = "spread_comment")
public class Comment extends Paging<Comment> implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "wechat_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private WeChat weChat;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private User user;

    @Column(name = "user_name", insertable = true, updatable = false, nullable = false)
    private String userName;

    @Column(name = "content", insertable = true, updatable = false, nullable = false)
    private String content;

    @Column(name = "pic_url", insertable = true, updatable = false, nullable = false)
    private String picUrl;

    @Column(name = "comment_time", insertable = true, updatable = false, nullable = false)
    private Timestamp commentTime;

    @Column(name = "modify_time", insertable = false, updatable = false, nullable = true)
    private Timestamp modifyTime;

    @Column(name = "is_valid", insertable = true, updatable = true, nullable = false)
    private Boolean isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WeChat getWeChat() {
        return weChat;
    }

    public void setWeChat(WeChat weChat) {
        this.weChat = weChat;
    }
    
    public JSONObject toJSON(){
        JSONObject object = new JSONObject();
        object.put("id", this.id);
        object.put("userName", this.userName);
        object.put("picUrl", this.picUrl);
        object.put("content", this.content);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        object.put("commentTime", dateFormat.format(this.commentTime));
        return object;
    }
}
