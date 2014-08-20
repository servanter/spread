package com.zhy.spread.dao;

import com.zhy.spread.entity.Account;

public interface AccountDAO {

    public Account getById(Long id);

    public Account getByUserId(Long userId);

    public Account updateAccount(Account account);

    public Account save(Account account);

}
