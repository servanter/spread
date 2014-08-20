package com.zhy.spread.dao;

import com.zhy.spread.common.Paging;
import com.zhy.spread.entity.User;

public interface UserDAO {

    public Paging<User> getUsers(User user);

    public User getUserByNameAndPass(String userName, String password);

    public User saveOrUpdate(User user);

    public int getUserByField(String key, String userName);

}
