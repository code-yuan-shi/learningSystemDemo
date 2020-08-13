package com.sinyard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sinyard
 * @date 2020-08-09 15:38
 * @desc Mybatis配置类
 */
@Configuration
@MapperScan("com.sinyard.dao")  //扫描Mapper
public class MyBatisConfig {
}
