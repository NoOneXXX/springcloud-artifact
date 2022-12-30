package com.rtrs.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlibabaCloudProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get_server_port")
    public String getServerPort(){
        return "this is successful invoked nacos server" + serverPort;
    }
}
