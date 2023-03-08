package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @Author darren
 * @Date 2023/2/21 17:09
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain1002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain1002.class,args);
    }
}
