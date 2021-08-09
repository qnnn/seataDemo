package com.kimi.business.service;

import com.kimi.business.client.AccountClient;
import com.kimi.business.client.OrderClient;
import com.kimi.business.client.StorageClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭富城
 */
@Service
public class BusinessServiceImpl {

    @Resource
    private AccountClient accountClient;
    @Resource
    private OrderClient orderClient;
    @Resource
    private StorageClient storageClient;

    @GlobalTransactional
    public void create(String userId,String commodityCode,Long count,Long money){
        // 下单
        orderClient.create(userId, commodityCode, count, money);
        // 扣款
        accountClient.cut(userId,count*money);
        // 减库存
        storageClient.cut(commodityCode,count);
    }
}
