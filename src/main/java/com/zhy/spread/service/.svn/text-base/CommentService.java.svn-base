package com.zhy.spread.service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.WeChat;

public interface CommentService {

    /**
     * 根据微信ID获取评论
     *
     * @author ZhangHongyan
     * @param weChat
     * @return
     */
    public Paging<Comment> findByWeChat(WeChat weChat);

    /**
     * 评论
     *
     * @author ZhangHongyan
     * @param comment
     * @return
     */
    public Comment addOrModify(Comment comment);
}
