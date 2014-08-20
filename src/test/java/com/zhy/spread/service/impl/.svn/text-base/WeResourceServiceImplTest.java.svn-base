package com.zhy.spread.service.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.WeChat;
import com.zhy.spread.entity.WeResource;
import com.zhy.spread.service.WeResourceService;

public class WeResourceServiceImplTest extends SuperTest {

    @Autowired
    private WeResourceService weResourceService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        weResourceService = null;
    }

    @Test
    public void testAddOrModify() {
        WeResource weResource = new WeResource();
        weResource.setUrl("www.asdasd.com");
        weResource.setIsValid(true);
        WeChat chat = new WeChat();
        chat.setId(1L);
        weResource.setWeChat(chat);
        weResourceService.addOrModify(weResource);
        Assert.assertTrue("Can't save the resource ?", weResource.getId() != null && weResource.getId() > 0L);
    }

}
