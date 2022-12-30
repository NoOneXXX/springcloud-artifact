package com.rtrs.cloud.service;


import org.springframework.stereotype.Component;

@Component
public class feignPaymentFallback implements IFeignPayment{
    @Override
    public String paymentInfoOk(Integer id) {
        return "调用信息失败";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "调用超时信息失败，这个";
    }
}
