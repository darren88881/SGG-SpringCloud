package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/3/4 8:38
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient7002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient7002.class, args);

    }
}
