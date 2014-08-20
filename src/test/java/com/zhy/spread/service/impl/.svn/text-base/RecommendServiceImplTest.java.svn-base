package com.zhy.spread.service.impl;

import java.sql.Timestamp;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.Recommend;
import com.zhy.spread.service.RecommendService;

public class RecommendServiceImplTest extends SuperTest {

    @Autowired
    private RecommendService recommendService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        recommendService = null;
    }

    @Test
    public void testAddOrModify() {
        Recommend recommend = new Recommend();
        recommend.setRecommedName("首页banner");
        recommend.setAliasCode(100);
        recommend.setDescription("大图");
        recommend.setMaxPosition(5);
        recommend.setCurrentSurplusPosition(5);
        recommend.setPrice(100);
        Assert.assertTrue("Can't save the recomment", recommendService.addOrModify(recommend).getId() != null);
        Assert.assertTrue("Can't find the recommends ?", recommendService.findAllRecommends().size() > 0);
    }
}
