package com.rtrs.lbs;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoabBalances {
    ServiceInstance instances(List<ServiceInstance> isntances);
}
