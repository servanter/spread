package com.zhy.spread.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.dao.ActionDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.Action;

@Repository
public class ActionDAOImpl extends ParentHibernateDAO<Action, Long> implements ActionDAO {

    @Override
    public Action saveOrUpdate(Action action) {
        return super.saveOrUpdate(action);
    }

    @Override
    public Action getById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return queryForObject(criteria);
    }

    @Override
    public Action getByWeChatId(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("weChat.id", id));
        return queryForObject(criteria);
    }

}
