package com.zhy.spread.service;

import java.util.List;

import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.WeChat;

/**
 * 微信业务
 * 
 * @author zhanghongyan
 * 
 */
public interface WeChatService {

    /**
     * 根据ID查询
     *
     * @author ZhangHongyan
     * @param id
     * @return
     */
    public WeChat findById(Long id);
    
    /**
     * 新增或更新
     * 
     * @param weChat
     * @return
     */
    public WeChat addOrModify(WeChat weChat);
    
    /**
     * 批量插入
     *
     * @param weChats
     * @return
     */
    public void batchSave(List<WeChat> weChats);

    /**
     * 查询微信列表
     * 
     * @param weChat
     * @return
     */
    public Paging<WeChat> findWeChats(WeChat weChat);

    /**
     * 获取推荐微信列表
     * 
     * @param recommend
     * @return
     */
    public Paging<WeChat> findRecommendWeChats(Recommend recommend);

    /**
     * 获取最近收录的微信
     * 
     * @param page
     * @return
     */
    public Paging<WeChat> findRecentlyWeChats(Page page);

    /**
     * 根据关键词模糊查询
     * 
     * @author ZhangHongyan
     * @param keyWords
     * @param page
     * @return
     */
    public Paging<WeChat> searchByKeyWords(String[] keyWords, WeChat weChat);

    /**
     * 获取最新排行
     * 
     * @author ZhangHongyan
     * @param page
     * @return
     */
    public Paging<WeChat> findHotWeChats(Page page);
    
    /**
     * 按行业分类
     *
     * @author ZhangHongyan
     * @param infoClass
     * @return
     */
    public Paging<WeChat> findByInfoClass(InfoClass infoClass);
    
    /**
     * 按行业父类分类
     *
     * @author ZhangHongyan
     * @param infoClass
     * @return
     */
    public Paging<WeChat> findByParentInfoClass(InfoClass infoClass);
    /**
     * 根据条件查询
     *
     * @param weChat
     * @return
     */
    public Paging<WeChat> findByConditions(WeChat weChat);
}
