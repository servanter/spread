package com.zhy.spread.service.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.Action;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.service.ActionService;

public class ActionServiceImplTest extends SuperTest {

    @Autowired
    private ActionService actionService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        actionService = null;
    }

    @Test
    public void testAddOrModify() {
        Action action = new Action();
        action.setId(1L);
        action.setEnjoy(1);
        action.setRead(110);
        action.setShare(2);
        WeChat weChat = new WeChat();
        weChat.setId(1L);
        action.setWeChat(weChat);
        actionService.addOrModify(action);
        Assert.assertTrue("Can't save the wechat.", action.getId() > 0);
    }
}
