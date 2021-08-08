package com.kimi.account;

import com.kimi.account.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭富城
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("account/cut")
    public String cut(String userId,Long rmb){
        accountService.cut(userId,rmb);
        return "扣除账户余额！";
    }
}
