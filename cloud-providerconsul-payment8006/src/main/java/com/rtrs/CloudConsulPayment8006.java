package com.rtrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsulPayment8006.class, args);
    }
}
