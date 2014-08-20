package com.zhy.spread.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.dao.AccountDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.Account;

@Repository
public class AccountDAOImpl extends ParentHibernateDAO<Account, Long> implements AccountDAO {

    @Override
    public Account getById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return queryForObject(criteria);
    }

    @Override
    public Account getByUserId(Long userId) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("user.id", userId));
        return queryForObject(criteria);
    }

    @Override
    public Account updateAccount(Account account) {
        super.update(account);
        return account;
    }

    @Override
    public Account save(Account account) {
        return super.saveOrUpdate(account);
    }

}
