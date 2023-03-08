package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @Author darren
 * @Date 2023/2/21 15:49
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain1003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain1003.class,args);
    }
}