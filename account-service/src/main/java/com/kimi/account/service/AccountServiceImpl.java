package com.kimi.account.service;

import com.kimi.account.entity.Account;
import com.kimi.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 郭富城
 */
@Service
public class AccountServiceImpl {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cut(String userId,Long rmb){
        Account account = accountRepository.findByUserId(userId);
        account.setMoney(account.getMoney()-rmb);
        accountRepository.save(account);
    }
}
