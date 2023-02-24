package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import com.itguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/2/20 15:01
 */
@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

}
