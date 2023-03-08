package com.itguigu.springcloud.service;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * 2、可以把openFegin理解为是controller层或是service层。可以取代springmvc控制层作为请求映射，
 *   亦或是作为service层处理逻辑，只不过这里，openFeign只是做一个请求转发的逻辑操作。
 * @Author darren
 * @Date 2023/2/24 13:26
 */
@Component
@FeignClient(value = "CLOUD-EUREKA-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String getPaymentTimeout();
}
