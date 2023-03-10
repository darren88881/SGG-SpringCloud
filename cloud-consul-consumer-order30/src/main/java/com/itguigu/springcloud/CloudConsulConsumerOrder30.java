package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulConsumerOrder30 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsulConsumerOrder30.class, args);
    }
}
