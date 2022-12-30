package com.rtrs.controller;

import com.rtrs.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/consul")
public class ConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/findById")
    @ResponseBody
    public CommonResult findById(){
        return new CommonResult(200,"this is right invoking : 端口号是:"+ serverPort + UUID.randomUUID());
    }
}
