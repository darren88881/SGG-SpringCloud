package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Author darren
 * @Date 2023/3/8 20:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConfigClient9003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConfigClient9003.class,args);
    }
}
