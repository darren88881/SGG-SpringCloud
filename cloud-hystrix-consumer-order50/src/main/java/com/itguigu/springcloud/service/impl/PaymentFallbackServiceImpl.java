package com.itguigu.springcloud.service.impl;

import com.itguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * 通配服务降级,解决服务端宕机或关闭
 * @Author darren
 * @Date 2023/3/8 16:58
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(final Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(final Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
