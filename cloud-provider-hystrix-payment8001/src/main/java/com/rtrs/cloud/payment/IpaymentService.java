package com.rtrs.cloud.payment;

public interface IpaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
