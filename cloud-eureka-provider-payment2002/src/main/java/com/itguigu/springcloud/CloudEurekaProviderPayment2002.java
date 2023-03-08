package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:27
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudEurekaProviderPayment2002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaProviderPayment2002.class,args);
    }
}
