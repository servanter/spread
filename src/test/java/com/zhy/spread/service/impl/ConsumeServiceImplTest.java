package com.zhy.spread.service.impl;

import java.sql.Timestamp;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.Account;
import com.zhy.spread.entity.Consume;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.ConsumeService;

public class ConsumeServiceImplTest extends SuperTest {

    @Autowired
    private ConsumeService consumeService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        consumeService = null;
    }

    @Test
    public void testConsume() {
        Consume consume = new Consume();
        consume.setUser(new User(1L));
        consume.setAccount(new Account(1L));
        consume.setRecommend(new Recommend(1L));
        consume.setCurTotalMoney(1000L);
        consume.setPrice(100);
        consume.setStartTime(new Timestamp(System.currentTimeMillis()));
        consume.setEndTime(new Timestamp(System.currentTimeMillis() + 100000000));
        consume = consumeService.add(consume);
        Assert.assertTrue("Isn't ok ?", consume.getId() != null);

        consume.setStartTime(new Timestamp(System.currentTimeMillis() - 1000 * 60));
        consume.setEndTime(new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60));
        List<Consume> consumes = consumeService.findDetailsByConsume(consume);
        Assert.assertTrue("Can't find the consumes ?", consumes != null && consumes.size() > 0);
        System.out.println("============list: " + consumes.size());
    }

}
