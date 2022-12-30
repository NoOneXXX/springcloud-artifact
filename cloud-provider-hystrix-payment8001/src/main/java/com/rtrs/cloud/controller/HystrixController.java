package com.rtrs.cloud.controller;

import com.rtrs.cloud.payment.IpaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixController {

    @Resource
    private IpaymentService ipaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/info/{id}")
    @ResponseBody
    public String paymentInfoOk(@PathVariable Integer id){
        return ipaymentService.paymentInfoOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @ResponseBody
    public String paymentInfoTimeout(@PathVariable Integer id){
        return ipaymentService.paymentInfoTimeout(id);
    }


    //===服务熔断
    @GetMapping("payment/circurit/breaker/payment/{id}")
    public String paymentCircuritBreaker(@PathVariable("id") Integer id){
        return ipaymentService.paymentCircuitBreaker(id);
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "this is for zipkin server invoked ,and succuessful";
    }
}
