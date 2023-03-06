package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @EnableDiscoveryClient 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 *
 * @Author darren
 * @Date 2023/3/6 17:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProviderPayment9002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9002.class,args);
    }
}
