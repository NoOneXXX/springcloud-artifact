package com.rtrs.controller;


import com.rtrs.entities.CommonResult;
import com.rtrs.entities.Payment;
import com.rtrs.lbs.LbImpl;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController

@RequestMapping("/customer")
public class OrderController {

    //    public static final String  PAYMENT_URL="http://localhost:8001";
//    public static final String  PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-HYSTRIX-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LbImpl lb;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
//        log.info("this is starting here ");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }


    @GetMapping("/getpayment/{id}")
    public CommonResult getPaymenById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/findById/"+ id, CommonResult.class);
    }

    @GetMapping("/getpayment/feign/{id}")
    public String getPaymenFeignById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/feign/timeout", String.class);
    }


    @GetMapping("/lb/getpayment/{id}")
    public CommonResult getLb(@PathVariable Long id){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstanceList == null || serviceInstanceList.size() <= 0)
        {
            return null;
        }
        ServiceInstance instance = lb.instances(serviceInstanceList);
        URI uri =  instance.getUri();
        String host = instance.getHost();
        return restTemplate.getForObject(uri + "/payment/findById/"+ id, CommonResult.class);
    }


    @GetMapping("/payment/zipkin")
    public String getZipkin(){
        System.out.println("test here");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }

}
