package com.itguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *
 * @Author darren
 * @Date 2023/2/27 8:24
 */
@Service
public class PaymentService {
    /**
     * 正常访问，肯定OK
     *
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfoOK,id:  " + id + "\t"
                + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问，设置自身调用超时的峰值，峰值内正常运行，超过了峰值需要服务降级 自动调用fallbackMethod 指定的方法
     * 超时异常或者运行异常 都会进行服务降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOut_FallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int second = 3;
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + " paymentInfoTimeOut,id: " + id + "\t"
                + "O(∩_∩)O哈哈~" + "  耗时(秒): " + second;
    }

    /**
     * paymentInfoTimeOut 方法失败后 自动调用此方法 实现服务降级 告知调用者 paymentInfoTimeOut 目前无法正常调用
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeOut_FallBack(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " 系统繁忙稍后再试,id: "+ id + ", 呵呵";
    }

}
