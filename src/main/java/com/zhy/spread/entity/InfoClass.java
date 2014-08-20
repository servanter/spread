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

import com.zhy.spread.common.Page;

/**
 * 分类类别<br>
 * parentId 有大小类区分
 * 
 * @author zhanghongyan
 * 
 */
@Entity
@Table(name = "spread_info_class")
public class InfoClass extends Page implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2131723398253769691L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * 父类ID
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = true)
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "infoClass")
    private Set<WeChat> weChats = new HashSet<WeChat>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<WeChat> getWeChats() {
        return weChats;
    }

    public void setWeChats(Set<WeChat> weChats) {
        this.weChats = weChats;
    }
}
