package com.zhy.spread.service.impl;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.entity.Account;
import com.zhy.spread.entity.AccountStatusEnum;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.AccountService;

public class AccountServiceImplTest extends SuperTest {

    @Autowired
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        accountService = null;
    }

    @Test
    public void testAddModifyAndFind() {
        Account account = new Account();
        account.setUser(new User(1L));
        account.setStatus(AccountStatusEnum.AVALIABLE.getCode());
        account.setTotalMoney(1000L);
        accountService.add(account);
        account.setTotalMoney(1000L);
        account = accountService.modifyAccountMoney(account);
        account.setStatus(3);
        accountService.modifyAccountStatus(account);
        Account a = accountService.findById(account.getId());
        Assert.assertTrue("Can't find the insert account", a != null && a.getTotalMoney() == 1000 && a.getStatus() == 3);
    }

}
