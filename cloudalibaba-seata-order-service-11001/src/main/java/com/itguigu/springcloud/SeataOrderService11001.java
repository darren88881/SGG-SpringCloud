package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * exclude = DataSourceAutoConfiguration.class 取消数据源的自动创建,
 * 读取自定义的DataSourceProxyConfig.class类，使用Seata对数据源进行代理
 * @Author darren
 * @Date 2023/3/14 9:54
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataOrderService11001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService11001.class, args);
    }
}

