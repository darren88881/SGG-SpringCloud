package com.itguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 1、openFeign是一个HTTP客户端，它融合了springmvc的注解，使之可以用REST风格的映射来请求转发。
 *
 * 2、可以把openFegin理解为是controller层或是service层。可以取代springmvc控制层作为请求映射，
 *    亦或是作为service层处理逻辑，只不过这里，openFeign只是做一个请求转发的逻辑操作。
 *
 * 3、openFeign整合了hystrix做熔断处理，同时，可以和ribbon客户端负载均衡、Eureka注册中心配合使用，
 *    实现负载均衡的客户端。
 *
 * 4、openFeign有一个很重要的功能：fallback，其实它是hystrix的特性
 *
 *
 * @Author darren
 * @Date 2023/2/20 15:00
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeignOrder40 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder40.class, args);
    }
}
