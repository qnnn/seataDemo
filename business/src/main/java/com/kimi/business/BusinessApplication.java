package com.kimi.business;

import com.kimi.business.service.BusinessServiceImpl;
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
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class,args);
    }

    @Autowired
    private BusinessServiceImpl businessService;

    @PostMapping("business/create")
    public String create(String userId,String commodityCode,Long count,Long money){
        businessService.create(userId, commodityCode, count, money);
        return "全局事务";
    }

}
