package com.kimi.business;

import com.kimi.business.client.AccountClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BusinessApplicationTest {
    @Resource
    AccountClient accountClient;

    @Test
    public void main(){
        accountClient.cut("1806300",5L);
    }
}
