package com.zhy.spread.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.CommentDAO;
import com.zhy.spread.dao.ParentHibernateDAO;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.WeChat;

@Repository
public class CommentDAOImpl extends ParentHibernateDAO<Comment, Long> implements CommentDAO {

    @Override
    public Paging<Comment> getByWeChat(WeChat weChat) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("weChat.id", weChat.getId()));
        criteria.addOrder(Order.desc("commentTime"));
        return queryForList(criteria, weChat);
    }

    @Override
    public Comment saveOrUpdate(Comment comment) {
        return super.saveOrUpdate(comment);
    }

}
