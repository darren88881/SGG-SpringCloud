package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/3/13 13:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinelProviderPayment10003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelProviderPayment10003.class, args);
    }
}
