package com.zhy.spread.service.impl;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.spread.SuperTest;
import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.UserService;

public class UserServiceImplTest extends SuperTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        userService = null;
    }

    @Test
    public void testRegisterAndFind() {
        User user = new User();
        user.setUserName("nnn");
        user.setPassword("333");
        user.setNickname("lll");
        user = userService.register(user);
        Assert.assertTrue("Can't save the user", user != null && user.getId() != 0);
        user.setPassword("333");
        User u = userService.login(user);
        Assert.assertTrue("Can't login the user", u != null);
        Paging<User> users = userService.findUsers(new User());
        Assert.assertTrue("Can't find the users.", users.getTotalRecord() > 0);
        Assert.assertTrue("The name already use?", !userService.checkUserNameIsValid(user.getUserName()));
        Assert.assertTrue("The nickname already use?", !userService.checkNicknameIsValid(user.getNickname()));
    }

}
