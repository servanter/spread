package com.zhy.spread.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.InfoClass;
import com.zhy.spread.service.InfoClassService;

public class InfoClassServiceImplTest extends SuperTest {

    @Autowired
    private InfoClassService infoClassService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        infoClassService = null;
    }

    @Test
    public void testFindAllClasses() {
        List<Object> o = infoClassService.findAllClasses();
        Assert.assertTrue("Can't find the classes", o.size() > 0);
    }

    @Test
    public void testAddOrModify() {
        InfoClass infoClass = new InfoClass();
        infoClass.setTitle("31313213");
        infoClass.setContent("con");
        infoClass.setParentId(1L);
        infoClass = infoClassService.addOrModify(infoClass);
        Assert.assertTrue("Can't save the class", infoClass.getId() > 0);
    }

}
