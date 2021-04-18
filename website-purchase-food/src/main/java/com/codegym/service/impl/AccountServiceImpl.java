package com.codegym.service.impl;

import com.codegym.entity.Account;
import com.codegym.repository.AccountRepository;
import com.codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account getAccountById(Integer idAccount) {
        return accountRepository.findById(idAccount).orElse(null);
    }

    @Override
    public Account getAccountByIdUserManager(Integer id) {
        return accountRepository.findByUserManager_Id(id);
    }

    @Override
    public Account getAccountByIdAdminManager(Integer id) {
        return accountRepository.findByAdminManager_Id(id);
    }

    @Override
    public void changePassword(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }
}
