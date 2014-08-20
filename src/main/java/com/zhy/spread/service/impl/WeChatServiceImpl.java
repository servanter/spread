package com.zhy.spread.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Constant;
import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.WeChatDAO;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.InfoClassService;
import com.zhy.spread.service.WeChatService;

@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private WeChatDAO wechatDAO;
    
    @Autowired
    private InfoClassService infoClassService;

    @Override
    public WeChat addOrModify(WeChat weChat) {
        return wechatDAO.saveOrUpdate(weChat);
    }

    @Override
    public Paging<WeChat> findWeChats(WeChat weChat) {
        return wechatDAO.getWeChats(weChat);
    }

    @Override
    public Paging<WeChat> findRecommendWeChats(Recommend recommend) {
        return wechatDAO.getRecommendWeChats(recommend);
    }

    @Override
    public Paging<WeChat> findRecentlyWeChats(Page page) {
        return wechatDAO.findLastWeChatsByPage(page);
    }

    @Override
    public Paging<WeChat> searchByKeyWords(String[] keyWords, WeChat weChat) {
        return wechatDAO.getRecommendByKeyWords(keyWords, weChat);
    }

    @Override
    public Paging<WeChat> findHotWeChats(Page page) {
        return wechatDAO.getHotWeChats(page);
    }

    @Override
    public Paging<WeChat> findByInfoClass(InfoClass infoClass) {

        // 父类
        if (infoClass.getId() % Constant.CLASS_PARENT_CLASS_POINT == 0) {
            return findByParentInfoClass(infoClass);
        }
        return wechatDAO.getByInfoClass(infoClass);
    }

    @Override
    public WeChat findById(Long id) {
        return wechatDAO.getById(id);
    }

    @Override
    public Paging<WeChat> findByConditions(WeChat weChat) {
        
        // 父类
        if(weChat.getInfoClass() != null){
            if (weChat.getInfoClass().getId() % Constant.CLASS_PARENT_CLASS_POINT != 0) {
                InfoClass clazz = infoClassService.findById(weChat.getInfoClass().getId());
                weChat.getInfoClass().setParentId(clazz.getParentId());
            } else if(weChat.getInfoClass().getId() % Constant.CLASS_PARENT_CLASS_POINT == 0){
                weChat.getInfoClass().setParentId(weChat.getInfoClass().getId());
            }
        }
        return wechatDAO.getByConditions(weChat);
    }

    @Override
    public void batchSave(List<WeChat> weChats) {
        wechatDAO.batchSave(weChats);
    }

    @Override
    public Paging<WeChat> findByParentInfoClass(InfoClass infoClass) {
        infoClass.setParentId(infoClass.getId());
        return wechatDAO.getByParentInfoClass(infoClass);
    }

}
