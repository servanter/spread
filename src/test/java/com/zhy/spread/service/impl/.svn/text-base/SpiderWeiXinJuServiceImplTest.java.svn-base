package com.zhy.spread.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.spider.SpiderWeiXinJuService;

public class SpiderWeiXinJuServiceImplTest extends SuperTest{

    @Autowired
    private SpiderWeiXinJuService spiderWeiXinJuService;
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        spiderWeiXinJuService = null;
    }

    @Test
    public void testFetch() throws Exception{
        spiderWeiXinJuService.fetch("http://www.weixinju.com/t3425.html");
    }

}
