package com.frace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        System.out.println("开启成功");
        SpringApplication.run(MySpringBootApplication.class,args);
    }
}
