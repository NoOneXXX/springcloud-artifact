package com.rtrs.controller;


import com.rtrs.entities.CommonResult;
import com.rtrs.entities.Payment;
import com.rtrs.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){

       int i = paymentService.create(payment);
       if (i > 0 ){
           return new CommonResult(200, "success insert into db : " + serverPort);
       }
        return new CommonResult(500, "fail to do it: " + serverPort);
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public CommonResult findById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("print data");
        if (Objects.nonNull(payment))
            return new CommonResult(200, "success port:" + serverPort, payment);
        return new CommonResult(5000, "fail");
    }

    @GetMapping(value = "/feign/timeout")
    @ResponseBody
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/get/infos")
    @ResponseBody
    public String getInfos(){
        return serverPort + "<<<>>>>" + UUID.randomUUID();
    }

    @GetMapping(value = "/lb/infos")
    @ResponseBody
    public String getLbInfos(){
        return serverPort + "<<<>>>>" + UUID.randomUUID();
    }

}
