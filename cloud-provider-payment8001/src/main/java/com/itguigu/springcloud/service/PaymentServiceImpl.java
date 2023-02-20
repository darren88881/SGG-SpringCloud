package com.itguigu.springcloud.service;

import com.itguigu.springcloud.dao.PaymentDao;
import com.itguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:40
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(final Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(final Long id) {
        return paymentDao.getPaymentById(id);
    }
}
