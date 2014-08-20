package com.zhy.spread.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.Constant;
import com.zhy.spread.service.ConfigService;

public class ConfigServiceImplTest extends SuperTest{

    @Autowired
    private ConfigService configService;
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        configService = null;
    }

    @Test
    public void testGetValue() {
        System.out.println(configService.getValue(Constant.CONFIG_ACCOUNT_INIT_MONEY));
    }

}
