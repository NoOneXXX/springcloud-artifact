package com.rtrs.controller;

import com.rtrs.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OderZkController {
    public static final String INVOKING_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zkorder")
    @ResponseBody
    public CommonResult getTest(){
        String result = restTemplate.getForObject(INVOKING_URL + "/zookeeper//findById/" + 12, String.class);
        return new CommonResult(200, result);
    }
}
