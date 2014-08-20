package com.zhy.spread.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhy.spread.dao.ConfigDAO;

@Repository
public class ConfigDAOImpl implements ConfigDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public String getValue(String key) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("SELECT s_value FROM spread_config WHERE s_key = ?");
        query.setString(0, key);
        List list = query.list();
        if(list != null && list.size() > 0){
            return (String) list.get(0);
        }
        return null;
    }

}
