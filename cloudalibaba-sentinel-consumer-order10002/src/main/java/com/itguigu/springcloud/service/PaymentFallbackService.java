package com.itguigu.springcloud.service;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 *
 * @Author darren
 * @Date 2023/3/13 14:15
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(final Long id) {
        return new CommonResult<>(446, "服务降级返回,---PaymentFallbackService",
                new Payment(id, "errorSerial"));
    }
}
