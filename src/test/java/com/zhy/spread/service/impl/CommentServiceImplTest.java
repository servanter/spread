package com.zhy.spread.service.impl;

import java.sql.Timestamp;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.Comment;
import com.zhy.spread.entity.User;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.CommentService;

public class CommentServiceImplTest extends SuperTest{

    @Autowired
    private CommentService commentService;
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        commentService = null;
    }

    @Test
    public void testFindByWeChat() {
        WeChat chat = new WeChat();
        chat.setId(1L);
        Paging<Comment> result = commentService.findByWeChat(chat);
        System.out.println(result.getTotalRecord());
    }

    @Test
    public void testAddOrModify() {
        WeChat chat = new WeChat();
        chat.setId(1L);
        User user = new User();
        user.setId(1L);
        Comment comment = new Comment();
        comment.setWeChat(chat);
        comment.setUser(user);
        comment.setUserName("213421");
        comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
        comment.setPicUrl("duface.png");
        comment.setContent("zxc");
        comment.setIsValid(true);
        commentService.addOrModify(comment);
        Assert.assertTrue("Can't save the comment", comment.getId() != null && comment.getId() > 0L);
    }

}
