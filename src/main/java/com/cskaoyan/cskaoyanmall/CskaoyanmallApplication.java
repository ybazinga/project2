package com.cskaoyan.cskaoyanmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cskaoyan.cskaoyanmall.mapper")
public class CskaoyanmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CskaoyanmallApplication.class, args);
    }

}
