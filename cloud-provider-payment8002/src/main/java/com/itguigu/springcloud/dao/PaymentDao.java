package com.itguigu.springcloud.dao;

import com.itguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:41
 */
@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);
    Payment getPaymentById(Long id);
}
