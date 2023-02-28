package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 3、openFeign整合了hystrix做熔断处理，同时，可以和ribbon客户端负载均衡、Eureka注册中心配合使用，
 *   实现负载均衡的客户端。
 *
 * @Author darren
 * @Date 2023/2/27 19:49
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CloudConsumerFeignHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignHystrixOrder80.class, args);
    }
}
