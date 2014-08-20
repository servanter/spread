package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.dao.UserDAO;
import com.zhy.spread.entity.User;
import com.zhy.spread.service.UserService;
import com.zhy.spread.util.MD5Utils;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Paging<User> findUsers(User user) {
        return userDAO.getUsers(user);
    }

    @Override
    public User login(User user) {
        return userDAO.getUserByNameAndPass(user.getUserName(), user.getPassword());
    }

    @Override
    public User register(User user) {
        user.setPassword(MD5Utils.getKeyedDigest(user.getPassword(), ""));
        return userDAO.saveOrUpdate(user);
    }

    @Override
    public boolean checkUserNameIsValid(String userName) {
        return userDAO.getUserByField("userName", userName) > 0 ? false : true;
    }

    @Override
    public boolean checkEmailIsValid(String email) {
        return userDAO.getUserByField("email", email) > 0 ? false : true;
    }

    @Override
    public boolean checkNicknameIsValid(String nickname) {
        return userDAO.getUserByField("nickname", nickname) > 0 ? false : true;
    }

    @Override
    public ReturnCode checkParametersIsValid(User user) {
        boolean isValid = checkUserNameIsValid(user.getUserName());
        if (!isValid) {
            return ReturnCode.USER_REGISTER_PARAMETER_USERNAME_ERROR;
        }
        isValid = checkNicknameIsValid(user.getUserName());
        if (!isValid) {
            return ReturnCode.USER_REGISTER_PARAMETER_NICKNAME_ERROR;
        }
        isValid = checkEmailIsValid(user.getUserName());
        if (!isValid) {
            return ReturnCode.USER_REGISTER_PARAMETER_EMAIL_ERROR;
        }
        return ReturnCode.OK;
    }
}
