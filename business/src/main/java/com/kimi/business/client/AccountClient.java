package com.kimi.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 郭富城
 */
@FeignClient(value = "account-service",path = "account")
public interface AccountClient {

    /**
     * 扣款
     * @param userId 用户id
     * @param rmb 扣多少
     * @return 结果
     */
    @PostMapping("cut")
    String cut(@RequestParam("userId") String userId,@RequestParam("rmb") Long rmb);
}
