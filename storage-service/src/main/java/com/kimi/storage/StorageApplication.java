package com.kimi.storage;

import com.kimi.storage.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郭富城
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@FeignClient
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class,args);
    }

    @Autowired
    private StorageServiceImpl storageService;

    @PostMapping("storage/cut")
    public String cut(String commodityCode,Long count){
        storageService.cut(commodityCode,count);
        return "减库存！";
    }
}
