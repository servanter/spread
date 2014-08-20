package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.ActionDAO;
import com.zhy.spread.entity.Action;
import com.zhy.spread.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDAO actionDAO;
    
    @Override
    public Action addOrModify(Action action) {
        return actionDAO.saveOrUpdate(action);
    }

    @Override
    public Action findById(Long id) {
        return actionDAO.getById(id);
    }

    @Override
    public Action findByWeChatId(Long id) {
        return actionDAO.getByWeChatId(id);
    }

}
