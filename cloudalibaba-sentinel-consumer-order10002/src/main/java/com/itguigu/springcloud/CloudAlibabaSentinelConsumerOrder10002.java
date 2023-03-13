package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @Author darren
 * @Date 2023/3/13 12:32
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaSentinelConsumerOrder10002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelConsumerOrder10002.class, args);
    }
}
