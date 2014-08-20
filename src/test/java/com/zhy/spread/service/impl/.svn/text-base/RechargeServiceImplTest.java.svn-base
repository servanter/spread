package com.zhy.spread.service.impl;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.Paging;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.Recharge;
import com.zhy.spread.entity.RechargeTypeEnum;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.RechargeService;

public class RechargeServiceImplTest extends SuperTest {

    @Autowired
    private RechargeService rechargeService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        rechargeService = null;
    }

    @Test
    public void testAddAndFindDetailsByUserId() {
        Recharge recharge = new Recharge();
        recharge.setUser(new User(1L));
        recharge.setRechargeType(RechargeTypeEnum.ALIPAY_WEB_PAY.getCode());
        recharge.setReturnCode(ReturnCode.OK.getCode());
        recharge.setMoney(500L);
        rechargeService.add(recharge);
        Assert.assertTrue("Can't insert recharge detail ?", recharge.getId() != null);
        Paging<Recharge> list = rechargeService.findDetailsByUserId(recharge);
        Assert.assertTrue("Can't find the recharge details ?", list.getTotalRecord() > 0);
    }

}
