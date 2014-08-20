package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.RelWeChatRecDAO;
import com.zhy.spread.entity.RelWeChatRecommend;

@Service
public class RelWeChatRecServiceImpl implements com.zhy.spread.service.RelWeChatRecService {

    @Autowired
    private RelWeChatRecDAO relWeChatDAO;
    
    @Override
    public RelWeChatRecommend addOrModify(RelWeChatRecommend relWeChatRecommend) {
        return relWeChatDAO.saveOrUpdate(relWeChatRecommend);
    }

}
