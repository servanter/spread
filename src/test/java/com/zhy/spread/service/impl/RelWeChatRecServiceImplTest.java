package com.zhy.spread.service.impl;

import java.sql.Timestamp;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.RelWeChatRecommend;
import com.zhy.spread.service.RelWeChatRecService;

public class RelWeChatRecServiceImplTest extends SuperTest {

    @Autowired
    private RelWeChatRecService relWeChatRecService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        relWeChatRecService = null;
    }

    @Test
    public void testAddOrModify() {
        RelWeChatRecommend relWeChatRecommend = new RelWeChatRecommend();
        relWeChatRecommend.setWeChatId(1L);
        relWeChatRecommend.setRecommendId(1L);
        relWeChatRecommend.setModifyTime(new Timestamp(System.currentTimeMillis()));
        relWeChatRecService.addOrModify(relWeChatRecommend);
        Assert.assertTrue("Can't save the rel wechat recommend.", relWeChatRecommend.getId() != null);
    }

}
