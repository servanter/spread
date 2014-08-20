package com.zhy.spread.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.dao.RechargeDAO;
import com.zhy.spread.entity.Recharge;

@Repository
public class RechargeDAOImpl extends ParentHibernateDAO<Recharge, Long> implements RechargeDAO {

    @Override
    public Paging<Recharge> getDetailsByUserId(Recharge recharge) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("user.id", recharge.getUser().getId()));
        return queryForList(criteria, recharge);
    }

    @Override
    public Long getMaxId(String startTime, String endTime) {
        List<BigInteger> list = getSession().createSQLQuery(
                "SELECT COUNT(*) FROM spread_recharge_detail WHERE recharge_time >= ? AND recharge_time <= ? ")
                .setString(0, startTime).setString(1, endTime).list();
        if (list != null && list.size() > 0) {
            return list.get(0).longValue();
        }
        return -1L;
    }

    @Override
    public Recharge save(Recharge recharge) {
        return super.saveOrUpdate(recharge);
    }

}
