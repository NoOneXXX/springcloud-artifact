package com.customer.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRibbonConfig {

    /***
     * 自定义自己的负载均衡规则 默认的是轮询
     * 现在是换成随机的，使用自定义的规则不能把这个代码放到componentscan可以扫描到的地方
     * 同时再application那边加上要实现这个规则的服务
     * @return
     */
    @Bean
    public IRule customerRules(){
        return new RandomRule();
    }
}
