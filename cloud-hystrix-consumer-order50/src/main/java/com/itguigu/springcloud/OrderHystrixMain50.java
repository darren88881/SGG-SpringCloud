package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @Author darren
 * @Date 2023/3/8 11:11
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain50 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain50.class, args);
    }
}
