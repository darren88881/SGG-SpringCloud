package com.itguigu.springcloud.service;

import com.itguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:10
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")
    BigDecimal money);

}
