package com.myself.dao;


import com.myself.domain.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> findAll();

    public void saveAccount(Account account);

    public Account findById(Integer id);

    public void updateAccount(Account account);
}
