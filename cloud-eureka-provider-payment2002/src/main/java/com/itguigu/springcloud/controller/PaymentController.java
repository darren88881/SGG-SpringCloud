package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import com.itguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:39
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if (result > 0) {
            return new CommonResult<Payment>(200, "add payment success");
        } else {
          return new CommonResult<Payment>(444, "add payment fail");
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult<Payment>(200,"select payment success port:" + serverPort, payment);
    }

    @GetMapping("/timeout")
    public String getPaymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
