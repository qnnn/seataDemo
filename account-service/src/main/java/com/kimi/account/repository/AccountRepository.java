package com.kimi.account.repository;

import com.kimi.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author 郭富城
 */
@Repository
public interface AccountRepository  extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {
    /**
     * 通过userid查找
     * @param userId 用户id
     * @return 账户
     */
    Account findByUserId(String userId);
}
