package com.cqupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cqupt.dao")
public class AdminCategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminCategoryApplication.class,args);
    }
}
