package com.minghui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//取消启用springboot security后登录web页面
//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
//})
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);

    }
}
