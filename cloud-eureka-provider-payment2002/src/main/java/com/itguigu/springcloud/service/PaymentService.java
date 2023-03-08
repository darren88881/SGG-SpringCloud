package com.itguigu.springcloud.service;

import com.itguigu.springcloud.entities.Payment;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:40
 */
public interface PaymentService {
    int addPayment(Payment payment);

    Payment getPaymentById(Long id);
}
