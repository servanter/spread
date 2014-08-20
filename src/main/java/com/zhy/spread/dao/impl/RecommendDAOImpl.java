package com.zhy.spread.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.dao.RecommendDAO;
import com.zhy.spread.entity.Recommend;

@Repository
public class RecommendDAOImpl extends ParentHibernateDAO<Recommend, Long> implements RecommendDAO {

    @Override
    public Recommend saveOrUpdate(Recommend recommend) {
        return super.saveOrUpdate(recommend);
    }

    @Override
    public List<Recommend> getAllRecommends() {
        return queryForList(getCriteria());
    }

    @Override
    public Recommend getById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return queryForObject(criteria);
    }

}
