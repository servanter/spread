package com.zhy.spread.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "spread_area")
public class Area implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 9177757642365965706L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "area_name", nullable = false)
    private String areaName;

    @Column(name = "area_ename", nullable = false)
    private String areaEname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
    private Set<WeChat> provinceWeChats = new HashSet<WeChat>();
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
    private Set<WeChat> cityWeChats = new HashSet<WeChat>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaEname() {
        return areaEname;
    }

    public void setAreaEname(String areaEname) {
        this.areaEname = areaEname;
    }

    public Set<WeChat> getProvinceWeChats() {
        return provinceWeChats;
    }

    public void setProvinceWeChats(Set<WeChat> provinceWeChats) {
        this.provinceWeChats = provinceWeChats;
    }

    public Set<WeChat> getCityWeChats() {
        return cityWeChats;
    }

    public void setCityWeChats(Set<WeChat> cityWeChats) {
        this.cityWeChats = cityWeChats;
    }
}
