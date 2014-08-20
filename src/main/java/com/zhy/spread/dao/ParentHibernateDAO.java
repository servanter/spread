package com.zhy.spread.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;

/**
 * DAO父类
 * 
 * @author ZhangHongyan
 */
@Repository("parentHibernateDAO")
@Scope("prototype")
public abstract class ParentHibernateDAO<T, K extends java.io.Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @PostConstruct
    public void init() {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
        }
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    protected Session openSession(){
        return sessionFactory.openSession();
    }

    protected Criteria getCriteria() {
        return sessionFactory.getCurrentSession().createCriteria(entityClass);
    }

    protected Criteria getCriteria(Session session) {
        return session.createCriteria(entityClass);
    }

    @SuppressWarnings("unchecked")
    protected T get(K k) {
        return (T) getSession().get(entityClass, k);
    }

    protected T saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
        return t;
    }
    
    protected void update(T t){
        getSession().update(t);
    }
    
    protected Long getTotalRecord(Criteria criteria) {
        return Long.parseLong(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
    }

    protected Criteria initPageParameters(Page p, Criteria criteria) {
        if (p != null) {
            criteria.setFirstResult(p.getSinceCount());
            criteria.setMaxResults(p.getPageSize());
        }
        return criteria;
    }

    protected Paging<T> queryForList(Criteria criteria, Page page) {
        long totalRecord = getTotalRecord(criteria);
        initPageParameters(page, criteria);
        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        return new Paging<T>(totalRecord, page.getPage(), page.getPageSize(), (List<T>) criteria.list());
    }

    protected List<T> queryForList(Criteria criteria) {
        return (List<T>) criteria.list();
    }

    protected T queryForObject(Criteria criteria) {
        List<T> list = criteria.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}
