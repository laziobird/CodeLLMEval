package com.next.ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.next.ai.dao")
public class ApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class, args);
    }
}