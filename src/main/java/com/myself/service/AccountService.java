package com.myself.service;

import com.myself.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public void saveAccount(Account account);

    public Account findById(Integer id);

    public void updateAccount(Account account);
}
