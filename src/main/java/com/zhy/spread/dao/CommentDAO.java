package com.zhy.spread.dao;

import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.WeChat;

public interface CommentDAO {

    public Paging<Comment> getByWeChat(WeChat weChat);

    public Comment saveOrUpdate(Comment comment);

}
