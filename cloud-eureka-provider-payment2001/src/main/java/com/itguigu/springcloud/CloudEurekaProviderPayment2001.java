package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudEurekaProviderPayment2001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaProviderPayment2001.class,args);
    }
}
