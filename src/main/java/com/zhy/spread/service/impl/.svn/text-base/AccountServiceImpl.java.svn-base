package com.zhy.spread.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhy.spread.dao.AccountDAO;
import com.zhy.spread.entity.Account;
import com.zhy.spread.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account findById(Long id) {
        return accountDAO.getById(id);
    }

    @Override
    public Account findByUserId(Long userId) {
        return accountDAO.getByUserId(userId);
    }

    @Override
    public Account modifyAccountMoney(Account account) {
        return accountDAO.updateAccount(account);
    }

    @Override
    public Account modifyAccountStatus(Account account) {
        return accountDAO.updateAccount(account);
    }

    @Override
    public Account add(Account account) {
        return accountDAO.save(account);
    }

}
