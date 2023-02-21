package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 15:00
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80.class, args);
    }
}
