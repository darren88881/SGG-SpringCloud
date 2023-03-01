package com.itguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
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

    /**
     * 服务熔断 超时、异常、都会触发熔断
     * 1、默认是最近10秒内收到不小于10个请求，
     * 2、并且有60%是失败的
     * 3、就开启断路器
     * 4、开启后所有请求不再转发，降级逻辑自动切换为主逻辑，减小调用方的响应时间
     * 5、经过一段时间（时间窗口期，默认是5秒），断路器变为半开状态，会让其中一个请求进行转发。
     *      5.1、如果成功，断路器会关闭，
     *      5.2、若失败，继续开启。重复4和5
     *
     * circuitBreaker.enabled：是否开启断路器
     * circuitBreaker.requestVolumeThreshold：请求次数
     * circuitBreaker.errorThresholdPercentage：失败率达到多少后跳闸
     * circuitBreaker.sleepWindowInMilliseconds：时间窗口期
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }


    /**
     * paymentCircuitBreaker 方法的 fallback，
     * 当断路器开启时，主逻辑熔断降级，该 fallback 方法就会替换原 paymentCircuitBreaker 方法，处理请求
     *
     * @param id
     * @return
     */
    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能负数或超时或自身错误，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
