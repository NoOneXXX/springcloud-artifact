package com.rtrs.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

// 启动之后只要http://127.0.0.1:9001/hystrix 有豪猪页面展示出来就可以了 说明我们的服务是搭建成功的
//这个时候就可以为所欲为了
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class, args);
    }

}
