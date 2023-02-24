package com.itguigu.springcloud.service;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @Author darren
 * @Date 2023/2/24 13:26
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
