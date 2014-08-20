package com.zhy.spread.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.service.AreaService;

public class AreaServiceImplTest extends SuperTest {

    @Autowired
    private AreaService areaService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        areaService = null;
    }

    @Test
    public void testFindAllAreas() {
        List<Object> result = areaService.findAllAreas();
        Assert.assertTrue("Can't find the areas", result != null && result.size() > 0);
    }

}
