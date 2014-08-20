package com.zhy.spread.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Constant;
import com.zhy.spread.dao.AreaDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.Area;

@Repository
public class AreaDAOImpl extends ParentHibernateDAO<Area, Long> implements AreaDAO {

    @Override
    public List<Area> getAllAreas() {
        Criteria criteria = getCriteria();
        criteria.addOrder(Order.asc("parentId"));
        return queryForList(criteria);
    }

    @Override
    public List<Area> findSubAreas(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("parentId", id));
        return queryForList(criteria);
    }

    @Override
    public List<Area> getTopAreas() {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("parentId", Constant.PROVINCE_AREA_PARENT_ID));
        criteria.addOrder(Order.asc("id"));
        return queryForList(criteria);
    }

}
