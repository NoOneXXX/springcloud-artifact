package com.rtrs.controller;

import com.rtrs.entities.CommonResult;
import com.rtrs.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {

    @Resource
    private PaymentFeignService paymentFeignService;



    @GetMapping("/getpayment/feign/{id}")
    @ResponseBody
    public CommonResult getPaymenFeignById(@PathVariable Long id){
        return paymentFeignService.findById(id);
    }


    @GetMapping("/getpayment/feign/timeout")
    @ResponseBody
    public String getPaymenFeignById(){
        //客户端默认等待是1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
