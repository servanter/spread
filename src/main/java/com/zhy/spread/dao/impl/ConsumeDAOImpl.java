package com.zhy.spread.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.dao.ConsumeDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.Consume;

@Repository
public class ConsumeDAOImpl extends ParentHibernateDAO<Consume, Long> implements ConsumeDAO {

    @Override
    public Consume add(Consume consume) {
        super.saveOrUpdate(consume);
        return consume;
    }

    @Override
    public Long getMaxId(String starTime, String endTime) {
        List<BigInteger> list = getSession()
                .createSQLQuery("SELECT COUNT(*) FROM spread_consume_detail WHERE create_time >= ? AND create_time <= ? ").setString(0, starTime)
                .setString(1, endTime).list();
        if (list != null && list.size() > 0) {
            return list.get(0).longValue();
        }
        return -1L;
    }

    @Override
    public List<Consume> getDetailsByConsume(Consume consume) {
        Criteria criteria = getCriteria();
        if (consume.getStartTime() != null) {
            criteria.add(Restrictions.gt("startTime", consume.getStartTime()));
        }
        if (consume.getEndTime() != null) {
            criteria.add(Restrictions.lt("startTime", consume.getEndTime()));
        }
        if (consume.getRecommend() != null) {
            criteria.add(Restrictions.eq("recommend.id", consume.getRecommend().getId()));
        }
        return queryForList(criteria);
    }

}
