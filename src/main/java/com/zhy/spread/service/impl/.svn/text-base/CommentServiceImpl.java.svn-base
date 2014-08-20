package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.dao.CommentDAO;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Paging<Comment> findByWeChat(WeChat weChat) {
        return commentDAO.getByWeChat(weChat);
    }

    @Override
    public Comment addOrModify(Comment comment) {
        return commentDAO.saveOrUpdate(comment);
    }

}
