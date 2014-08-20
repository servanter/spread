package com.zhy.spread.dao;

import com.zhy.spread.entity.Action;

public interface ActionDAO {

    public Action saveOrUpdate(Action action);

    public Action getById(Long id);

    public Action getByWeChatId(Long id);

}
