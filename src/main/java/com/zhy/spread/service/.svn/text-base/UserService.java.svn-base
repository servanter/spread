package com.zhy.spread.service;

import com.zhy.spread.common.Paging;
import com.zhy.spread.common.ReturnCode;
import com.zhy.spread.entity.User;

/**
 * 用户业务
 * 
 * @author ZhangHongyan
 */
public interface UserService {

    /**
     * 新增用户
     * 
     * @author ZhangHongyan
     * @param user
     * @return
     */
    public User register(User user);

    /**
     * 登陆
     * 
     * @author ZhangHongyan
     * @param userName
     * @param password
     * @return
     */
    public User login(User user);

    /**
     * 查询用户
     * 
     * @author ZhangHongyan
     * @param user
     * @return
     */
    public Paging<User> findUsers(User user);

    /**
     * 校验用户名是否可用<br>
     * if true 可用
     * 
     * @author ZhangHongyan
     * @param userName
     * @return
     */
    public boolean checkUserNameIsValid(String userName);

    /**
     * 校验昵称是否可用<br>
     * if true 可用
     * 
     * @author ZhangHongyan
     * @param nickname
     * @return
     */
    public boolean checkNicknameIsValid(String nickname);

    /**
     * 校验email是否可用<br>
     * if true 可用
     * 
     * @author ZhangHongyan
     * @param email
     * @return
     */
    public boolean checkEmailIsValid(String email);
    
    /**
     * 验证注册参数是否可用
     *
     * @author ZhangHongyan
     * @param user
     * @return
     */
    public ReturnCode checkParametersIsValid(User user);
}
