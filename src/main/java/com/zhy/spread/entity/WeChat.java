package com.zhy.spread.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jsoup.Jsoup;

import com.zhy.spread.common.Page;

/**
 * ΢微信
 * 
 * @author zhanghongyan
 * 
 */
@Entity
@Table(name = "spread_wechat")
public class WeChat extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5368247044733799408L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 省份
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "province", referencedColumnName = "id", nullable = false, insertable = true, updatable = false)
    private Area province;

    /**
     * 城市
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "city", referencedColumnName = "id", nullable = false, insertable = true, updatable = false)
    private Area city;

    /**
     * 类别
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "info_class_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private InfoClass infoClass;

    /**
     * 资源
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "weChat")
    private List<WeResource> weResource;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "weChat")
    private List<Comment> comments = new ArrayList<Comment>();

    @Column(name = "row_alias_num", nullable = false)
    private String rowAliasNum;

    /**
     * 微信号
     */
    @Column(name = "alias_num", nullable = false)
    private String aliasNum;

    /**
     * 描述
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * 关键词
     */
    @Column(name = "keywords", nullable = false)
    private String keywords;

    /**
     * ԭ原图片
     */
    @Column(name = "row_icon", nullable = false)
    private String rowIcon;

    /**
     * 二维码
     */
    @Column(name = "qr_code", nullable = false)
    private String qrCode;

    /**
     * 推荐(多对多)
     */
    @ManyToMany(targetEntity = Recommend.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "spread_rel_wechat_recommend", joinColumns = { @JoinColumn(name = "wechat_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "recommend_id", referencedColumnName = "id") })
    private Set<Recommend> recommends = new HashSet<Recommend>();

    /**
     * 收录时间
     */
    @Column(name = "create_time", nullable = true, insertable = false)
    private Timestamp createTime;

    /**
     * 动作
     */
    @OneToOne(cascade = CascadeType.REFRESH, mappedBy = "weChat", fetch = FetchType.LAZY)
    private Action action;

    @Column(name = "url", nullable = true, insertable = true, updatable = true)
    private String url;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = true, updatable = false, nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getProvince() {
        return province;
    }

    public void setProvince(Area province) {
        this.province = province;
    }

    public Area getCity() {
        return city;
    }

    public void setCity(Area city) {
        this.city = city;
    }

    public InfoClass getInfoClass() {
        return infoClass;
    }

    public void setInfoClass(InfoClass infoClass) {
        this.infoClass = infoClass;
    }

    public String getAliasNum() {
        return aliasNum;
    }

    public void setAliasNum(String aliasNum) {
        this.aliasNum = aliasNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getRowIcon() {
        return rowIcon;
    }

    public void setRowIcon(String rowIcon) {
        this.rowIcon = rowIcon;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Set<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(Set<Recommend> recommends) {
        this.recommends = recommends;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WeResource> getWeResource() {
        return weResource;
    }

    public void setWeResource(List<WeResource> weResource) {
        this.weResource = weResource;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getRowAliasNum() {
        return rowAliasNum;
    }

    public void setRowAliasNum(String rowAliasNum) {
        this.rowAliasNum = rowAliasNum;
    }

    public static void main(String[] args) {
    }
}
