package com.kimi.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 郭富城
 */
@FeignClient(value = "storage-service",path = "storage")
public interface StorageClient {

    /**
     * 减库存
     * @param commodityCode 商品号
     * @param count 数量
     * @return 结果
     */
    @PostMapping("cut")
    String cut(@RequestParam("commodityCode")String commodityCode,@RequestParam("count") Long count);

}
