package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * @Author darren
 * @Date 2023/3/1 14:29
 */
@SpringBootApplication
@EnableHystrixDashboard
public class CloudHystrixDashboard5002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixDashboard5002.class, args);
    }
}
