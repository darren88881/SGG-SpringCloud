package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 开启服务提供者或消费者，客户端的支持，用来注册服务
 * @Author darren
 * @Date 2023/3/8 20:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConsumerOrder90 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConsumerOrder90.class, args);
    }
}
