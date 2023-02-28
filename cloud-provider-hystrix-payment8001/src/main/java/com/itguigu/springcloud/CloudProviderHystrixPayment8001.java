package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/2/27 8:13
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudProviderHystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001.class, args);
    }
}
