package com.itguigu.springcloud;

import com.itguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Ribbon：负载均衡
 *
 * @Author darren
 * @Date 2023/2/20 15:00
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-EUREKA-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class CloudEurekaConsumerOrder20 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaConsumerOrder20.class, args);
    }
}
