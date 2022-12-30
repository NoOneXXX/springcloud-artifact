package com.rtrs.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rtrs.cloud.service.IFeignPayment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalFallback2")
public class FeignHystrixController {

    @Resource
    private IFeignPayment feignPayment;

    @GetMapping("/customer/payment/ok/{id}")
    public String getInfoId(@PathVariable("id") Integer id){
        return feignPayment.paymentInfoOk(id);
    }

    @GetMapping("/customer/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "orderTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String getTimeoutId(@PathVariable("id") Integer id){
        return feignPayment.paymentInfoTimeout(id);
    }

    public String orderTimeoutFallbackMethod(Integer id){
        return "我是消费端80，现在是服务降级处理!!!";
    }

    @GetMapping("/customer/payment/global/timeout/{id}")
    @HystrixCommand
    public String getGobleTimeoutId(@PathVariable("id") Integer id){
        return feignPayment.paymentInfoTimeout(id);
    }
    //下面是全局的fallback 虽然全局变量会好点 但是还是会冗余
    public String globalFallback2(){
        return "全局的服务降级处理!!!";
    }


    @GetMapping("/customer/payment/feign/timeout/{id}")
    public String getCustomersTimeoutId(@PathVariable("id") Integer id){
        return feignPayment.paymentInfoTimeout(id);
    }

    @GetMapping("/customer/payment/feign/info/{id}")
    public String getCustomersInfoId(@PathVariable("id") Integer id){
        return feignPayment.paymentInfoOk(id);
    }



}
