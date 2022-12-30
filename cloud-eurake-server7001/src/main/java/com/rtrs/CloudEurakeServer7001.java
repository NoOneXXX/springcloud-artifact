package com.rtrs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//启动 EnableEurekaServer 这注解是必须加上的
@SpringBootApplication
@EnableEurekaServer
public class CloudEurakeServer7001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurakeServer7001.class, args);
    }
}
