package com.zhy.spread.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Constant;
import com.zhy.spread.dao.InfoClassDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.InfoClass;

@Repository
public class InfoClassDAOImpl extends ParentHibernateDAO<InfoClass, Long> implements InfoClassDAO {

    @Override
    public List<InfoClass> getAll() {
        Criteria criteria = getCriteria();
        // List l = getSession().createSQLQuery("select c.*,cc.title as parentTitle from spread_info_class c left join spread_info_class cc on cc.id = c.parent_id").list();
        return queryForList(criteria);
    }

    @Override
    public InfoClass saveOrUpdate(InfoClass infoClass) {
        return super.saveOrUpdate(infoClass);
    }

    @Override
    public List<InfoClass> getSubClasses(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("parentId", id));
        return queryForList(criteria);
    }

    @Override
    public List<InfoClass> getTopClasses() {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("parentId", Constant.INFOCLASS_PARENT_ID));
        return queryForList(criteria);
    }

    @Override
    public InfoClass getById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return queryForObject(criteria);
    }
}
