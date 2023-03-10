package com.rtrs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul 或者 zookeeper 作为注册中心时注册服务
public class CloudProviderService8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderService8004.class, args);
    }
}
