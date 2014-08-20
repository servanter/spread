package com.zhy.spread.service;

import java.util.List;

import com.zhy.spread.entity.InfoClass;

/**
 * 分类业务
 * 
 * @author ZhangHongyan
 */
public interface InfoClassService {

    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    public InfoClass findById(Long id);
    
    /**
     * 获取所有分类<br>
     * 大类 get(0) <br>
     * 小类 get(1)
     * 
     * @author ZhangHongyan
     * @return
     */
    public List<Object> findAllClasses();

    /**
     * 新增分类
     * 
     * @author ZhangHongyan
     * @param infoClass
     */
    public InfoClass addOrModify(InfoClass infoClass);

    /**
     * 查询父级分类
     * 
     * @return
     */
    public List<InfoClass> findTopClasses();

    /**
     * 查询父级分类下面的小类别
     * 
     * @param id
     * @return
     */
    public List<InfoClass> findSubClasses(Long id);
}
