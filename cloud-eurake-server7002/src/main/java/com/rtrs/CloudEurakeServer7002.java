package com.rtrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurakeServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurakeServer7002.class, args);
    }
}
