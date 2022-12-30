package com.rtrs.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CloudAlibabaController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrls;



    @GetMapping("/order83")
    public String getTest(){
      return  restTemplate.getForObject(serverUrls +"/get_server_port",String.class);
    }

}
