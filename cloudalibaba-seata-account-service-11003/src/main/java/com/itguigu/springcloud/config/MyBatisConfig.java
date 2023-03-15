package com.itguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Author darren
 * @Date 2023/3/15 10:54
 */
@Configuration
@MapperScan({"com.itguigu.springcloud.dao"})
public class MyBatisConfig {
}
