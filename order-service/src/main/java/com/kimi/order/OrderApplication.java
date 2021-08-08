package com.kimi.order;

import com.kimi.order.service.OrderServiceImpl;
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
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("order/create")
    public String create(String userId,String commodityCode,Long count,Long money){
        orderService.create(userId, commodityCode, count, money);
        return "创建订单！";
    }
}
