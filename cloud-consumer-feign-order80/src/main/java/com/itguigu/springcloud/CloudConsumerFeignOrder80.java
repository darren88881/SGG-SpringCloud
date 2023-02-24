package com.itguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @Author darren
 * @Date 2023/2/20 15:00
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder80.class, args);
    }
}
