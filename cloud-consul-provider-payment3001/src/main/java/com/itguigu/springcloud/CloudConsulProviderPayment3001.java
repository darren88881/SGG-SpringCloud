package com.itguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulProviderPayment3001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulProviderPayment3001.class, args);
    }
}
