package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/2/27 20:09
 */

@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        return result;
    }

    /**
     * 4、openFeign有一个很重要的功能：fallback，其实它是hystrix的特性
     *
     * @HystrixCommand(fallbackMethod = "paymentInfoTimeOut_FallBack",commandProperties = {
     *             @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
     *     })
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        return result;
    }

    public String paymentInfoTimeOut_FallBack(Integer id) {
        return "我是消费者80，支付系统繁忙稍后再试！";
    }

    /**
     * hystrix 全局fallback方法
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global全局异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}


