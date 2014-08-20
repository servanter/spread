package com.zhy.spread.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONObject;

import com.zhy.spread.common.Page;
import com.zhy.spread.util.DateUtils;

@Entity
@Table(name = "spread_user")
public class User extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7164812735349758897L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user_name", nullable = false, insertable = true)
    private String userName;

    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    private String password;

    @Column(name = "nickname", nullable = false, insertable = true, updatable = true)
    private String nickname;

    @Column(name = "pic_url", nullable = true, insertable = false, updatable = true)
    private String picUrl;

    @Column(name = "email", nullable = true, insertable = false, updatable = true)
    private String email;

    @Column(name = "phone", nullable = true, insertable = false, updatable = true)
    private String phone;

    @Column(name = "create_time", nullable = true)
    private Timestamp createTime;
    
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user")
    private Account account;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user", fetch = FetchType.LAZY)
    private List<WeChat> weChats = new ArrayList<WeChat>();

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Consume> cousumes = new ArrayList<Consume>();
    
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Recharge> recharges = new ArrayList<Recharge>();

    @Transient
    private String isCookie;
    
    public User() {

    }

    public User(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<WeChat> getWeChats() {
        return weChats;
    }

    public void setWeChats(List<WeChat> weChats) {
        this.weChats = weChats;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<Consume> getCousumes() {
        return cousumes;
    }

    public void setCousumes(List<Consume> cousumes) {
        this.cousumes = cousumes;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Recharge> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<Recharge> recharges) {
        this.recharges = recharges;
    }

    public JSONObject toJSON(){
        JSONObject object = new JSONObject();
        object.put("userName", this.userName);
        object.put("password", this.password);
        object.put("nickname", this.nickname);
        object.put("picUrl", this.picUrl);
        object.put("email", this.email);
        object.put("phone", this.phone);
        object.put("createTime", DateUtils.date2Str(new Date(this.createTime.getTime())));
        return object;
    }

    public String getIsCookie() {
        return isCookie;
    }

    public void setIsCookie(String isCookie) {
        this.isCookie = isCookie;
    }
}
