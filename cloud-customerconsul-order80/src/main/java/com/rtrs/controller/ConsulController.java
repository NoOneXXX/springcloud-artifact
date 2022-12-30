package com.rtrs.controller;

import com.rtrs.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.activation.CommandObject;
import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsulController {

    public static final String INVOKING_UIL =  "http://cloud-provider-consul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul/random")
    @ResponseBody
    public CommonResult getRandom(){
        String result = restTemplate.getForObject(INVOKING_UIL+"/consul/findById", String.class);
        return new CommonResult(200, result);
    }

}
