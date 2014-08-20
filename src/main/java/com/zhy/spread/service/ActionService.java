package com.zhy.spread.service;

import com.zhy.spread.entity.Action;

/**
 * 动作业务
 * 
 * @author ZhangHongyan
 */
public interface ActionService {

    public Action addOrModify(Action action);
    
    public Action findById(Long id);
    
    public Action findByWeChatId(Long id);
}
