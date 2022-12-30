package com.rtrs.service;

import com.rtrs.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/findById/{id}")
    CommonResult findById(@PathVariable("id") Long id);

    //演示超时
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
