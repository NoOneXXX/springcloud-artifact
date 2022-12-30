package com.rtrs.cloud.payment;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService implements IpaymentService{
    @Override
    public String paymentInfoOk(Integer id) {

        return "线程池:" + Thread.currentThread().getName() + " this is id--->" + id;
    }

    //一旦调用服务方法失败 并抛出了错误信息后 会自动调用@HystrixCommand 标注好的fallbackMethod调用类中的指定方法
    //3s 中之内是调用成功的超出时间就会报错
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
//        int i = 10/0;
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " this is id--->" + id + "  laughing and here spend 3 seconds";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池:" + Thread.currentThread().getName() + " this is id--->" + id + "  请求失败了，进入了服务降级！！！";
    }

    //========服务熔断===========================

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少次跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("***不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + " 调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后尝试id:" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback_example", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少次跳闸
            // 滚动事件窗设置， 该时间用于断路器判断健康度时需要收集信息的持续时间
            @HystrixProperty(name = "metrics.rollingStats.timeinMilliseconds",value = "10000"),
            //该属性用来设置滚动时间窗口统计指标信息时，划分”桶“的数量，断路器在收集指标信息的时候会根据设置的时间
            //窗长度拆分成多个”桶“来累计各度量值，每个”桶“记录了一段时间内的采样指标，
            // 比如10 秒内拆分10 ”桶“ 收集这样，所以timeinMilliseconds 必须能被 numBuckets 整除，否则会抛出异常
            @HystrixProperty(name = "metrics.rollingStats.numBuckets",value = "10"),
            // 该属性用来设置对命令执行的延迟是否使用百分位数来跟踪和计算，如果设置为false，那么所有的概要统计都将返回-1
            @HystrixProperty(name = "metrics.rollingPercentile.enabled",value = "false"),
            // 该属性用来设置百分位统计的滚动窗口的持续时间，单位为毫秒
            @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds",value = "60000"),
            //设置百分位统计滚动窗口中使用”桶“的数量
            @HystrixProperty(name = "metrics.rollingPercentile.numBuckets",value = "60000"),
            //设置执行过程中每个”桶“中保留的最大执行次数，如果在滚动时间窗口内发生超过该设定值的执行次数，就从最初的位置开始重写，例如，将该值设置为100，滚动窗口为
            //10秒，若在10s内一个”桶“中发生了500次执行，那么该”桶“只保留最后的100次执行的统计，另外，增加该值的大小将会增加内存量的消耗，并增加排序百分位数所需的计算时间
            @HystrixProperty(name = "metrics.rollingPercentile.bucketSize",value = "100"),
            //用来设置采集影响熔断器状态的健康快照，（请求成功，错误百分比）的间隔等待时间
            @HystrixProperty(name = "metrics.healthSnapshot.intervalinMilliseconds",value = "500"),
            // 是否开启缓存
            @HystrixProperty(name = "requestCache.enabled",value = "true"),
            //HystrixCommand 的执行和事件是否打印日志到HystrixRequestLog中
            @HystrixProperty(name = "requestLog.enabled",value = "true"),
    })
    public String paymentCircuitBreakerExample(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("***不能是负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + " 调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback_example(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后尝试id:" + id;
    }

}
