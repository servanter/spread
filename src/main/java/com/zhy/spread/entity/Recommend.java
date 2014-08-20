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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zhy.spread.common.Page;

/**
 * 推荐
 * 
 * @author ZhangHongyan
 */
@Entity
@Table(name = "spread_recommend")
public class Recommend extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3239508314349592977L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, insertable = true)
    private Long id;

    @Column(name = "alias_code", nullable = false, unique = true, insertable = true)
    private Integer aliasCode;

    @Column(name = "recommend_name", nullable = false, insertable = true)
    private String recommedName;

    @Column(name = "description", nullable = false, insertable = true)
    private String description;

    @Column(name = "max_position", nullable = false, insertable = true, updatable = true)
    private Integer maxPosition;

    /**
     * 当前剩余位置
     */
    @Column(name = "current_surplus_position", nullable = false, updatable = true)
    private Integer currentSurplusPosition;

    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    private Integer price;

    @Column(name = "modify_time", nullable = false, insertable = false)
    private Timestamp modifyTime;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "recommends", targetEntity = WeChat.class, fetch = FetchType.LAZY)
    private Set<WeChat> weChats = new HashSet<WeChat>();

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "recommend")
    private List<Consume> consumes = new ArrayList<Consume>();

    public Recommend(){
        
    }
    
    public Recommend(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommedName() {
        return recommedName;
    }

    public void setRecommedName(String recommedName) {
        this.recommedName = recommedName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(Integer maxPosition) {
        this.maxPosition = maxPosition;
    }

    public Integer getCurrentSurplusPosition() {
        return currentSurplusPosition;
    }

    public void setCurrentSurplusPosition(Integer currentSurplusPosition) {
        this.currentSurplusPosition = currentSurplusPosition;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Set<WeChat> getWeChats() {
        return weChats;
    }

    public void setWeChats(Set<WeChat> weChats) {
        this.weChats = weChats;
    }

    public Integer getAliasCode() {
        return aliasCode;
    }

    public void setAliasCode(Integer aliasCode) {
        this.aliasCode = aliasCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Consume> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<Consume> consumes) {
        this.consumes = consumes;
    }

}
