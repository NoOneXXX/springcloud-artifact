package com.rtrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8002.class, args);
    }
}
