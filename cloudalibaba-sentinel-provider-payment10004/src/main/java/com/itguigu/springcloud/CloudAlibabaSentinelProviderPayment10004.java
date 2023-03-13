package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/3/13 13:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinelProviderPayment10004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSentinelProviderPayment10004.class, args);
    }
}
