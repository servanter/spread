package com.zhy.spread.dao;

import java.util.List;

import com.zhy.spread.entity.InfoClass;

/**
 * 分类DAO
 *
 * @author ZhangHongyan
 */
public interface InfoClassDAO {

    /**
     * 获取所有分类
     *
     * @author ZhangHongyan
     * @return
     */
    public List<InfoClass> getAll();

    /**
     * 新增或更新
     *
     * @author ZhangHongyan
     * @param infoClass
     * @return
     */
    public InfoClass saveOrUpdate(InfoClass infoClass);

    public List<InfoClass> getSubClasses(Long id);

    public List<InfoClass> getTopClasses();

    public InfoClass getById(Long id);

}
