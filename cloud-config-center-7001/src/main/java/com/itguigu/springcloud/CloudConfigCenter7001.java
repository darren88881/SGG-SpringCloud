package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 * @Author darren
 * @Date 2023/3/3 11:44
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter7001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter7001.class, args);

    }
}
