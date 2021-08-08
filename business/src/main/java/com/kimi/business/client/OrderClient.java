package com.kimi.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 郭富城
 */
@FeignClient(value = "order-service",path = "order")
public interface OrderClient {
    /**
     * 创建订单
     * @param userId 用户id
     * @param commodityCode 账户余额
     * @param count 数量
     * @param money 单价
     * @return 结果
     */
    @PostMapping("create")
    String create(@RequestParam("userId") String userId,@RequestParam("commodityCode") String commodityCode,@RequestParam("count") Long count,@RequestParam("money") Long money);
}
