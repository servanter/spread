package com.zhy.spread.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.dao.UserDAO;
import com.zhy.spread.entity.User;

@Repository
public class UserDAOImpl extends ParentHibernateDAO<User, Long> implements UserDAO {

    @Override
    public User getUserByNameAndPass(String userName, String password) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("password", password));
        return queryForObject(criteria);
    }

    @Override
    public Paging<User> getUsers(User user) {
        return queryForList(getCriteria(), user);
    }

    @Override
    public User saveOrUpdate(User user) {
        return super.saveOrUpdate(user);
    }

    @Override
    public int getUserByField(String key, String userName) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq(key, userName));
        return getTotalRecord(criteria).intValue();
    }

}
