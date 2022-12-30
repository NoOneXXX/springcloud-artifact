package com.rtrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CutomerFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CutomerFeignOrder80.class, args);
    }
}
