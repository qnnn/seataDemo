package com.kimi.business;

import com.kimi.business.client.AccountClient;
import com.kimi.business.client.OrderClient;
import com.kimi.business.client.StorageClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 郭富城
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class,args);
    }
    @Resource
    private AccountClient accountClient;
    @Resource
    private OrderClient orderClient;
    @Resource
    private StorageClient storageClient;

    @PostMapping("business/create")
    @GlobalTransactional
    public String create(String userId,String commodityCode,Long count,Long money){
        // 下单
        orderClient.create(userId, commodityCode, count, money);
        // 扣款
        accountClient.cut(userId,count*money);
        // 减库存
        storageClient.cut(commodityCode,count);
        return "完成";
    }

}
