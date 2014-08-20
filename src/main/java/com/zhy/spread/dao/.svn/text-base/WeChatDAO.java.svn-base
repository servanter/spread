package com.zhy.spread.dao;

import java.util.List;

import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.WeChat;

public interface WeChatDAO {

    public WeChat saveOrUpdate(WeChat weChat);

    public Paging<WeChat> getWeChats(WeChat weChat);

    public Paging<WeChat> getRecommendWeChats(Recommend recommend);

    public Paging<WeChat> findLastWeChatsByPage(Page page);

    public Paging<WeChat> getRecommendByKeyWords(String[] keyWords, WeChat weChat);

    public Paging<WeChat> getHotWeChats(Page page);

    public Paging<WeChat> getByInfoClass(InfoClass infoClass);

    public WeChat getById(Long id);

    public Paging<WeChat> getByConditions(WeChat weChat);

    public void batchSave(List<WeChat> weChats);

    public Paging<WeChat> getByParentInfoClass(InfoClass infoClass);

}
