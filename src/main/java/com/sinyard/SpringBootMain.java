package com.sinyard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sinyard
 * @date 2020-08-13 14:03
 * @desc springBoot启动类
 */
@MapperScan(value = {"com.sinyard.dao"})
@SpringBootApplication
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
