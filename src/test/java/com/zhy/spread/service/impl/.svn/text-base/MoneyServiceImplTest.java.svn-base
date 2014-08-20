package com.zhy.spread.service.impl;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.Consume;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.MoneyService;

public class MoneyServiceImplTest extends SuperTest {

    @Autowired
    private MoneyService moneyService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        moneyService = null;
    }

    @Test
    public void testConsume() {
        Consume consume = new Consume();
        consume.setUser(new User(1L));
        consume.setRecommend(new Recommend(1L));
        ReturnCode returnCode = moneyService.consume(consume);
        Assert.assertTrue("Can't afford the price ?", returnCode == ReturnCode.OK);
    }

    @Test
    public void testRecharge() {
    }

}
