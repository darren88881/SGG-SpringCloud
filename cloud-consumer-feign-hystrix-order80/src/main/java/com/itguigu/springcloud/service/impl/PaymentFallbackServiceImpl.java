package com.itguigu.springcloud.service.impl;

import com.itguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 服务降级类
 * @Author darren
 * @Date 2023/3/1 10:40
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(final Integer id) {
        return "服务降级类：PaymentFallbackService paymentInfoOK fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfoTimeOut(final Integer id) {
        return "服务降级类：PaymentFallbackService paymentInfoTimeOut fall back-paymentInfo_OK";
    }
}
