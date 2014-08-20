package com.zhy.spread.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Page;
import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.dao.WeChatDAO;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.WeChat;

@Repository
public class WeChatDAOImpl extends ParentHibernateDAO<WeChat, Long> implements WeChatDAO {

    @Override
    public Paging<WeChat> getWeChats(WeChat weChat) {
        return queryForList(getCriteria(), weChat);
    }

    @Override
    public WeChat saveOrUpdate(WeChat weChat) {
        return super.saveOrUpdate(weChat);
    }

    @Override
    public Paging<WeChat> getRecommendWeChats(Recommend recommend) {
        Criteria criteria = getCriteria();
        criteria.createAlias("recommends", "r");
        criteria.add(Restrictions.eq("r.aliasCode", recommend.getAliasCode()));
        criteria.addOrder(Order.desc("r.aliasCode"));
        return queryForList(criteria, recommend);
    }

    @Override
    public Paging<WeChat> findLastWeChatsByPage(Page page) {
        Criteria criteria = getCriteria();
        criteria.addOrder(Order.desc("createTime"));
        return queryForList(criteria, page);
    }

    @Override
    public Paging<WeChat> getRecommendByKeyWords(String[] keyWords, WeChat weChat) {
        Criteria criteria = getCriteria();
        Disjunction disjunction = Restrictions.disjunction();
        for (String args : keyWords) {
            disjunction.add(Restrictions.like("keywords", args, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.like("description", args, MatchMode.ANYWHERE));
            disjunction.add(Restrictions.like("name", args, MatchMode.ANYWHERE));
        }
        criteria.add(disjunction);
        if (weChat.getInfoClass() != null) {
            criteria.createAlias("infoClass", "info");
            criteria.add(Restrictions.eq("info.parentId", weChat.getInfoClass().getParentId()));
        }
        return queryForList(criteria, weChat);
    }

    @Override
    public Paging<WeChat> getHotWeChats(Page page) {
        Query query = getSession().createQuery("FROM WeChat ORDER BY (action.enjoy + action.read + action.share) DESC ");
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getSinceCount());
        List<WeChat> result = query.list();
        return new Paging<WeChat>(result.size(), page.getPage(), page.getPageSize(), result);
    }

    @Override
    public Paging<WeChat> getByInfoClass(InfoClass infoClass) {
        Criteria criteria = getCriteria();
        criteria.createAlias("infoClass", "info");
        criteria.add(Restrictions.eq("info.id", infoClass.getId()));
        return queryForList(criteria, infoClass);
    }

    @Override
    public WeChat getById(Long id) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return queryForObject(criteria);
    }

    @Override
    public Paging<WeChat> getByConditions(WeChat weChat) {
        Criteria criteria = getCriteria();
        if (weChat.getInfoClass() != null) {
            criteria.createAlias("infoClass", "info");
            boolean isPlus = false;
            if (weChat.getInfoClass().getParentId() != null) {
                criteria.add(Restrictions.eq("info.parentId", weChat.getInfoClass().getParentId()));
                isPlus = true;
            }
            if (!isPlus && weChat.getInfoClass().getId() != null) {
                criteria.add(Restrictions.eq("info.id", weChat.getInfoClass().getId()));
            }
        }
        if (weChat.getProvince() != null) {
            criteria.add(Restrictions.eq("province.id", weChat.getProvince().getId()));
        }
        if (weChat.getCity() != null) {
            criteria.add(Restrictions.eq("city.id", weChat.getCity().getId()));
        }
        return queryForList(criteria, weChat);
    }

    @Override
    public void batchSave(List<WeChat> weChats) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < weChats.size(); i++) {
            WeChat weChat = (WeChat) weChats.get(i);
            session.save(weChat);
            if (i % 10 == 0) {
                session.flush();
                session.clear();
            }
        }
        transaction.commit();
    }

    @Override
    public Paging<WeChat> getByParentInfoClass(InfoClass infoClass) {
        Criteria criteria = getCriteria();
        criteria.createAlias("infoClass", "info");
        criteria.add(Restrictions.eq("info.parentId", infoClass.getParentId()));
        return queryForList(criteria, infoClass);
    }
}
