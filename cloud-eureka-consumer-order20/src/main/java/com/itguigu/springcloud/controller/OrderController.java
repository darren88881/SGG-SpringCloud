package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/2/20 15:01
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-EUREKA-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/addPayment",
                payment, CommonResult.class);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id ,
                CommonResult.class);
    }

    @GetMapping("/getPaymentForEntityById/{id}")
    public CommonResult<Payment> getPaymentForEntityById(@PathVariable Long id){

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(
                PAYMENT_URL + "/payment/getPaymentById/" + id,
                CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping("/getPaymentZipkin")
    public String getPaymentZipkin(){
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return forObject;
    }

}
