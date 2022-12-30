package com.rtrs.controller;


import com.rtrs.entities.CommonResult;
import com.rtrs.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/zookeeper")

public class ZooKeeperController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/findById/{id}")
    @ResponseBody
    public CommonResult findById(@PathVariable Long id){
        return new CommonResult(200,"this is right invoking : " + id + UUID.randomUUID());
    }
}
