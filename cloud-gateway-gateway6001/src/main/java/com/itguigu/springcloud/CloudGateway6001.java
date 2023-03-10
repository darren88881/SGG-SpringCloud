package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/3/2 10:27
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateway6001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway6001.class, args);
    }
}
