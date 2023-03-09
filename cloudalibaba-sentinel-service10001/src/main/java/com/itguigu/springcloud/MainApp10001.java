package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/3/9 14:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp10001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApp10001.class,args);
    }
}
